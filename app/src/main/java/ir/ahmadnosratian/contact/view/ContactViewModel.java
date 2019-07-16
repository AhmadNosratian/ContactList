package ir.ahmadnosratian.contact.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import ir.ahmadnosratian.contact.data.DataManager;
import ir.ahmadnosratian.contact.data.model.Contact;
import ir.ahmadnosratian.contact.utils.rx.SchedulerProvider;
import ir.ahmadnosratian.contact.view.base.BaseViewModel;

public class ContactViewModel extends BaseViewModel<ContactNavigator> {


    private MutableLiveData<List<Contact>> contactListLiveData;

    private MutableLiveData<Boolean> loading;

    public ContactViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        contactListLiveData = new MutableLiveData<>();
        loading = new MutableLiveData<>();

        fetchContacts();
    }

    private void fetchContacts() {
        loading.setValue(true);
        getCompositeDisposable().add(
                getDataManager().getContacts("gmail", "")
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(contactResponse -> {
                            if (contactResponse != null) {
                                contactListLiveData.setValue(contactResponse);
                            }
                            loading.setValue(false);
                        }, throwable -> {
                            loading.setValue(false);
                            getNavigator().handleError(throwable);
                        })
        );
    }


    public LiveData<List<Contact>> getContactListLiveData() {
        return contactListLiveData;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

}
