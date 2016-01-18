package com.smk.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.smk.ExpressShipper528.R;

import java.util.List;

/**
 * Created by Dell on 1/17/2016.
 */
public class DeliveryCompanyLvAdapter extends BaseAdapter {

    private Activity ctx;
    private List<String> listCompany;
    private LayoutInflater mInflater;

    public DeliveryCompanyLvAdapter(Activity ctx, List<String> listCompany) {
        this.ctx = ctx;
        this.listCompany = listCompany;
        mInflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listCompany.size();
    }

    @Override
    public String getItem(int position) {
        return listCompany.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){

            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.list_item_delivery_company, null);

            holder.img_delivery_company = (ImageView)convertView.findViewById(R.id.img_delivery_company);
            holder.txt_delivery_co_name = (TextView)convertView.findViewById(R.id.txt_delivery_co_name);
            holder.rating_delivery_company = (RatingBar)convertView.findViewById(R.id.rating_deliver_company);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt_delivery_co_name.setText(getItem(position));

        return convertView;
    }

    static class ViewHolder{
        ImageView img_delivery_company;
        TextView txt_delivery_co_name;
        RatingBar rating_delivery_company;
    }
}
