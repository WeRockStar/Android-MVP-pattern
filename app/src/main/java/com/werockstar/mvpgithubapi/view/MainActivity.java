package com.werockstar.mvpgithubapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

    GithubPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new GithubPresenterImpl(this);
    }

    @OnClick(R.id.btnLoad)
    public void onClickLoadData() {
        String username = edtUsername.getText().toString();
        presenter.onLoadData(username);
    }

    @Override
    public void showGithubProfile(GithubItem githubItem) {
        if (githubItem != null) {
            Glide.with(this).load(githubItem.getAvatarUrl()).centerCrop().into(imgProfile);
            tvFullName.setText(githubItem.getFullName());
            tvUsername.setText(githubItem.getLogin());
        }
    }
}
