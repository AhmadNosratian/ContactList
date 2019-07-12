package ir.ahmadnosratian.contact.data.local.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ir.ahmadnosratian.contact.data.local.db.dao.ContactDao;
import ir.ahmadnosratian.contact.data.model.Contact;

@Database(entities = {Contact.class}, version = 1 , exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();

}
