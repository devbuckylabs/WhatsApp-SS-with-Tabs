package com.buckylabs.whatsappstatussaver.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.buckylabs.whatsappstatussaver.CustomAdapter;
import com.buckylabs.whatsappstatussaver.ImageActivity;
import com.buckylabs.whatsappstatussaver.R;
import com.buckylabs.whatsappstatussaver.VideoActivity;

import java.io.File;
import java.io.FilenameFilter;

public class Fragment2 extends Fragment {
GridView simpleGrid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);
        simpleGrid = v.findViewById(R.id.simpleGridView2);
        final String[] videoPaths = getVideoPaths();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), videoPaths);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("videoPaths",videoPaths);
                intent.putExtra("videoPos",position);
                startActivity(intent);
            }
        });
        return v;
    }

    public String[] getVideoPaths(){
        String path= Environment.getExternalStorageDirectory()+"/WhatsApp/Media/.Statuses";

        File imagePath=new File(path);

        File files[]= imagePath.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".mp4"));
            }
        });

        String imagesPaths[] = new String[files.length];
        for(int i=0;i<files.length;i++){
            imagesPaths[i]=files[i].getAbsolutePath();
            Log.e("VIDEOPATH",imagesPaths[i]);
        }


        return imagesPaths;
    }


}
