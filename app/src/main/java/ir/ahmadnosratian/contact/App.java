package ir.ahmadnosratian.contact;

import android.app.Application;

import ir.ahmadnosratian.contact.di.component.ApplicationComponent;
import ir.ahmadnosratian.contact.di.component.DaggerApplicationComponent;
import ir.ahmadnosratian.contact.di.module.ContextModule;

public class App extends Application {

    static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
