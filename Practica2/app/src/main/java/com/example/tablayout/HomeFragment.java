package com.example.tablayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends ListFragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onListItemClick(ListView l, View v, int position, long id)
    {
        Intent intent = new Intent(getActivity(), GameDetail.class);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        try
        {
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            Cursor cursor = db.query("VEHICLES",
                    new String[] {"_id", "MODEL","NOVEDADES"},
                    "NOVEDADES=?",
                    new String[]{"true"},
                    null, null, null);
            cursor.move(position+1);
            intent.putExtra("VEHICLEID", cursor.getString(0));
            startActivity(intent);
        }
        catch (Exception e) {
        }
    }
 
  
}