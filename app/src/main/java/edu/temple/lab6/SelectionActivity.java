package edu.temple.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    boolean interacted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList options = new ArrayList<String>();
        options.add(getApplicationContext().getResources().getString(R.string.apple));
        options.add(getApplicationContext().getResources().getString(R.string.banana));
        options.add(getApplicationContext().getResources().getString(R.string.blueberry));
        options.add(getApplicationContext().getResources().getString(R.string.raspberry));

        int[] images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.blueberry,R.drawable.raspberry};

        ImageAdapter adapter = new ImageAdapter(this, options);

       GridView grid = findViewById(R.id.gridView);
       grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectionActivity.this, getApplicationContext().getResources().getString(R.string.present)+ " " + options.get(position), Toast.LENGTH_SHORT).show();

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
