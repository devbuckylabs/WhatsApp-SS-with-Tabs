package com.buckylabs.whatsappstatussaver.ui.main;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import com.buckylabs.whatsappstatussaver.CustomAdapter;
import com.buckylabs.whatsappstatussaver.R;
import com.buckylabs.whatsappstatussaver.ImageActivity;
;

import java.io.File;
import java.io.FilenameFilter;

public class Fragment1 extends Fragment {
    public static final int STORAGE_PERMISSION = 1;
    GridView simpleGrid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getResources().getLayout(R.layout.fragment_main), container, false);

        simpleGrid = v.findViewById(R.id.simpleGridView1);
        final String[] imagePaths = getImagePaths();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), imagePaths);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("imagePaths",imagePaths);
                intent.putExtra("imagePos",position);

                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {


            Toast.makeText(getContext(), "Move", Toast.LENGTH_SHORT).show();
        }
        else {
            Log.e("Permission", " Not Granted");
            requestStoragePermission();

        }






    }

    private void requestStoragePermission() {

        if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)) {

            Log.e("Entered","************");

            new AlertDialog.Builder(getActivity())
                    .setTitle("Permission Needed")
                    .setMessage("App requires storage permission to backup your apps to internal Sorage")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ActivityCompat.requestPermissions(getActivity(),new String[]{
                                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},STORAGE_PERMISSION);

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();
                        }
                    }).create().show();


        }
        else {


            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(getActivity(), "Granted", Toast.LENGTH_SHORT).show();



                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getActivity(), "Denied", Toast.LENGTH_SHORT).show();
                }

                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public String[] getImagePaths(){
        String path= Environment.getExternalStorageDirectory()+"/WhatsApp/Media/.Statuses";

        File imagePath=new File(path);

        File files[]= imagePath.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png"));
            }
        });

        String imagesPaths[] = new String[files.length];
        for(int i=0;i<files.length;i++){
            imagesPaths[i]=files[i].getAbsolutePath();
            Log.e("IMAGEPATH",imagesPaths[i]);
        }


        return imagesPaths;
    }



}
