package ir.ahmadnosratian.contact.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_contact")
public class Contact {


    @PrimaryKey
    private int id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image")
    @Expose
    @ColumnInfo(name = "cont_image")
    private String profileImage;

    @SerializedName("phone")
    @Expose
    @ColumnInfo(name = "cont_phone")
    private String phone;

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "cont_email")
    private String email;

    @SerializedName("source")
    @Expose
    @ColumnInfo(name = "source")
    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}