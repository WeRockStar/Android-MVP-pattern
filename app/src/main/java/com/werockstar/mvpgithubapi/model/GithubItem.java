package com.werockstar.mvpgithubapi.model;

import com.google.gson.annotations.SerializedName;

public class GithubItem {
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String fullName;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getLogin() {
        return login;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
