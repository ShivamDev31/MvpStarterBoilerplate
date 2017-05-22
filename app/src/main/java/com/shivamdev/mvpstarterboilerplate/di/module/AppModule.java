package com.shivamdev.mvpstarterboilerplate.di.module;

import android.app.Application;
import android.content.Context;

import com.shivamdev.mvpstarterboilerplate.common.MvpApp;
import com.shivamdev.mvpstarterboilerplate.data.remote.ApiManager;
import com.shivamdev.mvpstarterboilerplate.data.remote.api.GithubApi;
import com.shivamdev.mvpstarterboilerplate.di.scopes.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shivam on 12/5/17.
 */

@Module(includes = {ApiModule.class, DbModule.class})
public class AppModule {

    private MvpApp app;

    public AppModule(MvpApp app) {
        this.app = app;
    }

    @Provides
    @ApplicationContext
    Context providesContext() {
        return app;
    }

    @Provides
    Application providesApplication() {
        return app;
    }

    @Provides
    @Singleton
    ApiManager providesApiManager(GithubApi githubApi) {
        return new ApiManager(githubApi);
    }
}