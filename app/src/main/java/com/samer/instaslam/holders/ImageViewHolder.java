package com.samer.instaslam.holders;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.samer.instaslam.R;
import com.samer.instaslam.models.InstaImage;

import java.lang.ref.WeakReference;

/**
 * Created by Samer AlShurafa on 1/15/2018.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageThump;

    public ImageViewHolder(View itemView) {
        super(itemView);

        imageThump = itemView.findViewById(R.id.imageThump);
    }

    public void updateUI(InstaImage instaImage) {
        DecodeBitmap task = new DecodeBitmap(imageThump, instaImage);
        task.execute();
    }

    public Bitmap decodeUrl(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Only scale if we need to
        // (16384 buffer for img processing)
        Boolean scaleByHeight = Math.abs(options.outHeight - 100) >= Math.abs(options.outWidth - 100);
        if(options.outHeight * options.outWidth * 2 >= 16384){
            // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
            double sampleSize = scaleByHeight
                    ? options.outHeight / 1000
                    : options.outWidth / 1000;
            options.inSampleSize =
                    (int)Math.pow(2d, Math.floor(
                            Math.log(sampleSize)/Math.log(2d)));
        }

        options.inJustDecodeBounds = false;
        options.inTempStorage = new byte[512];

        return BitmapFactory.decodeFile(filePath, options);
    }



    class DecodeBitmap extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageView> mImageViewWeakReference;
        private InstaImage image;

        public DecodeBitmap(ImageView imageView, InstaImage image) {
            mImageViewWeakReference =  new WeakReference<ImageView>(imageView);
            this.image = image;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            return decodeUrl(image.getImageResourceUri().getPath());
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            final ImageView img = mImageViewWeakReference.get();

            if (img != null) {
                img.setImageBitmap(bitmap);
            }
        }
    }


}




