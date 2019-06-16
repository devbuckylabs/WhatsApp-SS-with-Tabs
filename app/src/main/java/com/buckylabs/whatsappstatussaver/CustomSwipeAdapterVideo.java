package com.buckylabs.whatsappstatussaver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class CustomSwipeAdapterVideo extends PagerAdapter {

    Context context;
    String videos[];
    LayoutInflater inflater;

    CustomSwipeAdapterVideo(Context ctx,String[] videos) {

        this.context=ctx;
        this.videos=videos;

    }


    @Override
    public int getCount() {
        return videos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int i) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = inflater.inflate(R.layout.video_view_swipe, container, false);
        final VideoView videoView=item_view.findViewById(R.id.videoFull);


        Uri uri = Uri.parse(videos[i]);
        videoView.setVideoURI(uri);
        videoView.seekTo(1);
        //videoView.start();

        MediaController mediaController=new MediaController(context);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        container.addView(item_view);
        return item_view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int i, @NonNull Object object) {
        container.removeView((LinearLayout) object);

    }

}


