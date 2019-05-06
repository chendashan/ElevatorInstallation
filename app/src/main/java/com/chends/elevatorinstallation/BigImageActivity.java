package com.chends.elevatorinstallation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BigImageActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);
        initView();
    }

    private void initView() {
        mImageView = findViewById(R.id.iv_big_image);
        int imageId = getIntent().getIntExtra("imageId", 0);
        Glide.with(this).load(imageId).into(mImageView);
    }

    public static void actionStartActivity(Context mContext, int imageId) {
        Intent intent = new Intent(mContext, BigImageActivity.class);
        intent.putExtra("imageId", imageId);
        mContext.startActivity(intent);
    }
}
