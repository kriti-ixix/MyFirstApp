package com.kriti.myfirstapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment
{
    ArrayList<String> textArr = new ArrayList<String>();
    ArrayList<Integer> imagesArr = new ArrayList<Integer>();
    GridView gridView;

    HomeFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = view.findViewById(R.id.myGridView);

        textArr.add("Water"); textArr.add("BMI");
        textArr.add("Heart Rate"); textArr.add("Workouts");

        imagesArr.add(R.drawable.ic_calculator); imagesArr.add(R.drawable.ic_profile);
        imagesArr.add(R.drawable.ic_email); imagesArr.add(R.drawable.ic_workouts);

        MyGridAdapter myGridAdapter = new MyGridAdapter();
        gridView.setAdapter(myGridAdapter);

        return view;
    }

    class MyGridAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return textArr.size();
        }

        @Override
        public Object getItem(int position) {
            return textArr.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view==null)
            {
                view = getLayoutInflater().inflate(R.layout.homelayout, parent, false);
            }

            ImageView imageView = view.findViewById(R.id.cardImageView);
            TextView textView =  view.findViewById(R.id.cardTextView);

            imageView.setImageResource(imagesArr.get(position));
            textView.setText(textArr.get(position));

            return view;
        }
    }
}