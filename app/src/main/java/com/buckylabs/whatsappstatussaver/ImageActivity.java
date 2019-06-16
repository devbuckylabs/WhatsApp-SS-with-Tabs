package com.buckylabs.whatsappstatussaver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        viewPager=findViewById(R.id.viewPager_image);
        String[] imagepaths = getIntent().getStringArrayExtra("imagePaths");
        int pos= getIntent().getIntExtra("imagePos",0);
        Log.e("IN POS",pos+"");
        adapter= new CustomSwipeAdapter(this,imagepaths);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pos);

        /*ImageView imageView=findViewById(R.id.imageFull);
        String path = getIntent().getStringExtra("imagePath");
        Bitmap bmp = BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bmp);*/


    }
}
