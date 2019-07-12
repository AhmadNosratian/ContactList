package ir.ahmadnosratian.contact.data.local.db;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import ir.ahmadnosratian.contact.data.model.Contact;

@Singleton
public class AppDbHelper implements DbHelper {

    private AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<List<Contact>> getAllContacts() {
        return Observable.fromCallable(new Callable<List<Contact>>() {
            @Override
            public List<Contact> call() throws Exception {
                return mAppDatabase.contactDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> insertContact(Contact contact) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.contactDao().insert(contact);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertAllContacts(List<Contact> contacts) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.contactDao().insertAll(contacts);
                return true;
            }
        });
    }
}
