package com.noname.listviewapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // Declare views
    ListView listView;
    EditText etCount;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init views
        listView = findViewById(R.id.lv_list);
        etCount = findViewById(R.id.et_count_value);
        btnLoad = findViewById(R.id.btn_load);
        // Set onClickListener for Button
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> data = fetchData();
                setupListView(data);
            }
        });
    }

    private void setupListView(List<String> data) {
        Log.d(TAG, "setupListView: " + data);
    }

    private List<String> fetchData() {
        // Declaring and Init values
        List<String> list = new ArrayList<>();
        int count;
        String etValue = etCount.getText().toString();

        // Will try to run code in the try scope first
        // if that fails will run code in the catch scope
        try {
            count = Integer.valueOf(etValue);
        } catch (Exception ex) {
            count = 10;
        }

        // loop that adds numbers to the list
        for (int i = 0; i < count; i++) {
            list.add("" + i);
        }

        // returns the list
        return list;
    }
}
