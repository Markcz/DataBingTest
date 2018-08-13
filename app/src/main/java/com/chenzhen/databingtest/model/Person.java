package com.chenzhen.databingtest.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.chenzhen.databingtest.BR;


/**
 * Created by chenzhen on 2018/3/23.
 */

public class Person extends BaseObservable{

    private String name;
    private String age;


    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public Person() {
    }

    public Person(String name,String age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
