package com.werockstar.mvpgithubapi.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;
import com.werockstar.mvpgithubapi.GithubApplication;
import com.werockstar.mvpgithubapi.R;
import com.werockstar.mvpgithubapi.model.GithubItem;
import com.werockstar.mvpgithubapi.presenter.GithubPresenter;
import com.werockstar.mvpgithubapi.presenter.GithubPresenterImpl;
import com.werockstar.mvpgithubapi.service.GithubService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements GithubPresenter.View {

    @BindView(R.id.edtUsername)
    public EditText edtUsername;

    @BindView(R.id.btnLoad)
    public Button btnLoad;

    @BindView(R.id.imgProfile)
    public ImageView imgProfile;

    @BindView(R.id.tvFullName)
    public TextView tvFullName;

    @BindView(R.id.tvUsername)
    public TextView tvUsername;

    @BindView(R.id.tvCompany)
    public TextView tvCompany;

    @BindView(R.id.tvLocation)
    public TextView tvLocation;

    @BindView(R.id.rootLayout)
    RelativeLayout rootLayout;

    GithubPresenter presenter;

    ProgressDialog dialog;

    @Inject
    GithubService service;

    GithubApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = getApp();
        app.getComponent().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new GithubPresenterImpl(this, service);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
    }

    public GithubApplication getApp() {
        return (GithubApplication) getApplication();
    }

    @OnClick(R.id.btnLoad)
    public void onClickLoadData() {
        presenter.onLoadData(edtUsername.getText().toString());
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void dismissLoading() {
        dialog.cancel();
    }

    @Override
    public void showGithubProfile(GithubItem githubItem) {
        if (githubItem != null) {
            Glide.with(this).load(githubItem.getAvatarUrl()).centerCrop().into(imgProfile);
            tvFullName.setText(githubItem.getFullName());
            tvUsername.setText(githubItem.getLogin());
            tvLocation.setText(githubItem.getLocation());
            tvCompany.setText(githubItem.getCompany());
        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.onStop();
    }
}
