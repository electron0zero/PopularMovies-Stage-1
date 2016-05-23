package com.wordpress.electron0zero.popularmovies;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context mContext;
    private String[] img;

    public ImageAdapter(Context c, String[] img) {
        mContext = c;
        this.img = img;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
       return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View view, ViewGroup parent) {
        ImageView posterImage;

        if (view == null) {
            // if it's not recycled, initialize some attributes
            posterImage = new ImageView(mContext);
            posterImage.setLayoutParams(new GridView.LayoutParams(240, 240));
            posterImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            posterImage.setAdjustViewBounds(true);
            posterImage.setPadding(1,1,1,1);
        }else {
            posterImage = (ImageView) view;
        }
        //Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView)
        //as per picasso website
        Picasso.with(mContext).load(img[position]).into(posterImage);

        return posterImage;
    }

}
