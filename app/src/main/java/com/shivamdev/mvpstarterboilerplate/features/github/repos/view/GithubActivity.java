package com.shivamdev.mvpstarterboilerplate.features.github.repos.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.shivamdev.mvpstarterboilerplate.R;
import com.shivamdev.mvpstarterboilerplate.common.base.BaseActivity;
import com.shivamdev.mvpstarterboilerplate.common.constants.BundleConstants;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.di.component.ActivityComponent;
import com.shivamdev.mvpstarterboilerplate.features.github.details.view.GithubDetailsActivity;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.presenter.GithubActivityPresenter;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.screen.GithubActivityScreen;
import com.shivamdev.mvpstarterboilerplate.features.github.repos.view.adapter.GithubAdapter;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class GithubActivity extends BaseActivity implements GithubActivityScreen {

    @BindView(R.id.rv_github_repos)
    RecyclerView rvGithubRepos;

    @Inject
    GithubActivityPresenter presenter;

    @Inject
    GithubAdapter githubAdapter;

    private Github github;

    public static Intent getIntent(Context context, Github github) {
        Intent intent = new Intent(context, GithubActivity.class);
        intent.putExtra(BundleConstants.GITHUB_DATA, Parcels.wrap(github));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        github = Parcels.unwrap(getIntent().getParcelableExtra(BundleConstants.GITHUB_DATA));
        setupRecyclerView();
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    private void setupRecyclerView() {
        rvGithubRepos.setLayoutManager(new LinearLayoutManager(this));
        rvGithubRepos.setAdapter(githubAdapter);
        githubAdapter.updateRepos(github.itemsList);
        listenRepoClick();
    }

    private void listenRepoClick() {
        Disposable disp = githubAdapter.getRepoClicked()
                .subscribe(new Consumer<Github.GitItem>() {
                    @Override
                    public void accept(Github.GitItem gitItem) {
                        presenter.showRepoDetails(gitItem);
                    }
                }, throwable -> {
                    Timber.e(throwable);
                    Toast.makeText(GithubActivity.this, R.string.something_bad_happened,
                            Toast.LENGTH_SHORT).show();
                });

        presenter.addDisposable(disp);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_github;
    }

    @Override
    protected void inject(ActivityComponent component) {
        component.inject(this);
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
        Toast.makeText(this, R.string.error_fetching_repos, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void detachPresenter() {
        presenter.detachView();
    }

    @Override
    public void startGithubDetailsActivity(Github.GitItem gitItem) {
        startActivity(GithubDetailsActivity.getIntent(this, gitItem));
    }
}