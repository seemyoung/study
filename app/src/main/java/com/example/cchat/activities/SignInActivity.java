package com.example.cchat.activities;

<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> cchat
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.cchat.R;
import com.example.cchat.api.Api;
import com.example.cchat.api.TitlCallback;
import com.example.cchat.databinding.ActivitySignInBinding;
<<<<<<< HEAD
import com.example.cchat.entity.LoginResponse;
import com.example.cchat.util.AppConfig;
import com.example.cchat.util.StringUtils;
import com.google.android.ads.mediationtestsuite.activities.HomeActivity;
import com.google.gson.Gson;
=======
import com.example.cchat.util.AppConfig;
import com.example.cchat.util.StringUtils;
>>>>>>> cchat
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.app.ProgressDialog.show;

public class SignInActivity extends BaseActivity {

    private ActivitySignInBinding binding;
    private EditText inputEmail;
    private EditText inputPassword;
    private Button signInButton;

    @Override
    protected int initLayout() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void initView() {
        setContentView(binding.getRoot());
        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String pwd = inputPassword.getText().toString().trim();
                login(email, pwd);
            }
        });
        setListeners();

    }

<<<<<<< HEAD
    @Override
    protected void initData() {
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        signInButton = findViewById(R.id.buttonSignin);
    }

=======
>>>>>>> cchat
    private void login(String email,String pwd){

        if (StringUtils.isEmpty(email)){
//            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
            showToast("please input email");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
//            Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show();
            showToast("please input password");
            return;
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        params.put("password", pwd);
        Api.config("/app/login", params).postRequest(new TitlCallback(){

            @Override
<<<<<<< HEAD
            public void onSuccess(final String res) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(res);
//                    }
//                });
                Log.e("onSuccess", res);
                showToastSync(res);
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(res, LoginResponse.class);
                if (loginResponse.getCode() == 0) {
                    String token = loginResponse.getToken();
                    saveStringToSp("token", token);
                    navigateTo(HomeActivity.class);
                    showToastSync("log in success");
                }else{
                    showToastSync("log in failed");
                }
//                res为json串
=======
            public void onSuccess(String res) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
>>>>>>> cchat
            }

            @Override
            public void onFailure(Exception e) {

<<<<<<< HEAD
                navigateTo(HomeActivity.class);
=======

>>>>>>> cchat
            }
        });
    }
//    private void login(String email,String pwd) {
//        if (StringUtils.isEmpty(email)){
////            Toast.makeText(this, "请输入邮箱", Toast.LENGTH_SHORT).show();
//            showToast("please input email");
//            return;
//        }
//        if (StringUtils.isEmpty(pwd)) {
////            Toast.makeText(this,"请输入密码", Toast.LENGTH_SHORT).show();
//            showToast("please input password");
//            return;
//        }
//
//        OkHttpClient client = new OkHttpClient.Builder().build();
//        Map m = new HashMap();
//        m.put("email", email);
//        m.put("password", pwd);
//        JSONObject jsonObject = new JSONObject(m);
//        String jsonStr = jsonObject.toString();
//        RequestBody requestBodyJson =
//                RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonStr);
//
//        Request request = new Request.Builder()
//                .url(AppConfig.BASE_URL + "/app/login")
//                .addHeader("contentType", "application/json;charset=UTF-8")
//                .post(requestBodyJson)
//                .build();
//
//        final Call call = client.newCall(request);
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("onFailure", e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        showToast(result);
//                    }
//                });
//            }
//        });

//}

    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v ->
                navigateTo(SignUpActivity.class));

    }
}