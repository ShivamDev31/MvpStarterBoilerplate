package com.shivamdev.mvpstarterboilerplate.features.github.details.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.shivamdev.mvpstarterboilerplate.R;
import com.shivamdev.mvpstarterboilerplate.common.base.BaseActivity;
import com.shivamdev.mvpstarterboilerplate.common.constants.BundleConstants;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.di.component.ActivityComponent;
import com.shivamdev.mvpstarterboilerplate.features.github.details.presenter.GithubDetailsPresenter;
import com.shivamdev.mvpstarterboilerplate.features.github.details.screen.GithubDetailsView;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by shivam on 22/5/17.
 */

public class GithubDetailsActivity extends BaseActivity implements GithubDetailsView {

    @BindView(R.id.tv_repo_details)
    TextView tvRepoDetails;

    @Inject
    GithubDetailsPresenter presenter;


    public static Intent getIntent(Context context, Github.GitItem gitItem) {
        Intent intent = new Intent(context, GithubDetailsActivity.class);
        intent.putExtra(BundleConstants.GITHUB_DATA, Parcels.wrap(gitItem));
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Github.GitItem github = Parcels.unwrap(getIntent()
                .getParcelableExtra(BundleConstants.GITHUB_DATA));
        presenter.showGithubDetailsOnUi(github);
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_github_details;
    }

    @Override
    protected void inject(ActivityComponent component) {
        component.inject(this);
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
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
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailsOnUi(String githubDetails) {
        tvRepoDetails.setText(githubDetails);
    }
}