package com.example.concesionario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class VehicleDetailActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener  {
    int vehicleId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.GameDetail_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                0,
                0
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationdrawer_view);
        navigationView.setNavigationItemSelectedListener(this);

        vehicleId = Integer.valueOf(getIntent().getStringExtra("VEHICLEID"));
        SQLiteOpenHelper gameDbHelper = new BBDD(this) ;
        try {
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            Cursor cursor = db.query("VEHICLES",
                    new String[]{"_id", "MODEL", "COMPANY", "TYPE", "PRECIO", "IMAGE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(vehicleId)},
                    null, null, null);
            cursor.moveToFirst();
            vehicleId = cursor.getInt(0);
            ((TextView)findViewById(R.id.modelTextView)).setText(cursor.getString(1));
            ((TextView)findViewById(R.id.brandTextView)).setText(cursor.getString(2));
            ((TextView)findViewById(R.id.priceTextView)).setText(cursor.getString(4));
            ((ImageView)findViewById(R.id.imageView)).setImageResource(cursor.getInt(5));

            Button button = findViewById(R.id.buyButton);
            button.setOnClickListener(this);
        } catch (Exception e){}
    }

    @Override
    public void onClick(View v){
        SQLiteOpenHelper gameDbHelper = new BBDD(this) ;
        try{
            ContentValues cv = new ContentValues();
            cv.put("CARRITO", "true");
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            db.update("VEHICLES", cv, "MODEL=?", new String[]{((TextView)findViewById(R.id.modelTextView)).getText().toString()});
            Log.d("Contenido", "updateado");
        } catch (Exception e){}
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.GameDetail_drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent = null;
        switch (id) {
            case R.id.navHome:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navBikes:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navCars:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navOfertas:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navNovedades:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navMap:
                intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.navContact:
                intent = new Intent(getApplicationContext(), ContactoActivity.class);
                intent.putExtra("section", "contacto");
                startActivity(intent);
                break;
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.GameDetail_drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}