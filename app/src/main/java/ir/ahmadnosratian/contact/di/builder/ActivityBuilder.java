package ir.ahmadnosratian.contact.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.ahmadnosratian.contact.view.ContactActivity;
import ir.ahmadnosratian.contact.view.ContactModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {ContactModule.class})
    abstract ContactActivity bindContactActivity();

}
