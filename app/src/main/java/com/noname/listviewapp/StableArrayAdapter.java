package com.noname.listviewapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

class StableArrayAdapter extends ArrayAdapter<String> {
    private HashMap<String, Integer> idMap = new HashMap<>();

    // Create constructor and pass values from constructor to the super class/parent
    StableArrayAdapter(Context context, int resource, List<String> data) {
        super(context, resource, data);

        for (int i = 0; i < data.size(); i++) {
            idMap.put(data.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return idMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
