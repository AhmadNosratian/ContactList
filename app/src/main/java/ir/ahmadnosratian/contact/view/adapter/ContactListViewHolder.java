package ir.ahmadnosratian.contact.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.ahmadnosratian.contact.R;
import ir.ahmadnosratian.contact.data.model.Contact;

public class ContactListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.thumbnail)
    ImageView avatarImage;

    @BindView(R.id.name)
    TextView nameTextView;

    @BindView(R.id.phone)
    TextView phoneTextView;

    private Contact contact;

    public ContactListViewHolder(@NonNull View itemView, ContactSelectedListener contactSelectedListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(v -> {
            if (contact != null) {
                contactSelectedListener.onContactSelected(contact);
            }
        });
    }

    void bind(Contact contact) {
        this.contact = contact;
        Glide.with(itemView.getContext())
                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(contact.getProfileImage()).into(avatarImage);
        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhone());
    }


}
