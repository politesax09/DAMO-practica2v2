package com.example.tablayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ContactoPagerAdapter extends FragmentPagerAdapter {

    private Context m_context;

    public ContactoPagerAdapter (FragmentManager fragmentManager, Context context)
    {
        super(fragmentManager);
        m_context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return m_context.getResources().getText(R.string.contacto_tab);
            case 1:
                return m_context.getResources().getText(R.string.reclamo_tab);
        }
        return null;
    }

    @Override
    public int getCount ()
    {
        return 2;
    }

    @Override
    public Fragment getItem (int position)
    {
        switch (position)
        {
            case 0:
                return new ContactoFragment();
            case 1:
                return new ReclamarFragment();
        }
        return null;
    }

}
