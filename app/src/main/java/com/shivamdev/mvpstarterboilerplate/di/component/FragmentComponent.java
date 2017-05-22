package com.shivamdev.mvpstarterboilerplate.di.component;

import com.shivamdev.mvpstarterboilerplate.di.module.FragmentModule;
import com.shivamdev.mvpstarterboilerplate.di.scopes.PerFragment;

import dagger.Component;

/**
 * Created by shivam on 12/5/17.
 */

@PerFragment
@Component(dependencies = {AppComponent.class}, modules = {FragmentModule.class})
public interface FragmentComponent {

}