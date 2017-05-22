package com.shivamdev.mvpstarterboilerplate.features.main.screen;

import com.shivamdev.mvpstarterboilerplate.common.mvp.BaseView;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;

/**
 * Created by shivam on 12/5/17.
 */

public interface HomeScreen extends BaseView {

    void showEmptyUsernameError();

    void loadReposInList(Github github);
}