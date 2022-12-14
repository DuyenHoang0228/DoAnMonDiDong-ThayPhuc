package com.nhom4.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nhom4.lilpawhome_application.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class AdapterBannerUudai extends SliderViewAdapter<AdapterBannerUudai.Holder> {

    int[] images;

    public AdapterBannerUudai(int[] images){
        this.images = images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout_banneruudai,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;

        public Holder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imv_banneruudai);
        }
    }


}
