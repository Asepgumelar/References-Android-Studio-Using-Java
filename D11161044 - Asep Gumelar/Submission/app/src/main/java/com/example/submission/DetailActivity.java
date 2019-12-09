package com.example.submission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.core.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageSrc = (ImageView)findViewById(R.id.ImageSrcDetail);
        TextView imageTitle = (TextView)findViewById(R.id.titleImageDetail);
        TextView imagePrice = (TextView)findViewById(R.id.priceImageDetail);
        TextView imageDesc = (TextView)findViewById(R.id.descImageDetail);
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Motorcycle.IMAGE_KEY, 0));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        imageTitle.setText(getIntent().getStringExtra(Motorcycle.TITLE_KEY));
        imagePrice.setText(getIntent().getStringExtra(Motorcycle.PRICE_KEY));
        imageDesc.setText(getIntent().getStringExtra(Motorcycle.DESC_KEY));
        Glide.with(this).load(getIntent().getIntExtra(Motorcycle.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(imageSrc);
    }
}
