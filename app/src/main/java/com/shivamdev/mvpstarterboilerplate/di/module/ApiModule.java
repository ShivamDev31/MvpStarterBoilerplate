package com.shivamdev.mvpstarterboilerplate.di.module;

import com.shivamdev.mvpstarterboilerplate.data.remote.api.GithubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by shivam on 12/5/17.
 */

@Module(includes = {NetworkModule.class})
public class ApiModule {

    @Provides
    @Singleton
    GithubApi providesGithubApi(Retrofit retrofit) {
        return retrofit.create(GithubApi.class);
    }


}