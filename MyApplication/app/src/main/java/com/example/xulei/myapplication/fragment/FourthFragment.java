package com.example.xulei.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xulei.myapplication.R;
import com.example.xulei.myapplication.view.ImageCycleView;

import java.util.ArrayList;

/**
 * Created by xulei on 2016/5/17.
 */
public class FourthFragment extends Fragment {
    private String url1 = "http://pic2.ooopic.com/11/88/05/88bOOOPICc1_1024.jpg";
    private String url2 = "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1302/04/c0/17979528_1359966134302.jpg";
    private String url3 = "http://img1.gamedog.cn/2013/09/27/95-13092G522170.jpg";

    private ListView lv_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_fourth, null);

        ArrayList list = new ArrayList();
//        list.add(new ImageCycleView.ImageInfo(url1, "11", "11"));
//        list.add(new ImageCycleView.ImageInfo(url2, "11", "11"));
//        list.add(new ImageCycleView.ImageInfo(url3, "11", "11"));

        list.add(new ImageCycleView.ImageInfo(R.drawable.icon_online_offline, "公司大事", ""));
        list.add(new ImageCycleView.ImageInfo(R.drawable.icon_raise, "员工守则", ""));
        list.add(new ImageCycleView.ImageInfo(R.drawable.icon_public, "近期任务", ""));

        ImageCycleView ivc = (ImageCycleView) view.findViewById(R.id.ivc_view);
        ivc.loadData(list, new ImageCycleView.LoadImageCallBack() {

            @Override
            public ImageView loadAndDisplay(ImageCycleView.ImageInfo imageInfo) {
//                BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
//                ImageView imageView = new ImageView(getActivity());
//                bitmapUtils.display(imageView, imageInfo.image.toString());
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));

                return imageView;
            }
        });


        lv_list = (ListView) view.findViewById(R.id.lv_list);
        lv_list.setAdapter(new MyAdapter());
        return view;
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
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
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.dongtai_lv_item, null);
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = view;
                holder = new ViewHolder(convertView);
                holder.iv_logo = (ImageView) convertView.findViewById(R.id.iv_logo);
                holder.tv_type = (TextView) convertView.findViewById(R.id.tv_type);
                holder.tv_firm = (TextView) convertView.findViewById(R.id.tv_firm);
                holder.tv_go = (TextView) convertView.findViewById(R.id.tv_go);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
//            holder.iv_logo.setImageResource(R.mipmap.home_bar_4);

            return convertView;
        }
    }

    class ViewHolder {
        public ImageView iv_logo;
        public TextView tv_type, tv_firm, tv_go;

        ViewHolder(View view) {
        }
    }
}
