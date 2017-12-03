package com.tamtdk.tam.xesbrowser;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    WebView brow; // initialize
    EditText urledit;
    Button go, forward, back, clear, reload;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        brow = (WebView)findViewById(R.id.wv_view); // declare
        urledit = (EditText) findViewById(R.id.et_url);
        go = (Button) findViewById(R.id.btn_go);
        forward = (Button) findViewById(R.id.btn_fwd);
        back = (Button) findViewById(R.id.btn_bck);
        reload = (Button) findViewById(R.id.btn_reload);
        clear = (Button) findViewById(R.id.btn_clear);
        // When we click on something in our browser this enables
        // to open the link in the same browser instead of another browser.
        brow.setWebViewClient(new ourVewClient());
        brow.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                if (newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        WebSettings websettings = brow.getSettings();
        websettings.setJavaScriptEnabled(true);

        brow.loadUrl("http://www.ecosia.org");

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
        // Forward button
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brow.canGoForward())
                    brow.goForward();
            }
        });
        // Backward button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (brow.canGoBack())
                    brow.goBack();
            }
        });
        // Reload button
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brow.reload();
            }
        });
        // Clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brow.clearHistory();
            }
        });
    }
}
