package com.example.submission;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class MotorcyclesAdapter extends RecyclerView.Adapter<MotorcyclesAdapter.MotorcyclesViewHolder>  {
    private GradientDrawable mGradientDrawable;
    private ArrayList<Motorcycle> MotorCycleData;
    private Context mContext;

    MotorcyclesAdapter(Context context, ArrayList<Motorcycle> motorCycle) {
        this.MotorCycleData = motorCycle;
        this.mContext = context;
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.nmax);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public MotorcyclesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MotorcyclesViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(MotorcyclesViewHolder holder, int position) {
        Motorcycle currentMotorcycle = MotorCycleData.get(position);
        holder.bindTo(currentMotorcycle);
    }

    @Override
    public int getItemCount() {
        return MotorCycleData.size();
    }

    static class MotorcyclesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleText;
        private TextView mPriceText;
        private TextView mDescText;
        private ImageView mMotorcycleImage;
        private Context mContext;
        private Motorcycle mCurrentMotorcycle;
        private GradientDrawable mGradientDrawable;

        MotorcyclesViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.image_title);
            mPriceText = (TextView)itemView.findViewById(R.id.image_price);
            mDescText = (TextView)itemView.findViewById(R.id.image_desc);
            mMotorcycleImage = (ImageView)itemView.findViewById(R.id.image_src);
            mContext = context;
            mGradientDrawable = gradientDrawable;
            itemView.setOnClickListener(this);
        }

        void bindTo(Motorcycle currentMotorcycle){
            mTitleText.setText(currentMotorcycle.getTitle());
            mPriceText.setText(currentMotorcycle.getPrice());
            mDescText.setText(currentMotorcycle.getDesc());
            mCurrentMotorcycle = currentMotorcycle;
            Glide.with(mContext).load(currentMotorcycle.
                    getImageResource()).placeholder(mGradientDrawable).into(mMotorcycleImage);
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = Motorcycle.starter(mContext, mCurrentMotorcycle.getTitle(),
                    mCurrentMotorcycle.getPrice(), mCurrentMotorcycle.getDesc(), mCurrentMotorcycle.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}