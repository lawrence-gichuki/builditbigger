package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.providejokes.MyJoke;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    public String getData() {
        MyJoke myJoke = new MyJoke();
        String myData = myJoke.generateJoke();
        return myData;
    }

    public void setData(String data) {
    }
}
