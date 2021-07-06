package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ReclamarFragment extends Fragment implements View.OnClickListener{

    public ReclamarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_reclamar, container, false);

        Button button = view.findViewById(R.id.button_photo);
        button.setOnClickListener(
                new View.OnClickListener() {
            public void onClick(View view) {
                setImage(view);
            }
        });

        Button button2 = view.findViewById(R.id.sendButton);
        button2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart () {
        super.onStart();
        View v = getView();
    }

    @Override
    public void onClick(View v) {
        // Añadir al carrito
        String[] companyEmail = {"ignacio.quintero@live.u-tad.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        EditText msg = v.findViewById(R.id.issueEditText);
        String message = msg.getText().toString();

        EditText na = v.findViewById(R.id.nameEditText);
        String name = na.getText().toString();

        EditText em = v.findViewById(R.id.mailEditText);
        String email = em.getText().toString();

        emailIntent.putExtra(Intent.EXTRA_EMAIL,companyEmail);
        emailIntent.putExtra(Intent.EXTRA_REFERRER_NAME,name);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message.concat("\n \n " +
                "Este mensaje ha sido enviado por".concat(name.concat("\n\n" +
                        "Email: ".concat(email)))));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"RECLAMACION");
    }

    public void setImage(View v) {
    }
}