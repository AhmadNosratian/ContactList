package ir.ahmadnosratian.contact;

import android.app.Application;

import ir.ahmadnosratian.contact.di.component.ApplicationComponent;
import ir.ahmadnosratian.contact.di.component.DaggerApplicationComponent;


public class App extends Application {

    static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build();

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
