package com.prateektask2.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prateektask2.Models.Coupons;
import com.prateektask2.R;

import java.util.ArrayList;

/**
 * Created by prateekgupta on 10/10/16.
 */

public class CouponsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;

    public void setmCoupons(ArrayList<Coupons> mCoupons) {
        this.mCoupons = mCoupons;
    }

    ArrayList<Coupons> mCoupons = new ArrayList<>();

    public CouponsAdapter(Context context){
        mContext = context;
    }

    public void setCoupon(ArrayList<Coupons> list){
        mCoupons = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deallayout, parent, false);
        return new CouponHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CouponHolder couponHolder = (CouponHolder) holder;
        couponHolder.mainString.setText(mCoupons.get(position).getMainString());
        couponHolder.description.setText(mCoupons.get(position).getDescription());

        if(mCoupons.get(position).getDescription().contains("medicine")
                ||mCoupons.get(position).getDescription().contains("Health") ){
            //couponHolder.image.setImageDrawable(mContext.getDrawable(R.drawable.doctor));
        }else if(mCoupons.get(position).getDescription().contains("food")
                ||mCoupons.get(position).getDescription().contains("biryani") ){
            // couponHolder.image.setImageDrawable(mContext.getDrawable(R.drawable.cake));
        }else if(mCoupons.get(position).getDescription().contains("flight")
                ||mCoupons.get(position).getDescription().contains("travel") ){
            //  couponHolder.image.setImageDrawable(mContext.getDrawable(R.drawable.flight));
        }else if(mCoupons.get(position).getDescription().contains("medicine")
                ||mCoupons.get(position).getDescription().contains("Health") ){
            //couponHolder.image.setImageDrawable(mContext.getDrawable(R.drawable.doctor));
        }if(mCoupons.get(position).getDescription().contains("flowers")
                ||mCoupons.get(position).getDescription().contains("cake") ){
            //couponHolder.image.setImageDrawable(mContext.getDrawable(R.drawable.cake));
        }

    }

    @Override
    public int getItemCount() {
        return mCoupons.size();
    }

    class CouponHolder extends RecyclerView.ViewHolder{

        TextView mainString;
        TextView description;
        ImageView image;
        String tag;

        public CouponHolder(View itemView) {
            super(itemView);
            mainString = (TextView) itemView.findViewById(R.id.tv_maintext);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            image = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }

}
