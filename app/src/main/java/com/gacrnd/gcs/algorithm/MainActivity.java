package com.gacrnd.gcs.algorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayDeque<String> aq = new ArrayDeque<>();
        aq.addFirst("String");
        PriorityQueue pq = new PriorityQueue();
    }
}
