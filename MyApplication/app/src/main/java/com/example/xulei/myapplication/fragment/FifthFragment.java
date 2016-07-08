package com.example.xulei.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xulei.myapplication.R;
import com.example.xulei.myapplication.activity.LoginActivity;
import com.example.xulei.myapplication.util.SharedPreferencesUtils;

/**
 * Created by xulei on 2016/5/17.
 */
public class FifthFragment extends Fragment {

    private boolean login;
    private ImageView iv_head;
    private ImageView iv_level;
    private TextView tv_login;
    private TextView tv_username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_fifth, null);
        login = SharedPreferencesUtils.getBoolean(getActivity(), "login", false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        iv_head = (ImageView) view.findViewById(R.id.iv_head);
        iv_level = (ImageView) view.findViewById(R.id.iv_level);
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        tv_username = (TextView) view.findViewById(R.id.tv_username);

        if(login){
//            iv_head.setVisibility(View.GONE);
            iv_level.setVisibility(View.GONE);
            tv_username.setVisibility(View.GONE);
            tv_login.setVisibility(View.VISIBLE);
        }else{
            String username = SharedPreferencesUtils.getString(getActivity(), "username", "");

            tv_login.setVisibility(View.GONE);
            iv_level.setVisibility(View.VISIBLE);
            tv_username.setVisibility(View.VISIBLE);

        }

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
