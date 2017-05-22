package com.shivamdev.mvpstarterboilerplate.features.github.repos.screen;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BaseView;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;

/**
 * Created by shivam on 16/5/17.
 */

public interface GithubActivityScreen extends BaseView {

    void startGithubDetailsActivity(Github.GitItem gitItem);
}