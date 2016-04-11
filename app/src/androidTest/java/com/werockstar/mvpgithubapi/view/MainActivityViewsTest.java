package com.werockstar.mvpgithubapi.view;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.test.ViewAsserts.assertGroupContains;
import static android.test.ViewAsserts.assertHorizontalCenterAligned;
import static android.test.ViewAsserts.assertOnScreen;

@RunWith(AndroidJUnit4.class)
public class MainActivityViewsTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void edit_text_grout_of_root_layout() {
        EditText edtUsername = activityTestRule.getActivity().edtUsername;
        RelativeLayout root = activityTestRule.getActivity().rootLayout;
        assertGroupContains(root, edtUsername);
    }

    @Test
    public void image_view_on_screen() {
        RelativeLayout root = activityTestRule.getActivity().rootLayout;
        ImageView imgView = activityTestRule.getActivity().imgProfile;

        assertOnScreen(root, imgView);
    }

    @Test
    public void image_view_horizontal_center_on_screen() {
        RelativeLayout root = activityTestRule.getActivity().rootLayout;
        ImageView imageView = activityTestRule.getActivity().imgProfile;

        assertHorizontalCenterAligned(root, imageView);
    }
}