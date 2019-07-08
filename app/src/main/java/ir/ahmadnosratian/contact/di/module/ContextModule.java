package ir.ahmadnosratian.contact.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ir.ahmadnosratian.contact.App;

@Module
public class ContextModule {

    private App app;

    public ContextModule(App app) {
        this.app = app;
    }

    @Provides
    Context provideContext() {
        return app.getApplicationContext();
    }


}
