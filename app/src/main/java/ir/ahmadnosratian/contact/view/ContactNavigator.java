package ir.ahmadnosratian.contact.view;

import java.util.List;

import ir.ahmadnosratian.contact.data.model.Contact;

public interface ContactNavigator {
    void handleError(Throwable throwable);

    void updateContac(List<Contact> contactList);
}
