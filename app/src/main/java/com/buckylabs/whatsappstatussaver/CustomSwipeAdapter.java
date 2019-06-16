package com.buckylabs.whatsappstatussaver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomSwipeAdapter extends PagerAdapter {

    Context context;
    String images[];
    LayoutInflater inflater;
    private int mCurrentPos;

    CustomSwipeAdapter(Context ctx,String[] images) {

        this.context=ctx;
        this.images=images;

    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==  o;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = inflater.inflate(R.layout.image_view_swipe, container, false);
        ImageView imageView = item_view.findViewById(R.id.imageFull);
        Log.e("You clicked",position+"");
        Bitmap bmp = null;
        if (images[position].endsWith(".jpg") || images[position].endsWith(".jpeg")) {
            bmp = BitmapFactory.decodeFile(images[position]);

        }
        imageView.setImageBitmap(bmp);
        container.addView(item_view);
        return item_view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int i, @NonNull Object object) {
        container.removeView((LinearLayout) object);

    }
}
