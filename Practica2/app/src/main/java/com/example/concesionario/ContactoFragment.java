package com.example.concesionario;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ContactoFragment extends Fragment implements View.OnClickListener{

    public ContactoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_contacto, container, false);

        Button button = view.findViewById(R.id.sendButton);
        button.setOnClickListener(this);

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
        String[] companyEmail = {"nacho.q.g.2000@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        EditText na = getView().findViewById(R.id.nameEditText);
        System.out.println(na);
        String name = na.getText().toString();

        EditText em = getView().findViewById(R.id.mailEditText);
        String email = em.getText().toString();

        EditText msg = getView().findViewById(R.id.issueEditText);
        String message = msg.getText().toString();

        emailIntent.putExtra(Intent.EXTRA_EMAIL,companyEmail);
        emailIntent.putExtra(Intent.EXTRA_REFERRER_NAME,name);

        emailIntent.putExtra(Intent.EXTRA_TEXT,message.concat("\n \n " +
                "Este mensaje ha sido enviado por".concat(name.concat("\n\n" +
                        "Email: ".concat(email)))));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"CONSULTA");

        startActivity(Intent.createChooser(emailIntent, "Elige app a usar"));
    }
}