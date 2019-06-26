package com.entry.fragmentteach;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] button = new Button[]{
                findViewById(R.id.bt1),
                findViewById(R.id.bt2),
                findViewById(R.id.bt3),
                findViewById(R.id.bt4),
        };
//        for (int i = 0 ; i < 4 ; i++){
//            button[i].setOnClickListener(this);
//        }
        for (Button n : button){
            n.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                replaceFragment(new Fragment_1());
                return;
            case R.id.bt2:
                replaceFragment(new BlankFragment_2());

                return;
            case R.id.bt3:
                replaceFragment(new BlankFragment_3());

                return;
            case R.id.bt4:
                replaceFragment(new BlankFragment_4());

                return;
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment).commit();
    }
}
