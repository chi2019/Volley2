package com.example.chanakya.volley2;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

   ImageView image;
   TextView title,description;
   String[] data;

    public DetailsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        title = v.findViewById(R.id.textViewTitle);
        description = v.findViewById(R.id.textViewDescription);
        image = v.findViewById(R.id.imageViewImage);

        Bundle bundle = this.getArguments();
        data = getArguments().getStringArray("data");

        String imageUrl = data[2];
        String tit = data[0];
        String desc = data[1];


        if (image.equals("")) {
            image.setImageResource(R.drawable.ic_launcher_background);
        } else{
            Picasso.with(getContext()).load(imageUrl).placeholder(R.drawable.ic_launcher_background).into(image
            );

        }




       title.setText(tit);
       description.setText(desc);


        return v;
    }



}
