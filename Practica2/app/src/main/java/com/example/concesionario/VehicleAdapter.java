package com.example.concesionario;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


public class VehicleAdapter extends ResourceCursorAdapter {

    public VehicleAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.itemModelTextView);
        name.setText(cursor.getString(cursor.getColumnIndex("MODEL")));

        TextView price = (TextView) view.findViewById(R.id.itemPriceTextView);
        price.setText(cursor.getString(cursor.getColumnIndex("PRECIO")));
    }
}
