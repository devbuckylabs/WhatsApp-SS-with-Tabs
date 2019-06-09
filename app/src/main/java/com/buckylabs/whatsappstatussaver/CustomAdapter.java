package com.buckylabs.whatsappstatussaver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.buckylabs.whatsappstatussaver.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String images[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] images) {
        this.context = applicationContext;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        Bitmap bmp=null;
        if(images[i].endsWith(".jpg") || images[i].endsWith(".jpeg")) {
            bmp = BitmapFactory.decodeFile(images[i]);
        }
        else{
            bmp = ThumbnailUtils.createVideoThumbnail(images[i],0);
        }
        icon.setImageBitmap(bmp);
        return view;
    }
}
