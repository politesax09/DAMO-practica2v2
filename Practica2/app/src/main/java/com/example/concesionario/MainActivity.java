package com.example.concesionario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CategoriesAdapter m_adapter;
    ViewPager         m_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Define elementos
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m_adapter = new CategoriesAdapter(getSupportFragmentManager(), this);
        m_pager   = findViewById(R.id.viewpager);
        m_pager.setAdapter(m_adapter);

        TabLayout tab = (TabLayout) findViewById(R.id.tablayout);
        tab.setupWithViewPager(m_pager);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
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

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {  //Navega por actividades al pulsar un elemento del menu
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.navHome:
                m_pager.setCurrentItem(0);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navBikes:
                m_pager.setCurrentItem(1);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navCars:
                m_pager.setCurrentItem(2);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navOfertas:
                m_pager.setCurrentItem(3);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navNovedades:
                m_pager.setCurrentItem(4);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navCompra:
                m_pager.setCurrentItem(5);
                m_adapter.notifyDataSetChanged();
                break;
            case R.id.navMap:
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.navContact:
                Intent contacto = new Intent(getApplicationContext(), ContactoActivity.class);
                contacto.putExtra("section", "contacto");
                startActivity(contacto);
                break;
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onVehicleClick(View view) { //Al pulsar un vehicle del home te redirige a los detalles de este
        Intent intent = new Intent(this, VehicleDetailActivity.class);
        SQLiteOpenHelper gameDbHelper = new BBDD(this) ;
        LinearLayout parent = (LinearLayout) view.getParent();
        String name = ((TextView)parent.findViewById(R.id.itemModelTextView)).getText().toString();
        try {
            SQLiteDatabase db = gameDbHelper.getReadableDatabase();
            Cursor cursor = db.query("VEHICLES",
                    new String[] {"_id", "MODEL","TYPE"},
                    "MODEL=?",
                    new String[]{name},
                    null, null, null);
            cursor.moveToNext();
            intent.putExtra("VEHICLEID", cursor.getString(0));
            startActivity(intent);
        } catch (Exception e) {
            String error =  e.getMessage().toString();
            Log.e(error, error);
        }
    }
}