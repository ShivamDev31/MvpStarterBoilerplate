package com.shivamdev.mvpstarterboilerplate.common.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shivamdev.mvpstarterboilerplate.common.MvpApp;
import com.shivamdev.mvpstarterboilerplate.di.component.ActivityComponent;
import com.shivamdev.mvpstarterboilerplate.di.component.DaggerActivityComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shivam on 9/5/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    private ActivityComponent component;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        inject(getComponent());
        attachView();
    }

    protected abstract void attachView();

    protected abstract int getLayout();

    protected abstract void inject(ActivityComponent component);

    private ActivityComponent getComponent() {
        if (component == null) {
            component = DaggerActivityComponent.builder()
                    .appComponent(MvpApp.getInstance().getComponent())
                    .build();
        }
        return component;
    }

    protected void showProgressDialog(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        detachPresenter();
    }

    protected abstract void detachPresenter();
}