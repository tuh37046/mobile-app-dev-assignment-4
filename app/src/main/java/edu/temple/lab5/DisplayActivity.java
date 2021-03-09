package edu.temple.lab5;

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
        setContentView(R.layout.display_layout);

        ImageView image = findViewById(R.id.largeImage);
        TextView  description = findViewById(R.id.description);

        ArrayList options = new ArrayList<String>();
        int[] images = new int[]{R.drawable.apple,R.drawable.banana,R.drawable.blueberry,R.drawable.raspberry};
        int index;

        Intent data = getIntent();

        options = (ArrayList<String>)data.getSerializableExtra("OPTIONS");
        images = data.getIntArrayExtra("IMAGES");
        index = data.getIntExtra("INDEX",0);

        description.setText((String)options.get(index));
        image.setImageResource(images[index]);

    }

}
