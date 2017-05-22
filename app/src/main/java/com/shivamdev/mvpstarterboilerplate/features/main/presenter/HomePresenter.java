package com.shivamdev.mvpstarterboilerplate.features.main.presenter;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BasePresenter;
import com.shivamdev.mvpstarterboilerplate.data.remote.ApiManager;
import com.shivamdev.mvpstarterboilerplate.features.main.screen.HomeScreen;
import com.shivamdev.mvpstarterboilerplate.utils.RxUtils;
import com.shivamdev.mvpstarterboilerplate.utils.StringUtils;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Created by shivam on 12/5/17.
 */

public class HomePresenter extends BasePresenter<HomeScreen> {

    private final ApiManager apiManager;

    @Inject
    public HomePresenter(final ApiManager apiManager) {
        this.apiManager = apiManager;
    }


    public void loadReposFromGithub(String username) {
        if (StringUtils.isEmpty(username)) {
            getView().showEmptyUsernameError();
            return;
        }
        getView().showLoader();
        Disposable disp = apiManager.loadGithubRepos(username)
                .compose(RxUtils.applySingleSchedulers())
                .subscribe(github -> {
                    getView().loadReposInList(github);
                    getView().hideLoader();
                }, error -> {
                    Timber.e(error);
                    getView().showError(error.getMessage());
                });
        addDisposable(disp);
    }
}