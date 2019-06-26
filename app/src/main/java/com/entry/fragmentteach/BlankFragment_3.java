package com.entry.fragmentteach;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class BlankFragment_3 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    ImageView image;
    int i = 0 ;
    int[] images = new int[]{
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
    };

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            image.setImageResource(images[i++]);
            i = i%3;
            super.handleMessage(msg);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_blank_fragment_3, container, false);

        image = view.findViewById(R.id.image);

        new Thread(){
            @Override
            public void run() {
                while (true){
                    Message msg = new Message();
                    handler.sendMessage(msg);
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        return view;
    }
}
