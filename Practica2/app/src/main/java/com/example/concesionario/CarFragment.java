package com.example.concesionario;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CarFragment extends ListFragment {

    public CarFragment() {
        // Required empty public constructor
    }

  /*  @Override */
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      SQLiteOpenHelper gameDbHelper = new BBDD(getContext()) ;
      SQLiteDatabase db = gameDbHelper.getReadableDatabase();
      Cursor cursor = db.query("VEHICLES",
              new String[] {"_id", "MODEL","TYPE","PRECIO"},
              "TYPE=?",
              new String[]{"car"},
              null,
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
      return inflater.inflate(R.layout.fragment_car, container, false);
  }
}