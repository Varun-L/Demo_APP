package com.icy.myapplication99;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity5 extends AppCompatActivity {

//    WebView webView;
    EditText e1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

//        webView = findViewById(R.id.webView1);
        t1 = findViewById(R.id.textView5);
        e1 = findViewById(R.id.editTextNumberSigned);

    }

    public void goVolley(View view){

        String url = "http://192.168.0.101:5000/test";
        url += "?num="+e1.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                t1.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity5.this, "Error Occurred "+error.getMessage()+error.toString()+error.getCause(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue q1 = Volley.newRequestQueue(this);
        q1.add(stringRequest);


    }




}