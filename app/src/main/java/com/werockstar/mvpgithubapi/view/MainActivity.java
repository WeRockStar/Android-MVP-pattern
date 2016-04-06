package com.werockstar.mvpgithubapi.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.werockstar.mvpgithubapi.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.edtUsername)
    private EditText edtUsername;

    @Bind(R.id.btnLoad)
    private Button btnLoad;

    @Bind(R.id.imgProfile)
    private ImageView imgProfile;

    @Bind(R.id.tvFullName)
    private TextView tvFullName;

    @Bind(R.id.tvUsername)
    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
}
