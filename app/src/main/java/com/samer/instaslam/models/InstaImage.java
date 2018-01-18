package com.samer.instaslam.models;


import android.net.Uri;

/**
 * Created by Samer AlShurafa on 1/15/2018.
 */

public class InstaImage {

    public Uri getImageResourceUri() {
        return imageResourceUri;
    }

    private Uri imageResourceUri;

    public InstaImage(Uri imageResourceUri) {
        this.imageResourceUri = imageResourceUri;
    }
}
