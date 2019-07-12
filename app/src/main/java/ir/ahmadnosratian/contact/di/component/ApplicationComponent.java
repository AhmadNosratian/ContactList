package ir.ahmadnosratian.contact.di.component;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import ir.ahmadnosratian.contact.App;
import ir.ahmadnosratian.contact.di.module.AppModule;
import ir.ahmadnosratian.contact.di.module.ApiClientModule;
import ir.ahmadnosratian.contact.di.module.ContextModule;

@Component(modules = {ContextModule.class, ApiClientModule.class, AppModule.class})
public interface ApplicationComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

}
