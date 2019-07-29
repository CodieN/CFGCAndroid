package com.example.lenovo.gardenclub;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Joe on 4/13/2018.
 */

class WebAppInterface {
    Context mContext;
    String mData, loginInfo;
    private static final String TAG = "WebAppInterface";

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        this.mContext = c;
    }

    @JavascriptInterface
    public void sendData(String data) {
        this.mData = data;
    }

    @JavascriptInterface
    public String processHTML(String formData) {
        loginInfo = formData;
        return formData;
    }

}
