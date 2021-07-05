package com.example.tablayout;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


public class GameAdapter extends ResourceCursorAdapter
{
    public GameAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.Nombre);
        name.setText(cursor.getString(cursor.getColumnIndex("MODEL")));

        TextView price = (TextView) view.findViewById(R.id.Precio);
        price.setText(cursor.getString(cursor.getColumnIndex("PRECIO")));


    }
}
