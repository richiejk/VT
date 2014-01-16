package com.richiejk.voyagetales.api;

import org.json.JSONException;

/**
 * Created by richie on 1/16/14.
 */
public interface APIListener {

    public void onStart();

    public void onComplete(String json) throws JSONException;

    public void onCompleteWithError(String error);
}
