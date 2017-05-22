package com.shivamdev.mvpstarterboilerplate.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by shivam on 12/5/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ApplicationContext {

}