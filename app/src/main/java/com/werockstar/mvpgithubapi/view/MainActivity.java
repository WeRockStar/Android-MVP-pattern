package com.werockstar.mvpgithubapi.view;

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
import com.werockstar.mvpgithubapi.R;
import com.werockstar.mvpgithubapi.model.GithubItem;
import com.werockstar.mvpgithubapi.presenter.GithubPresenter;
import com.werockstar.mvpgithubapi.presenter.GithubPresenterImpl;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new GithubPresenterImpl(this, MainActivity.this);
    }

    @OnClick(R.id.btnLoad)
    public void onClickLoadData() {
        tvFullName.setText(getResources().getString(R.string.loading));
        tvUsername.setText(getResources().getString(R.string.loading));
        tvCompany.setText(getResources().getString(R.string.loading));
        tvLocation.setText(getResources().getString(R.string.loading));

        String username = edtUsername.getText().toString();

        if (!username.trim().equals(""))
            presenter.onLoadData(username);
        else
            Toast.makeText(this, "Please input your github username", Toast.LENGTH_SHORT)
                    .show();
    }

    @Override
    public void showGithubProfile(GithubItem githubItem) {
        if (githubItem != null) {
            tvFullName.setVisibility(View.VISIBLE);
            tvUsername.setVisibility(View.VISIBLE);
            tvLocation.setVisibility(View.VISIBLE);
            tvCompany.setVisibility(View.VISIBLE);

            Glide.with(this).load(githubItem.getAvatarUrl()).centerCrop().into(imgProfile);
            tvFullName.setText(githubItem.getFullName());
            tvUsername.setText(githubItem.getLogin());
            tvLocation.setText(githubItem.getLocation());
            tvCompany.setText(githubItem.getCompany());
        } else {
            Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.onStop();
    }
}
