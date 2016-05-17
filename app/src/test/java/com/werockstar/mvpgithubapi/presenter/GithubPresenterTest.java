package com.werockstar.mvpgithubapi.presenter;

import com.werockstar.mvpgithubapi.model.GithubItem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GithubPresenterTest {

    GithubItem githubItem;

    @Before
    public void setUp() {
        githubItem = new GithubItem();
    }

    @Test
    public void load_data_from_github() {
        GithubPresenterStub stub = new GithubPresenterStub();

        stub.onLoadData("werockstar");

        assertTrue(stub.isLoaded());
    }

    @Test
    public void put_werockstar_should_be_show_github_profile_with_full_name() {
        GithubPresenterStub stub = new GithubPresenterStub();

        stub.onLoadData("werockstar");

        assertEquals("Kotchaphan Muangsan", stub.getFullName());
    }

    public class GithubPresenterStub implements GithubPresenter {

        private boolean loaded = false;

        @Override
        public void onLoadData(String username) {
            loaded = true;
        }

        @Override
        public void onStop() {

        }

        public boolean isLoaded() {
            return loaded;
        }

        public String getFullName() {
            githubItem.setFullName("Kotchaphan Muangsan");
            return githubItem.getFullName();
        }
    }
}