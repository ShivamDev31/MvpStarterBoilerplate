package com.shivamdev.mvpstarterboilerplate.di.module;

import com.shivamdev.mvpstarterboilerplate.di.scopes.PerActivity;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.view.adapter.GithubAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shivam on 12/5/17.
 */

@Module
public class ActivityModule {

    @Provides
    @PerActivity
    GithubAdapter providesGithubAdapter() {
        return new GithubAdapter();
    }

}