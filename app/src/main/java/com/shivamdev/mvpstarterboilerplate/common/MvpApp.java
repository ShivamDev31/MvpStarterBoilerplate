package com.shivamdev.mvpstarterboilerplate.common;

import android.app.Application;
import android.os.StrictMode;

import com.shivamdev.mvpstarterboilerplate.BuildConfig;
import com.shivamdev.mvpstarterboilerplate.di.component.AppComponent;
import com.shivamdev.mvpstarterboilerplate.di.component.DaggerAppComponent;
import com.shivamdev.mvpstarterboilerplate.di.module.ApiModule;
import com.shivamdev.mvpstarterboilerplate.di.module.AppModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

/**
 * Created by shivam on 9/5/17.
 */

public class MvpApp extends Application {

    private static MvpApp instance;
    private static RefWatcher refWatcher;
    private AppComponent appComponent;

    public static MvpApp getInstance() {
        return instance;
    }

    // Uncomment in case of multidex
    /*@Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (BuildConfig.DEBUG) {
            setupLeakCanary();
            setupTimber();
            enableStrictMode();
        }
        setupAppComponent();
    }

    private void setupTimber() {
        Timber.plant(new Timber.DebugTree());
    }

    private void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    private static void enableStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }

    private void setupAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

}