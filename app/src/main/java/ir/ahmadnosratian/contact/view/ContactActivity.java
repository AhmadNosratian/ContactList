package ir.ahmadnosratian.contact.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;
import ir.ahmadnosratian.contact.R;
import ir.ahmadnosratian.contact.ViewModelProviderFactory;
import ir.ahmadnosratian.contact.data.model.Contact;
import ir.ahmadnosratian.contact.view.adapter.ContactListAdapter;
import ir.ahmadnosratian.contact.view.adapter.ContactSelectedListener;
import ir.ahmadnosratian.contact.view.base.BaseActivity;

public class ContactActivity extends BaseActivity implements ContactNavigator, ContactSelectedListener {
    private static final String TAG = "ContactActivity";


    @Inject
    ContactListAdapter adapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    @Inject
    ViewModelProviderFactory factory;

    private ContactViewModel mContectViewModel;

    @BindView(R.id.rv_mainActivity)
    RecyclerView recyclerView;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mContectViewModel = ViewModelProviders.of(this, factory).get(ContactViewModel.class);
        mContectViewModel.setNavigator(this);
        adapter.setListener(this);
        setupRecycler();
    }

    private void setupRecycler() {
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void handleError(Throwable throwable) {
        Log.e(TAG, "handleError: " + throwable.toString());
    }

    @Override
    public void updateContact(List<Contact> contactList) {
        adapter.addContacts(contactList);
    }

    @Override
    public void onContactSelected(Contact contact) {
        Toast.makeText(this,"I'm " +  contact.getName(), Toast.LENGTH_SHORT).show();
    }
}
