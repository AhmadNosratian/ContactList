package ir.ahmadnosratian.contact.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ir.ahmadnosratian.contact.App;
import ir.ahmadnosratian.contact.di.builder.ActivityBuilder;
import ir.ahmadnosratian.contact.di.module.AppModule;
import ir.ahmadnosratian.contact.di.module.ApiClientModule;
import ir.ahmadnosratian.contact.di.module.ContextModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ContextModule.class, ApiClientModule.class, AppModule.class, ActivityBuilder.class})
public interface ApplicationComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

}

