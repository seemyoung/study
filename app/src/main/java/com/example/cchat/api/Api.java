package com.example.cchat.api;

import android.util.Log;
import com.example.cchat.util.AppConfig;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Api {

    private static OkHttpClient client;
    private static String requestUrl;
    private static HashMap<String, Object> mParams;
    public static Api api = new Api();
    public Api() {

    }
     public static Api config(String url, HashMap<String, Object> params) {
        client = new OkHttpClient.Builder().build();
        requestUrl = ApiConfig.BASE_URL + url;
        mParams = params;
        return api;
     }

     public void postRequest(TitlCallback callback) {

         JSONObject jsonObject = new JSONObject(mParams);
         String jsonStr = jsonObject.toString();
         RequestBody requestBodyJson =
                 RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonStr);

         Request request = new Request.Builder()
                 .url(requestUrl)
                 .addHeader("contentType", "application/json;charset=UTF-8")
                 .post(requestBodyJson)
                 .build();

         final Call call = client.newCall(request);

         call.enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 Log.e("onFailure", e.getMessage());
                 callback.onFailure(e);
             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 final String result = response.body().string();
                 callback.onSuccess(result);
             }
         });
     }
}
