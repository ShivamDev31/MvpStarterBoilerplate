package com.shivamdev.mvpstarterboilerplate.features.main.view;

import android.widget.EditText;

import com.shivamdev.mvpstarterboilerplate.R;
import com.shivamdev.mvpstarterboilerplate.common.base.BaseActivity;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.di.component.ActivityComponent;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.view.GithubActivity;
import com.shivamdev.mvpstarterboilerplate.features.main.presenter.HomePresenter;
import com.shivamdev.mvpstarterboilerplate.features.main.screen.HomeScreen;
import com.shivamdev.mvpstarterboilerplate.utils.Toaster;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeScreen {

    @BindView(R.id.et_git_username)
    EditText etGitUsername;

    @Inject
    HomePresenter presenter;

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void inject(ActivityComponent component) {
        component.inject(this);
    }

    @OnClick(R.id.b_fetch)
    public void fetchClicked() {
        String username = etGitUsername.getText().toString();
        presenter.loadReposFromGithub(username);
    }

    @Override
    public void showLoader() {
        showProgressDialog(getString(R.string.loading));
    }

    @Override
    public void hideLoader() {
        hideProgressDialog();
    }

    @Override
    public void showError(String error) {
        hideLoader();
        Toaster.toast(R.string.error_something_went_wrong);
    }

    @Override
    public void showEmptyUsernameError() {
        Toaster.toast(R.string.error_empty_username);
    }

    @Override
    public void loadReposInList(Github github) {
        startActivity(GithubActivity.getIntent(this, github));
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
    }
}
