package com.example.tablayout;

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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class GameDetail extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener  {
    int vehicleId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

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
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        try {
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            Cursor cursor = db.query("VEHICLES",
                    new String[]{"_id", "MODEL", "COMPANY", "TYPE", "PRECIO", "IMAGE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(vehicleId)},
                    null, null, null);
            cursor.moveToFirst();
            vehicleId = cursor.getInt(0);
            ((TextView)findViewById(R.id.videogameName)).setText(cursor.getString(1));
            ((TextView)findViewById(R.id.companyName)).setText(cursor.getString(2));
            ((TextView)findViewById(R.id.gamePrecio)).setText(cursor.getString(4));
            ((ImageView)findViewById(R.id.gameImage)).setImageResource(cursor.getInt(5));

            Button button = findViewById(R.id.button_carrito);
            button.setOnClickListener(this);

        }
        catch (Exception e){
        }

    }

    @Override
    public void onClick(View v){
        SQLiteOpenHelper gameDbHelper = new GameDataHelper(this) ;
        try{
            ContentValues cv = new ContentValues();
            cv.put("CARRITO", "true");
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            db.update("VEHICLES", cv, "MODEL=?", new String[]{((TextView)findViewById(R.id.videogameName)).getText().toString()});
            Log.d("Contenido", "updateado");
        }
        catch (Exception e){
        }

    }


    @Override
    public void onBackPressed()
    {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.GameDetail_drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Intent intent = null;
        switch (id)
        {
            case R.id.navigation_home :
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_ps4 :
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_xbox :
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_ofertas :
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_novedades :
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_maps :
                intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                break;
             case R.id.navigation_contacto :
                intent = new Intent(getApplicationContext(), Contacto.class);
                intent.putExtra("section", "contacto");
                startActivity(intent);
                break;
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.GameDetail_drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}