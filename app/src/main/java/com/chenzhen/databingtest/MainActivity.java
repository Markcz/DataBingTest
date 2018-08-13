package com.chenzhen.databingtest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.chenzhen.databingtest.adapter.ListAdapter;
import com.chenzhen.databingtest.databinding.ActivityMainBinding;
import com.chenzhen.databingtest.model.Person;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Person> mPersons = new ArrayList<>();
    Person person ;
    int i = 0 ;


    ActivityMainBinding bind;
    private MyHandler mHandler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        person = new Person();
        bind.setPerson(person);
        mHandler = new MyHandler(bind,MainActivity.this);
        bind.setAdapter(new ListAdapter<>(MainActivity.this,mPersons,R.layout.item_list_view_layout,BR.user));
        initData();
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10 ; i ++){
                    Person person = new Person("Tom--"+ i,"" + 20 + i);
                    mPersons.add(person);
                }
                mHandler.sendEmptyMessage(0);
                //mHandler1.sendEmptyMessage(0);
            }
        }).start();
    }

    private static class MyHandler extends Handler{

        private final WeakReference<ActivityMainBinding> weakBind;
        private final WeakReference<MainActivity> weakMain;

        public MyHandler(ActivityMainBinding bind,MainActivity main) {
            weakBind = new WeakReference<> (bind);
            weakMain = new WeakReference<> (main);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (weakBind.get() != null && weakMain.get() != null){
                weakBind.get().setAdapter(new ListAdapter<>(weakMain.get(),weakMain.get().mPersons,R.layout.item_list_view_layout,BR.user));
            }
        }
    }

}
