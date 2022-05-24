package com.example.cchat.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    public void showToast(String msg) {

        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastSync(String msg) {

        Looper.prepare();
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public void navigateTo(Class cls) {

        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    protected void saveStringToSp(String key, String val) {
        SharedPreferences sp = getSharedPreferences("sp_cchat", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor .putString(key, val);
        editor.commit();
    }
}
