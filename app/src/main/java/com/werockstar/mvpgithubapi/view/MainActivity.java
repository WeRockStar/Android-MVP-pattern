package com.werockstar.mvpgithubapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.werockstar.mvpgithubapi.R;
import com.werockstar.mvpgithubapi.model.GithubItem;
import com.werockstar.mvpgithubapi.presenter.GithubPresenter;
import com.werockstar.mvpgithubapi.presenter.GithubPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements GithubPresenter.View {

    @Bind(R.id.edtUsername)
    public EditText edtUsername;

    @Bind(R.id.btnLoad)
    public Button btnLoad;

    @Bind(R.id.imgProfile)
    public ImageView imgProfile;

    @Bind(R.id.tvFullName)
    public TextView tvFullName;

    @Bind(R.id.tvUsername)
    public TextView tvUsername;

    @Bind(R.id.tvCompany)
    public TextView tvCompany;

    @Bind(R.id.tvLocation)
    public TextView tvLocation;

    @Bind(R.id.rootLayout)
    RelativeLayout rootLayout;

    GithubPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
            Glide.with(this).load(githubItem.getAvatarUrl()).centerCrop().into(imgProfile);
            tvFullName.setText(githubItem.getFullName());
            tvUsername.setText(githubItem.getLogin());
            tvLocation.setText(githubItem.getLocation());
            tvCompany.setText(githubItem.getCompany());
        } else {
            Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }
}
