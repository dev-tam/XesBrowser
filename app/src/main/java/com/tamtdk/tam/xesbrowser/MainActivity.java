package com.tamtdk.tam.xesbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


public class MainActivity extends AppCompatActivity {

    WebView brow; // initialize

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brow = (WebView)findViewById(R.id.wv_view); // declare
//        String url = "http://192.168.10.44:8888";
//        String url = "http://www.hackstories.com";
        String url = "https://www.whatismybrowser.com";
        brow.loadUrl(url);
    }
}
