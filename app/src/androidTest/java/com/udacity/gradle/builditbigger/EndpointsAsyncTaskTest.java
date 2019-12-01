package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    private String joke = null;

    @Test
    public void jokeLoadedTest() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new EndpointsAsyncTask(new EndpointsAsyncTask.TaskCompleteListener(){
            @Override
            public void onTaskComplete(String result) {
                joke = result;
                countDownLatch.countDown();
            }
        }).execute();


        try {
            countDownLatch.await();
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", TextUtils.isEmpty(joke));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}