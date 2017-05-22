package com.shivamdev.mvpstarterboilerplate.features.github.details.screen;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BaseView;

/**
 * Created by shivam on 22/5/17.
 */

public interface GithubDetailsView extends BaseView {

    void showDetailsOnUi(String githubDetails);
}