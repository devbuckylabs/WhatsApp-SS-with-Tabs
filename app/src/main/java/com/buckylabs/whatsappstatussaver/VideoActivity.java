package com.buckylabs.whatsappstatussaver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapterVideo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
      //  VideoView videoView=findViewById(R.id.videoFull);
        viewPager=findViewById(R.id.viewPager_video);
        String[] videopaths = getIntent().getStringArrayExtra("videoPaths");
        int pos= getIntent().getIntExtra("videoPos",0);
        adapter= new CustomSwipeAdapterVideo(this,videopaths);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);



    /*    Log.e("Video Path",path);
        Bitmap bmp = BitmapFactory.decodeFile(path);

        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
*/
    }
}
