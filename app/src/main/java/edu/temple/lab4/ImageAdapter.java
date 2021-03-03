package edu.temple.lab4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    ArrayList<String> options;

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

        LinearLayout layout = new LinearLayout(context);

        layout.setOrientation(LinearLayout.VERTICAL);
        TextView imageTextView = new TextView(context);
        imageTextView.setTextSize(28);
        layout.addView(imageTextView);

        return layout;
    }
}
