package com.example.jas.meetingminex1;

import android.accounts.AccountManager;
import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView t1;
    String resp;

    private final String TEST_URL = "http://54.193.115.49/team/create_team";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        t1 = (TextView) findViewById(R.id.textView);

        AccountManager am = AccountManager.get(this);
        Bundle options = new Bundle();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Test Url", "Button clicked");
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "http://www.google.com";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, TEST_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                if (response != null) {
                                    resp = "Response is: " + response.substring(0, 500);
                                    Log.d("Test Url", "good resp");
                                    t1.setText(resp);
                                } else {
                                    Log.d ("TEST URL", "null");
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        resp = "That didn't work!";
                        Log.d("Test Url", "error resp");
                        t1.setText(resp);
                    }
                });
                queue.add(stringRequest);

            }
        });


    }



}
