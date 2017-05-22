package com.shivamdev.mvpstarterboilerplate.di.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by shivam on 16/5/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ApplicationContext {
}
