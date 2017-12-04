package com.example.ecommerce.di;

import android.app.Application;
import com.example.ecommerce.ECommerceApplication;
import com.example.ecommerce.di.module.ActivityBindingModule;
import com.example.ecommerce.di.module.NetworkModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    NetworkModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class
}) public interface AppComponent extends AndroidInjector<DaggerApplication> {

  void inject(ECommerceApplication application);

  @Component.Builder interface Builder {

    @BindsInstance AppComponent.Builder application(Application application);

    AppComponent build();
  }
}
