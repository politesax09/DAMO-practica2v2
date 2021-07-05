package com.example.tablayout;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Contacto extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CategoriesAdapter m_adapter;
    ViewPager         m_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_contact);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.contact_drawerLayout);

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

        ContactoPagerAdapter adapter = new ContactoPagerAdapter(
                getSupportFragmentManager(), this);

        ViewPager pager = findViewById(R.id.viewpager_contacto);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.contact_drawerLayout);
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
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.contact_drawerLayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
