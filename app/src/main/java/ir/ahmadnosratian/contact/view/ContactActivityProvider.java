package ir.ahmadnosratian.contact.view;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ContactActivityProvider {

    @ContributesAndroidInjector(modules = {ContactModule.class})
    abstract ContactActivity provideContactActivity();
}
