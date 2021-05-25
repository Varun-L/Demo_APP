package com.icy.myapplication99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void fun1(View v){
        Toast.makeText(this, "I am Clicked by Button1", Toast.LENGTH_SHORT).show();
    }

    public void fun2(View v){
        Intent i  = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.cambum.net"));
        startActivity(i);
    }

    public void fun3(View v){
        Intent i  = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }

}