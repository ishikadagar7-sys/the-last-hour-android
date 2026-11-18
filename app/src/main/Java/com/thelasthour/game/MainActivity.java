package com.thelasthour.game;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.graphics.Color;
import android.view.View;

public class MainActivity extends Activity {

    private WebView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            game = new WebView(this);

            game.setBackgroundColor(Color.BLACK);
            game.setWebViewClient(new WebViewClient());
            game.setWebChromeClient(new WebChromeClient());

            WebSettings settings = game.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setLoadsImagesAutomatically(true);

            game.setLayerType(View.LAYER_TYPE_HARDWARE, null);

            setContentView(game);
            game.loadUrl("file:///android_asset/index.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        if (game != null && game.canGoBack()) {
            game.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
