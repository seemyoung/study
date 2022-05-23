package com.example.cchat.activities;

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
import com.example.cchat.util.AppConfig;
import com.example.cchat.util.StringUtils;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        signInButton = findViewById(R.id.buttonSignin);
        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String pwd = inputPassword.getText().toString().trim();
                login(email, pwd);
            }
        });
    }

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
            public void onSuccess(String res) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {


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