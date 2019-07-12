package ir.ahmadnosratian.contact.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;
import ir.ahmadnosratian.contact.data.model.Contact;

@Dao
public interface ContactDao {

    @Delete
    void delete(Contact contact);

    @Query("SELECT * FROM tbl_contact WHERE name LIKE:name LIMIT 1")
    Contact findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Contact contact);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contact> contactList);

    @Query("SELECT * from tbl_contact")
    List<Contact> loadAll();

    @Query("SELECT * from tbl_contact WHERE id in (:contact_id)")
    Contact findById(int contact_id);
}
