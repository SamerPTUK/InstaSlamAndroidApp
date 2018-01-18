package com.samer.instaslam.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samer.instaslam.R;
import com.samer.instaslam.holders.ImageViewHolder;
import com.samer.instaslam.models.InstaImage;

import java.util.ArrayList;

/**
 * Created by Samer AlShurafa on 1/15/2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    private ArrayList<InstaImage> imagesList;
    private ImageView selectedImage;

    public ImagesAdapter(ArrayList<InstaImage> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);
        return new ImageViewHolder(card);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        InstaImage instaImage = imagesList.get(position);
        holder.updateUI(instaImage);

        final ImageViewHolder viewHolder = holder;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImage = view.findViewById(R.id.selected_image);

                selectedImage.setImageDrawable(viewHolder.imageThump.getDrawable());

            }
        });
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }
}




