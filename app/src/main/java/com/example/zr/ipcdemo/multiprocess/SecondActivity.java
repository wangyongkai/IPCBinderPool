package com.example.zr.ipcdemo.multiprocess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zr.ipcdemo.R;
import com.example.zr.ipcdemo.constant.MyConstants;
import com.example.zr.ipcdemo.datainfo.User;
import com.example.zr.ipcdemo.utils.MyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    void onButtonClick(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recoverFromFile();
    }


    private void recoverFromFile() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                User user = null;
                File cachedFile = new File(MyConstants.CACHE_FILE_PATH);
                if (cachedFile.exists()) {
                    ObjectInputStream objectInputStream = null;
                    try {
                        objectInputStream = new ObjectInputStream(
                                new FileInputStream(cachedFile));
                        user = (User) objectInputStream.readObject();
                        Log.d(TAG, "recover user:" + user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        MyUtils.close(objectInputStream);
                    }
                }
            }
        }).start();
    }
}
