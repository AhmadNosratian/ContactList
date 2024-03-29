package ir.ahmadnosratian.contact;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ir.ahmadnosratian.contact.di.component.DaggerApplicationComponent;


public class App extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

}
