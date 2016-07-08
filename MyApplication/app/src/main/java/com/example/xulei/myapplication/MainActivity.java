package com.example.xulei.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.xulei.myapplication.fragment.FifthFragment;
import com.example.xulei.myapplication.fragment.FirstFragment;
import com.example.xulei.myapplication.fragment.FourthFragment;
import com.example.xulei.myapplication.fragment.FragmentTabAdapter;
import com.example.xulei.myapplication.fragment.SecondFragment;
import com.example.xulei.myapplication.fragment.ThirdFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity  {

    private ArrayList<Fragment> fragments;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;
    private FifthFragment fifthFragment;
    private FragmentTransaction ft;
    private TextView title_text;
    private ImageView title_img_left;
    private ImageView title_img_right;
    private FragmentTabAdapter tabAdapter;
    private RadioGroup homePageTabs;
    private LinearLayout ll_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ArrayList<>();
//        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title_text = (TextView) findViewById(R.id.title_text);
        title_img_left = (ImageView) findViewById(R.id.title_img_left);
        title_img_right = (ImageView) findViewById(R.id.title_img_right);
        ll_context = (LinearLayout) findViewById(R.id.ll_context);
        homePageTabs = (RadioGroup) findViewById(R.id.home_page_tabs);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        fourthFragment = new FourthFragment();
        fifthFragment = new FifthFragment();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);
        fragments.add(fifthFragment);

        tabAdapter = new FragmentTabAdapter(MainActivity.this, fragments, R.id.tab_content, homePageTabs);
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener(){
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
                super.OnRgsExtraCheckedChanged(radioGroup, checkedId, index);
                switch (index){
                    case 0:
                        title_text.setText("绩效");
                        if(title_img_left.getVisibility() == View.GONE){
                            title_img_left.setVisibility(View.VISIBLE);
                        }
                        if(title_img_right.getVisibility() == View.GONE){
                            title_img_right.setVisibility(View.VISIBLE);
                        }

                        break;
                    case 1:
                        title_text.setText("通讯录");
                        if(title_img_left.getVisibility() == View.VISIBLE){
                            title_img_left.setVisibility(View.GONE);
                        }
                        if(title_img_right.getVisibility() == View.GONE){
                            title_img_right.setVisibility(View.VISIBLE);
                        }
                        break;
                    case 2:
                        title_text.setText("信息");
                        if(title_img_left.getVisibility() == View.VISIBLE){
                            title_img_left.setVisibility(View.GONE);
                        }
                        if(title_img_right.getVisibility() == View.VISIBLE){
                            title_img_right.setVisibility(View.GONE);
                        }
                        break;
                    case 3:
                        title_text.setText("动态");
                        if(title_img_left.getVisibility() == View.VISIBLE){
                            title_img_left.setVisibility(View.GONE);
                        }
                        if(title_img_right.getVisibility() == View.VISIBLE){
                            title_img_right.setVisibility(View.GONE);
                        }
                        break;
                    case 4:
                        title_text.setText("我的");
                        if(title_img_left.getVisibility() == View.VISIBLE){
                            title_img_left.setVisibility(View.GONE);
                        }
                        if(title_img_right.getVisibility() == View.VISIBLE){
                            title_img_right.setVisibility(View.GONE);
                        }
                        break;
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
