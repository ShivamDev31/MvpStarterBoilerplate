package com.shivamdev.mvpstarterboilerplate.common.mvp;

/**
 * Created by shivam on 9/5/17.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V view);

    V getView();

    void detachView();

}