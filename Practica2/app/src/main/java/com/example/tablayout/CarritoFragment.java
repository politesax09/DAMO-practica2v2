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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class CarritoFragment extends ListFragment {


    public CarritoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_carrito,
                container, false);


        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        SQLiteDatabase db = gameDbHelper.getReadableDatabase();
        Cursor cursor = db.query("VEHICLES",
                new String[] {"_id", "MODEL","CARRITO","PRECIO"},
                "CARRITO=?",
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
        Button button = (Button) view.findViewById(R.id.btn_COMPRAR);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("se ha comprado");
            }
        });
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = new Intent(getActivity(), GameDetail.class);
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(getContext()) ;
        try
        {
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            Cursor cursor = db.query("VEHICLES",
                    new String[] {"_id", "MODEL","TYPE"},
                    "CARRITO=?",
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