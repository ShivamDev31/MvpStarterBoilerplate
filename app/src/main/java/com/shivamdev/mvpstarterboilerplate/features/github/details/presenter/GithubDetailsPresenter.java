package com.shivamdev.mvpstarterboilerplate.features.github.details.presenter;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BasePresenter;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.features.github.details.screen.GithubDetailsView;

import javax.inject.Inject;

/**
 * Created by shivam on 22/5/17.
 */

public class GithubDetailsPresenter extends BasePresenter<GithubDetailsView> {


    @Inject
    public GithubDetailsPresenter() {
    }


    public void showGithubDetailsOnUi(Github.GitItem github) {
        StringBuilder builder = new StringBuilder();
        builder.append(github.id).append("\n")
                .append(github.repoName).append("\n")
                .append(github.fullName).append("\n")
                .append(github.htmlUrl).append("\n")
                .append(github.description).append("\n")
                .append(github.language);
        getView().showDetailsOnUi(builder.toString());
    }
}