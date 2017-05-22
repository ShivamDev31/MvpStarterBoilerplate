package com.shivamdev.mvpstarterboilerplate.features.github.repos.presenter;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BasePresenter;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.screen.GithubActivityScreen;

import javax.inject.Inject;

/**
 * Created by shivam on 16/5/17.
 */

public class GithubActivityPresenter extends BasePresenter<GithubActivityScreen> {

    @Inject
    public GithubActivityPresenter() {
    }

    public void showRepoDetails(Github.GitItem gitItem) {
        getView().startGithubDetailsActivity(gitItem);
    }
}