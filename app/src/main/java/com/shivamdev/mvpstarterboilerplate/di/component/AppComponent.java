package com.shivamdev.mvpstarterboilerplate.di.component;

import com.shivamdev.mvpstarterboilerplate.data.remote.ApiManager;
import com.shivamdev.mvpstarterboilerplate.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shivam on 12/5/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    ApiManager apiManager();

}