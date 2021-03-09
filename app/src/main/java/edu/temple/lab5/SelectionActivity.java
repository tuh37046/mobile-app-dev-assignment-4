package edu.temple.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    boolean interacted = false;

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

       //ImageView imageView = findViewById(R.id.imageView);
       GridView grid = findViewById(R.id.gridView);
       grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Selected");
                Toast.makeText(SelectionActivity.this, "Selected " + options.get(position), Toast.LENGTH_SHORT).show();

                Intent display = new Intent(SelectionActivity.this, DisplayActivity.class);
                display.putExtra("OPTIONS", options);
                display.putExtra("IMAGES", images);
                display.putExtra("INDEX", position);

                startActivity(display);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
