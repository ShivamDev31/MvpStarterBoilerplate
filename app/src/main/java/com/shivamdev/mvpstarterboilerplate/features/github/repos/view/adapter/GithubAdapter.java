package com.shivamdev.mvpstarterboilerplate.features.github.repos.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shivamdev.mvpstarterboilerplate.R;
import com.shivamdev.mvpstarterboilerplate.data.model.Github;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by shivam on 16/5/17.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubHolder> {

    private List<Github.GitItem> gitReposList;

    private PublishSubject<Github.GitItem> clickPublishSubject;

    public GithubAdapter() {
        gitReposList = new ArrayList<>();
        clickPublishSubject = PublishSubject.create();
    }

    @Override
    public GithubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_github_repos,
                parent, false);
        return new GithubHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubHolder holder, int position) {
        holder.tvRepoName.setText(gitReposList.get(position).repoName);
        holder.tvRepoLanguage.setText(gitReposList.get(position).language);
    }

    @Override
    public int getItemCount() {
        return gitReposList.size();
    }

    public void updateRepos(List<Github.GitItem> gitRepos) {
        this.gitReposList.clear();
        this.gitReposList.addAll(gitRepos);
        notifyDataSetChanged();
    }

    public Observable<Github.GitItem> getRepoClicked() {
        return clickPublishSubject;
    }


    class GithubHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView tvRepoName;

        @BindView(R.id.tv_repo_language)
        TextView tvRepoLanguage;

        GithubHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> clickPublishSubject
                    .onNext(gitReposList.get(getLayoutPosition())));
        }
    }
}