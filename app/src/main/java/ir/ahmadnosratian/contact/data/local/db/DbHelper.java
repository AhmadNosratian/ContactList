package ir.ahmadnosratian.contact.data.local.db;

import java.util.List;

import io.reactivex.Observable;
import ir.ahmadnosratian.contact.data.model.Contact;

public interface DbHelper {

    Observable<List<Contact>> getAllContacts();

    Observable<Boolean> insertContact(Contact contact);

    Observable<Boolean> insertAllContacts(List<Contact> contacts);

}
