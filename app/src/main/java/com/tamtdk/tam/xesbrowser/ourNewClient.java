package com.tamtdk.tam.xesbrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by tam on 12/3/17.
 */

class ourNewClient extends WebViewClient {

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
