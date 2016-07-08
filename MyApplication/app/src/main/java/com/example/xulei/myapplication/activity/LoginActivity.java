package com.example.xulei.myapplication.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xulei.myapplication.R;

/**
 * Created by xulei on 2016/5/20.
 */
public class LoginActivity extends BaseActivity {

    private TextView title_text;
    private ImageView title_img_left;
    private ImageView title_img_right;
    private EditText login_account;
    private EditText login_password;
    private Button login_button;


    @Override
    public void setContentLayout() {
    setContentView(R.layout.login_act);
    }

    @Override
    public void initView() {
        //布局头
        title_text = (TextView) findViewById(R.id.title_text);
        title_img_left = (ImageView) findViewById(R.id.title_img_left);
        title_img_right = (ImageView) findViewById(R.id.title_img_right);
        title_text.setText("登陆");
        title_img_left.setImageResource(R.mipmap.title_left_back);
        title_img_right.setVisibility(View.GONE);

        login_account = (EditText) findViewById(R.id.login_account);
        login_password = (EditText) findViewById(R.id.login_password);

        login_button = (Button) findViewById(R.id.login_button);

    }

    @Override
    public void onClickEvent(View view) {

    }
}
