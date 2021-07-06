package com.example.tablayout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BikeFragment extends ListFragment {

    public BikeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLiteOpenHelper gameDbHelper = new BBDD(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("VEHICLES",
                new String[] {"_id", "MODEL","TYPE","PRECIO"},
                "TYPE=?",
                new String[]{"bike"},
                null, null, null);
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                getContext(),
                R.layout.vehicle_item,
                cursor,
                new String[]{"MODEL","PRECIO"},
                new int[] {R.id.itemModelTextView,R.id.itemPriceTextView},
                0);
        setListAdapter(listAdapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bike, container, false);
    }
}