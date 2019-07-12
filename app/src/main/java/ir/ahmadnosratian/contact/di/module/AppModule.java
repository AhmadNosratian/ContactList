package ir.ahmadnosratian.contact.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.ahmadnosratian.contact.data.AppDataManger;
import ir.ahmadnosratian.contact.data.DataManager;
import ir.ahmadnosratian.contact.data.local.db.AppDatabase;
import ir.ahmadnosratian.contact.data.remote.ApiService;
import ir.ahmadnosratian.contact.di.DatabaseInfo;
import ir.ahmadnosratian.contact.utilities.Const;

@Module
public class AppModule {

    @Singleton
    @Provides
    ApiService provideApiService(ApiService apiService) {
        return apiService;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatebase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName)
                .fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    DataManager provideDataManager(AppDataManger appDataManger) {
        return appDataManger;
    }

    @Provides
    @Singleton
    String provideDatabaseName() {
        return Const.DB_NAME;
    }


}
