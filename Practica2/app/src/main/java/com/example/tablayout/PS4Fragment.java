package com.example.tablayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PS4Fragment extends ListFragment {

    public PS4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("VEHICLES",
                new String[] {"_id", "MODEL","TYPE","PRECIO"},
                "TYPE=?",
                new String[]{"ps4"},
                null, null, null);
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                getContext(),
                R.layout.gameitem,
                cursor,
                new String[]{"MODEL","PRECIO"},
                new int[] {R.id.Nombre,R.id.Precio},
                0);
        setListAdapter(listAdapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_p_s4, container, false);
    }



}