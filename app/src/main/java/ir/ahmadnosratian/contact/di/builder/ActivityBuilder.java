package ir.ahmadnosratian.contact.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.ahmadnosratian.contact.view.ContactActivity;
import ir.ahmadnosratian.contact.view.ContactActivityProvider;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ContactActivityProvider.class})
    abstract ContactActivity bindContactActivity();

}
