package ir.ahmadnosratian.contact.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
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
        getmCompositeDisposable().add(
                getmDataManager().getContacts("gmail", "")
                        .subscribeOn(getmSchedulerProvider().io())
                        .observeOn(getmSchedulerProvider().ui())
                        .subscribe(contactResponse -> {
                            loading.setValue(false);
                            if (contactResponse != null) {
                                contactListLiveData.setValue(contactResponse);
                            }
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
