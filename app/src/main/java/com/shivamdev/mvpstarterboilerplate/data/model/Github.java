package com.shivamdev.mvpstarterboilerplate.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by shivam on 12/5/17.
 */

@Parcel
public class Github {

    @SerializedName("items")
    public List<GitItem> itemsList;

    @Parcel
    public static class GitItem {

        @SerializedName("id")
        public long id;

        @SerializedName("name")
        public String repoName;

        @SerializedName("language")
        public String language;

        @SerializedName("full_name")
        public String fullName;

        @SerializedName("html_url")
        public String htmlUrl;

        @SerializedName("description")
        public String description;

    }

}