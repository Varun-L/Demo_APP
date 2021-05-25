package com.icy.myapplication99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity4 extends AppCompatActivity {

    VideoView v1;
    Boolean b = true;
    ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        v1 = findViewById(R.id.videoView);
        i1 = findViewById(R.id.imageview1);

        Button b1 = findViewById(R.id.button13);
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity4.this,MainActivity5.class));
                return true;
            }
        });
        Button b2 = findViewById(R.id.button11);
        b2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 202);
                return true;
            }
        });
    }




    public void imageViewbtn(View view){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 101);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 101) && (resultCode == RESULT_OK)) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            i1.setImageBitmap(photo);
            i1.setVisibility(View.VISIBLE);

        }
        else if ((requestCode == 202) && (requestCode == RESULT_OK)) {
            Uri uri = data.getData();
            i1.setImageURI(uri);
            i1.setVisibility(View.VISIBLE);

        }
    }

    public void videoViewbtn(View view){
        v1.setVideoURI(Uri.parse("https://developer.android.com/studio/videos/studio-install-windows.mp4"));
        v1.setMediaController(new MediaController(this));
        v1.requestFocus();
        v1.setVisibility(View.VISIBLE);
        i1.setVisibility(View.GONE);
        v1.start();
    }
    public void paures(View view){
        if(b){
            v1.pause();
            b=false;
        }else{
            v1.start();
            b=true;
        }
    }

    public void stopV(View view){
        v1.stopPlayback();
        b=false;
        v1.setVisibility(View.GONE);
        i1.setVisibility(View.GONE);
    }
}