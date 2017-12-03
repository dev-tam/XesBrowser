package com.tamtdk.tam.xesbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    WebView brow; // initialize
    EditText urledit;
    Button go, forward, back, clear, reload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brow = (WebView)findViewById(R.id.wv_view); // declare
        urledit = (EditText) findViewById(R.id.et_url);
        go = (Button) findViewById(R.id.btn_go);
        forward = (Button) findViewById(R.id.btn_fwd);
        back = (Button) findViewById(R.id.btn_bck);
        clear = (Button) findViewById(R.id.btn_clear);
        // When we click on something in our browser this enables
        // to open the link in the same browser instead of another browser.
        brow.setWebViewClient(new ourNewClient());

        WebSettings websettings = brow.getSettings();
        websettings.setJavaScriptEnabled(true);

        brow.loadUrl("http://www.hackstories.com");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittextvalue = urledit.getText().toString();
                if (!edittextvalue.startsWith("http://")) {
                    edittextvalue = "http://" + edittextvalue;
                    String url = edittextvalue;
                    brow.loadUrl(url);
                    // Hide keyboard after using EditText
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(urledit.getWindowToken(),0);
                }
            }
        });
    }
}
