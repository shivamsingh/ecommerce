package com.example.ecommerce.di.module;

import com.example.ecommerce.Constant;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class NetworkModule {

  @Provides @Singleton public Gson gson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  @Provides
  @Singleton OkHttpClient httpClient() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);

    return new OkHttpClient()
        .newBuilder()
        .addInterceptor(logging)
        .build();
  }

  @Provides
  @Singleton
  protected Retrofit retrofit(Gson gson, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Constant.BASE_APP_URL)
        .client(okHttpClient)
        .build();
  }
}
