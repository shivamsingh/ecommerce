package com.example.ecommerce;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class ECommerceApplication extends DaggerApplication {

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return null;
  }
}
