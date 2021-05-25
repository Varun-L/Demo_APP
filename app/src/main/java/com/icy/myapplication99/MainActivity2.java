package com.icy.myapplication99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void a2fun1(View v){
        Snackbar.make(v,"I am Button",Snackbar.LENGTH_SHORT).show();
    }

    public void a2fun2(View v){
        Snackbar.make(v,"I am Button with Image",Snackbar.LENGTH_SHORT).show();
    }

    public void a2fun3(View v){
        Snackbar.make(v,"I am Image Button",Snackbar.LENGTH_SHORT).show();
        findViewById(R.id.button6).setVisibility(View.VISIBLE);
    }

    public void a2fun4(View v){

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "varun.codeq@gmail.com","saniphenix.001@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "DEMO");
        email.putExtra(Intent.EXTRA_TEXT, "Hey There, We have Built a new App");

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "From which App do you want to send Emails ? :"));
        findViewById(R.id.button7).setVisibility(View.VISIBLE);

    }
    public void a2fun5(View v){
        Intent i = new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(i);
    }





}