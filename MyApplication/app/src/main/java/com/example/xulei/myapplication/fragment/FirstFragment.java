package com.example.xulei.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xulei.myapplication.R;

import butterknife.OnClick;

/**
 * Created by xulei on 2016/5/17.
 */
public class FirstFragment extends Fragment {
    private Integer[] images = {R.drawable.icon_home_page_selected,R.drawable.icon_join_merchant, R.drawable.icon_mine_selected, R.drawable.icon_my_card_voucher, R.drawable.icon_my_collection,R.drawable.icon_my_evaluation,R.drawable.icon_my_wallet,R.drawable.icon_online_offline,R.drawable.icon_raise};
    private String[] strings = {"签到", "请假", "工作", "清单","出差","审批","我的考核","物品领用","部门协作"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_first, null);
        GridView gv = (GridView) view.findViewById(R.id.gv_content);
//        gv.setHorizontalSpacing(1);
//        gv.setVerticalSpacing(1);
        gv.setPadding(5,5,5,5);
        gv.setAdapter(new MyAdapter(images, strings));

        return view;
    }


    @OnClick(R.id.gv_content)
    public void onClick() {
    }

    class MyAdapter extends BaseAdapter {
        Integer[] imgs = {};
        String[] strs = {};

        MyAdapter(Integer[] iv, String[] s) {
            this.imgs = iv;
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
            LayoutInflater from = LayoutInflater.from(getActivity());
            ViewHolder holder = null;

            if (convertView == null) {
                convertView = from.inflate(R.layout.gv_item, null);
                holder = new ViewHolder(convertView);
                holder.itemIv = (ImageView) convertView.findViewById(R.id.item_iv);
                holder.itemText = (TextView) convertView.findViewById(R.id.item_text);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.itemIv.setImageResource(imgs[position]);
            holder.itemText.setText(strs[position]);
            return convertView;
        }

    }

    class ViewHolder {
        public ImageView itemIv;
        public TextView itemText;

        ViewHolder(View view) {
        }
    }
}
