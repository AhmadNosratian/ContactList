package ir.ahmadnosratian.contact.di.component;

import android.content.Context;

import dagger.Component;
import ir.ahmadnosratian.contact.MainActivity;
import ir.ahmadnosratian.contact.di.module.ApiClientModule;
import ir.ahmadnosratian.contact.di.module.ContextModule;

@Component(modules = {ContextModule.class, ApiClientModule.class})
public interface ApplicationComponent {

    void injectMainActivity(MainActivity mainActivity);

}
