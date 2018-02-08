package com.bipin.camerademo.kut;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bipin.camerademo.R;

import java.util.ArrayList;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.PhotViewHolder> {
    ArrayList<Bitmap> images;

    public PhotoListAdapter(ArrayList<Bitmap> images) {
        this.images = images;
    }

    @Override
    public PhotoListAdapter.PhotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_single_item, parent, false);
        return new PhotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoListAdapter.PhotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class PhotViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public PhotViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.single_image);
        }
    }
}
