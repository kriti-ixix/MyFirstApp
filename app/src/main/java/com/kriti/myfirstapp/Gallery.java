package com.kriti.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ArrayList<String> myText = new ArrayList<>();
    ArrayList<Integer> myImages = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        myText.add("A"); myText.add("B"); myText.add("C");
        myText.add("D"); myText.add("E");

        myImages.add(R.mipmap.cinnamoroll);
        myImages.add(R.mipmap.hellokitty);
        myImages.add(R.mipmap.dumplings);
        myImages.add(R.mipmap.molang);
        myImages.add(R.mipmap.mymelody);

        listView = findViewById(R.id.customListView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return myText.size();
        }

        @Override
        public Object getItem(int position) {
            return myText.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view==null)
            {
                view = getLayoutInflater().inflate(R.layout.customlayout, parent, false);
            }

            ImageView imageView = view.findViewById(R.id.customImageView);
            TextView textView =  view.findViewById(R.id.customTextView);

            imageView.setImageResource(myImages.get(position));
            textView.setText(myText.get(position));

            return view;
        }
    }
}