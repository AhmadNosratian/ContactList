package ir.ahmadnosratian.contact.view;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import ir.ahmadnosratian.contact.view.adapter.ContactListAdapter;

@Module
public class ContactModule {

    @Provides
    ContactListAdapter provideContactListAdapter() {
        return new ContactListAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

}
