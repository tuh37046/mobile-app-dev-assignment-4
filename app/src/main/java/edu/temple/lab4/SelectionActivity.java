package edu.temple.lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList options = new ArrayList<String>();
        options.add("Apple");
        options.add("Banana");
        options.add("Blueberry");
        options.add("Raspberry");

        int[] images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.blueberry,R.drawable.raspberry};

        ImageAdapter adapter = new ImageAdapter(this, options);

       ImageView imageView = findViewById(R.id.imageView);
       Spinner spinner = findViewById(R.id.spinner);
       TextView text = findViewById(R.id.textView);
       spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectionActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
                text.setText("Selected "+options.get(position));
                imageView.setImageResource(images[position]);

                Intent display = new Intent(SelectionActivity.this,DisplayActivity.class);
                display.putExtra("OPTIONS",options);
                display.putExtra("IMAGES",images);
                display.putExtra("INDEX",position);

               startActivity(display);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SelectionActivity.this, "Deselected item", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
