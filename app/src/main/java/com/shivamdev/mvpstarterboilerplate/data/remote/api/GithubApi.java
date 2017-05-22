package com.shivamdev.mvpstarterboilerplate.data.remote.api;

import com.shivamdev.mvpstarterboilerplate.data.model.Github;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shivam on 12/5/17.
 */

public interface GithubApi {

    @GET("search/repositories")
    Single<Github> getGithubRepos(@Query("q") String username);

}