package ir.ahmadnosratian.contact.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ir.ahmadnosratian.contact.R;
import ir.ahmadnosratian.contact.data.model.Contact;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListViewHolder> {
    ContactSelectedListener contactSelectedListener;
    List<Contact> contactList;

    public ContactListAdapter(List<Contact> contacts) {
        this.contactList = contacts;
    }

    public void addContacts(List<Contact> contacts) {
        this.contactList = contacts;
        notifyDataSetChanged();
    }

    public void clearContacts(){
        contactList.clear();
    }

    public void setListener(ContactSelectedListener listener) {
        this.contactSelectedListener = listener;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_user_details, viewGroup, false);
        return new ContactListViewHolder(
                view, contactSelectedListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int i) {
        holder.bind(contactList.get(i));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
