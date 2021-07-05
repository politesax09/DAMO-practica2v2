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


public class NovedadesFragment extends ListFragment {

   
    public NovedadesFragment() {
        // Required empty public constructor
    }

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLiteOpenHelper gameDbHelper = new BBDD(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("VEHICLES",
                new String[] {"_id", "MODEL","NOVEDADES","PRECIO"},
                "NOVEDADES=?",
                new String[]{"true"},
                null, null, null);
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                getContext(),
                R.layout.gameitem,
                cursor,
                new String[]{"MODEL","PRECIO"},
                new int[] {R.id.Nombre,R.id.Precio},
                0);
        setListAdapter(listAdapter);
        return inflater.inflate(R.layout.fragment_novedades, container, false);
    }




    

}