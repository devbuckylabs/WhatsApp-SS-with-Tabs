package com.buckylabs.whatsappstatussaver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView imageView=findViewById(R.id.imageFull);
        String path = getIntent().getStringExtra("imagePath");
        Bitmap bmp = BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bmp);
    }
}
