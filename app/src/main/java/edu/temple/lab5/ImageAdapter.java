package edu.temple.lab5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    ArrayList<String> options;
    private LayoutInflater inflater;



    public ImageAdapter (Context context,ArrayList options) {
        this.context = context;
        this.options = options;
    }

    @Override
    public int getCount() {
        return options.size();
    }

    @Override
    public Object getItem(int position) {
        return this.options.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ArrayList options = new ArrayList<String>();
        options.add("Apple");
        options.add("Banana");
        options.add("Blueberry");
        options.add("Raspberry");

        int[] images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.blueberry,R.drawable.raspberry};


        LinearLayout layout = new LinearLayout(context);

        layout.setLayoutParams(new LinearLayout.LayoutParams(350,350));

        layout.setOrientation(LinearLayout.VERTICAL);
        TextView imageTextView = new TextView(context);
        imageTextView.setTextSize(24);
        imageTextView.setText((String)options.get(position));
        imageTextView.setTextColor(Color.parseColor("#FF000000"));
        imageTextView.setGravity(Gravity.CENTER);
        Drawable logo = ContextCompat.getDrawable(context,images[position]);
        imageTextView.setBackground(logo);
        layout.addView(imageTextView);

        return layout;
    }
}
