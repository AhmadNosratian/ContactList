package ir.ahmadnosratian.contact.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import ir.ahmadnosratian.contact.data.local.db.DbHelper;
import ir.ahmadnosratian.contact.data.model.Contact;
import ir.ahmadnosratian.contact.data.remote.ApiService;


@Singleton
public class AppDataManger implements DataManager {

    private ApiService mApiService;

    private DbHelper mDbHelper;

    @Inject
    public AppDataManger(DbHelper dbHelper, ApiService apiService) {
        this.mApiService = apiService;
        this.mDbHelper = dbHelper;
    }

    /***
     *
     * @return all contacts saved in DB
     */
    @Override
    public Observable<List<Contact>> getAllContacts() {
        return mDbHelper.getAllContacts();
    }

    /***
     *
     * @param contact to save in DB ;
     * @return result save contact
     */
    @Override
    public Observable<Boolean> insertContact(Contact contact) {
        return mDbHelper.insertContact(contact);
    }

    /***
     *
     * @param contacts list to save in DB
     * @return the result saving contact list
     */

    @Override
    public Observable<Boolean> insertAllContacts(List<Contact> contacts) {
        return mDbHelper.insertAllContacts(contacts);
    }


    /***
     * get the contacts from the api
     * @param source for the contacts type
     * @param query for the query in contacts
     * @return list of contacts returned from api
     */
    @Override
    public Single<List<Contact>> getContacts(String source, String query) {
        return mApiService.getContacts(source, query);
    }
}
