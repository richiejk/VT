package com.richiejk.voyagetales.api;

import android.content.Context;
import android.util.Log;

import com.richiejk.voyagetales.common.Finals;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by richie on 1/16/14.
 */
public class APIManager {
    Context APIcontext;
    APIListener mListener;

    public APIManager(Context context) {
        this.APIcontext = context;
    }


    public JSONObject loginAPI(String posturl){
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(Finals.BASE_URL);

        try {
            httppost.setEntity(new StringEntity(posturl));
            HttpResponse resp = httpclient.execute(httppost);
            HttpEntity ent = resp.getEntity();

            // Log.i("loginresp1",EntityUtils.toString(ent));
            String jsonString= convertStreamToString(ent.getContent());
            Log.i("loginresp", jsonString);
            JSONObject jsonObject=new JSONObject(jsonString);
            return jsonObject;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } // adasdas
        return null;

    }
//asdasdasdsdasdasddasd

    public static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null; //dfsd

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        is.close();
        return sb.toString().trim();
    }

}
