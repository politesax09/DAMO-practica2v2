package com.example.concesionario;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoriesAdapter extends FragmentPagerAdapter {

    Context m_context;

    public CategoriesAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    public CategoriesAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        m_context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return m_context.getResources().getText(R.string.title_tab_home);
            case 1:
                return m_context.getResources().getText(R.string.title_tab_bike);
            case 2:
                return m_context.getResources().getText(R.string.title_tab_car);
            case 3:
                return m_context.getResources().getText(R.string.title_tab_ofertas);
            case 4:
                return m_context.getResources().getText(R.string.title_tab_novedades);
            case 5:
                return m_context.getResources().getText(R.string.title_tab_carrito);
        }
        return null;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new BikeFragment();
            case 2:
                return new CarFragment();
            case 3:
                return new OfertasFragment();
            case 4:
                return new NovedadesFragment();
            case 5:
                return new CarritoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 6;
    }
}
