package com.example.chanakya.volley2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chanakya.volley2.model.Item;

public class MainActivity extends AppCompatActivity implements Listner{

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


                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,listFragment).addToBackStack(null).commit();

                break;

            case Configuration.SCREENLAYOUT_SIZE_LARGE:

                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,listFragment).addToBackStack(null).commit();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer2,detailsFragment).addToBackStack(null).commit();


                break;


        }




    }


    @Override
    public void onClick(Item item) {

      Bundle bundle = new Bundle();
      String[] data = {item.getTitle(),item.getDescription(),item.getImage()};
      bundle.putStringArray("data",data);

      DetailsFragment detailsFragment = new DetailsFragment();

      detailsFragment.setArguments(bundle);

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        switch(screenSize ){

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,detailsFragment).addToBackStack(null).commit();

                break;

            case Configuration.SCREENLAYOUT_SIZE_LARGE:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2,detailsFragment).addToBackStack(null).commit();


                break;


        }

    }



}
