package com.example.xulei.myapplication.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xulei.myapplication.R;
import com.example.xulei.myapplication.adapter.PinnedHeaderExpandableAdapter;
import com.example.xulei.myapplication.view.FlowLayout;
import com.example.xulei.myapplication.view.PinnedHeaderExpandableListView;

/**
 * Created by xulei on 2016/5/17.
 */
public class ThirdFragment extends Fragment {

    private DrawerLayout mDrawerLayout;
    private PinnedHeaderExpandableListView lv_list;
    private String[][] childrenData = new String[10][10];
    private String[] groupData = new String[10];
    private FlowLayout flow_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fg_view, null);
        mDrawerLayout = (DrawerLayout) inflate.findViewById(R.id.rl_content);
        flow_layout = (FlowLayout) inflate.findViewById(R.id.flow_layout);

        lv_list = (PinnedHeaderExpandableListView) inflate.findViewById(R.id.lv_list);
        initUI();
        initData();
        return inflate;
    }
    private String mNames[] = {
            "11111111111111","2222222222222222222222","11",
            "1","22222222222222222","kobe 333333333333333333333",
            "jordan","layout","44444444444444444444",
            "margin","44444444444444444444444444444444444444444444","text",
            "name","2222","search","logcat"
    };
    private void initUI() {

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 15;
        lp.rightMargin = 15;
        lp.topMargin = 15;
        lp.bottomMargin = 15;
        for(int i = 0; i < mNames.length; i ++){
            TextView view = new TextView(getActivity());
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackground(getResources().getDrawable(R.drawable.button_shape_red));
            flow_layout.addView(view,lp);
            flow_layout.setHorizontalSpacing(20);
            flow_layout.setVerticalSpacing(10);
            final int finalI = i;
            flow_layout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"----  "+mNames[finalI],Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 10; i++) {
            groupData[i] = "分组" + i;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                childrenData[i][j] = "好友" + i + "-" + j;
            }
        }
        // 设置悬浮头部VIEW
        lv_list.setHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.group_head, lv_list, false));
        PinnedHeaderExpandableAdapter adapter = new PinnedHeaderExpandableAdapter(childrenData,groupData,getActivity(),lv_list);
        lv_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

                for (int i = 0; i < 10; i++) {
                    if (groupPosition == i) {
                        lv_list.setSelection(i + 4);
                        break;
                    }
                }

            }
        });
        lv_list.setAdapter(adapter);

        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        // 设置单个分组展开(使得单个分组在顶端)
        // explistview.setOnGroupClickListener(new GroupClickListener());
    }

}
