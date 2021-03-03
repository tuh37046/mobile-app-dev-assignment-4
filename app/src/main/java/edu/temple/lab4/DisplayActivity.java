package edu.temple.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        TextView  textView = findViewById(R.id.textView);

        ArrayList options = new ArrayList<String>();
        int[] images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.blueberry,R.drawable.raspberry};
        int index;

        Intent data = getIntent();

        options = (ArrayList<String>)data.getSerializableExtra("OPTIONS");
        images = data.getIntArrayExtra("IMAGES");
        index = data.getIntExtra("INDEX",0);


        textView.setText((String)options.get(index));
        imageView.setImageResource(images[index]);

    }

}
