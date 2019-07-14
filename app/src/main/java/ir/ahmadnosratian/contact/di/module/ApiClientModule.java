package ir.ahmadnosratian.contact.di.module;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.ahmadnosratian.contact.data.remote.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static ir.ahmadnosratian.contact.utils.Const.BASE_URL;

@Module
public class ApiClientModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ApiService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }
}
