package com.example.chanakya.volley2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        ListFragment listFragment = new ListFragment();
        DetailsFragment detailsFragment = new DetailsFragment();

        switch(screenSize ){

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:


                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,listFragment).commit();

                break;

            case Configuration.SCREENLAYOUT_SIZE_LARGE:

                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,listFragment).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer2,detailsFragment).commit();


                break;


        }

    }
}
