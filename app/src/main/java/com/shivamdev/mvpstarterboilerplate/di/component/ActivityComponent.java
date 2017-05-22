package com.shivamdev.mvpstarterboilerplate.di.component;

import com.shivamdev.mvpstarterboilerplate.di.module.ActivityModule;
import com.shivamdev.mvpstarterboilerplate.di.scopes.PerActivity;
import com.shivamdev.mvpstarterboilerplate.features.github.details.view.GithubDetailsActivity;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.view.GithubActivity;
import com.shivamdev.mvpstarterboilerplate.features.main.view.HomeActivity;

import dagger.Component;

/**
 * Created by shivam on 12/5/17.
 */

@PerActivity
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(GithubActivity activity);

    void inject(GithubDetailsActivity activity);
}