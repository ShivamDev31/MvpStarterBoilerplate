package com.shivamdev.mvpstarterboilerplate.common.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by shivam on 9/5/17.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V mvpView;
    private CompositeDisposable compositeDisposable;


    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void attachView(V view) {
        this.mvpView = view;
    }

    @Override
    public V getView() {
        return mvpView;
    }

    @Override
    public void detachView() {
        if (mvpView != null) {
            mvpView = null;
        }
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }
}