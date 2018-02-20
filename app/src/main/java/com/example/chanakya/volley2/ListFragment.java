package com.example.chanakya.volley2;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chanakya.volley2.adapter.MyAdapter;
import com.example.chanakya.volley2.model.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    RequestQueue queue ;
    String url ="http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    List<Item> items;

    RecyclerView recyclerView;
    MyAdapter adapter;
    ToggleButton tg;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_list, container, false);

        tg = v.findViewById(R.id.toggleButton);

        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(tg.isChecked()){
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
                else{
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
                }

            }
        });

        recyclerView.setHasFixedSize(true);

        items = new ArrayList<>();

        queue = Volley.newRequestQueue(getContext());
        final StringRequest stringRequest = new StringRequest(Request.Method.GET,url,

                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("RelatedTopics");

                            for(int i=0;i<array.length();i++){
                                JSONObject data = array.getJSONObject(i) ;
                                String titleAndDescription = data.getString("Text");
                                String[] titleAndDescArray= titleAndDescription.split("-");
                                JSONObject imageObject =  data.getJSONObject("Icon");
                                String image = imageObject.getString("URL");;



                                Item item = new Item(image,titleAndDescArray[0],titleAndDescArray[1]);
                                items.add(item);

                            }

                            adapter = new MyAdapter(getContext(),items);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(stringRequest);





        return v;
    }

}
