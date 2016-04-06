package com.werockstar.mvpgithubapi.model;

import com.google.gson.annotations.SerializedName;

public class GithubItem {
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String fullName;

    public String getLogin() {
        return login;
    }

    public String getFullName() {
        return fullName;
    }
}
