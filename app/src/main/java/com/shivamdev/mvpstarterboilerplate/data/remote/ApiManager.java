package com.shivamdev.mvpstarterboilerplate.data.remote;

import com.shivamdev.mvpstarterboilerplate.data.model.Github;
import com.shivamdev.mvpstarterboilerplate.data.remote.api.GithubApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by shivam on 12/5/17.
 */

@Singleton
public class ApiManager {

    private GithubApi githubApi;

    @Inject
    public ApiManager(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    public Single<Github> loadGithubRepos(String username) {
        username = "user:" + username;
        return githubApi.getGithubRepos(username);
    }
}