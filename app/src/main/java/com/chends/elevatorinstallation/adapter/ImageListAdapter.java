package com.chends.elevatorinstallation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chends.elevatorinstallation.BigImageActivity;
import com.chends.elevatorinstallation.R;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    private int[] arrImageId;
    private Context mContext;

    public ImageListAdapter(Context context, int[] arrImageId) {
        this.arrImageId = arrImageId;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext).load(arrImageId[position]).into(holder.mImageView);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigImageActivity.actionStartActivity(mContext, arrImageId[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrImageId.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_item_Image);
        }
    }
}
