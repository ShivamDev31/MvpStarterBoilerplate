package com.shivamdev.mvpstarterboilerplate.common.mvp;

/**
 * Created by shivam on 9/5/17.
 */

public interface MvpView {

    void showLoader();

    void hideLoader();

    //void showError(@StringRes int resId);

    void showError(String error);

    //void showError(Throwable throwable);

}