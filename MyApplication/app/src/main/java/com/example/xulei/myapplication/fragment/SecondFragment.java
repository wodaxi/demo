package com.example.xulei.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xulei.myapplication.R;
import com.example.xulei.myapplication.adapter.PinnedHeaderExpandableAdapter;
import com.example.xulei.myapplication.view.PinnedHeaderExpandableListView;

/**
 * Created by xulei on 2016/5/17.
 */
public class SecondFragment extends Fragment {
    private String[][] childrenData = new String[10][10];
    private String[] groupData = new String[10];
    private PinnedHeaderExpandableListView lv_list;
    private Integer[] images = {R.mipmap.home_bar_1_2, R.mipmap.home_bar_1_2, R.mipmap.home_bar_1_2, R.mipmap.home_bar_1_2};
    private String[] strings = {"我的上级", "我的同事", "讨论组", "生活圈"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_second, null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        lv_list = (PinnedHeaderExpandableListView) view.findViewById(R.id.lv_list);
//        lv_list.setAdapter(new MyLVAdapter(images,strings));
        initData();
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

        // 设置单个分组展开(使得单个分组在顶端)
        // explistview.setOnGroupClickListener(new GroupClickListener());
    }
    class MyLVAdapter extends BaseAdapter{
        Integer[] imgs = {};
        String[] strs = {};
        MyLVAdapter(Integer[] i,String[] s){
            this.imgs = i;
            this.strs = s;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.lv_item,null);
                        holder = new ViewHolder(convertView);
                holder.imageVew = (ImageView) convertView.findViewById(R.id.imageView);
                holder.textView = (TextView) convertView.findViewById(R.id.textivew);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.imageVew.setImageResource(imgs[position]);
            holder.textView.setText(strs[position]);
            return convertView;
        }
    }
    class ViewHolder{
        public ImageView imageVew;
        public TextView textView;
        ViewHolder(View view){}
    }
}
