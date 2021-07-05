package com.example.tablayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDD extends SQLiteOpenHelper {
    private static final String DBNAME = "vehiclesDB";
    private static final int DBVERSION = 2;


    public BBDD(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE VEHICLES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "MODEL TEXT, "
                + "COMPANY TEXT, "
                + "TYPE TEXT,"
                + "OFERTA TEXT,"
                + "PRECIO TEXT,"
                + "CARRITO TEXT,"
                + "NOVEDADES TEXT,"
                + "IMAGE_ID INTEGER); ");

        addVehicle (db, "Harley Davison Fat Bob","Harley-Davison", "bike", "1","14.350€", "false", "false", R.mipmap.caca);
        addVehicle (db, "KTM 1290 Super Duke","KTM", "bike", "1","13.800€", "false", "false", R.mipmap.thewitcher3);
        addVehicle (db, "Vespa GTS","Vespa-Piaggio","bike", "2","5.799€", "false", "false", R.mipmap.shenmue3);
        addVehicle (db, "Aprilia RS 660","Aprilia","bike", "2","10.230€", "true", "true",R.mipmap.gta5);
        addVehicle(db,"Triumph Speed Triple 1050 RS","Triumph","bike","2","16.272€", "true","true",R.mipmap.godofwar);
        addVehicle(db,"BMW M 1000 RR","BMW","bike","2","17.490€", "false", "false", R.mipmap.cyberpunk);
        addVehicle (db, "BMW Serie 5","BMW", "car","2","12.580€", "false","true", R.mipmap.village);
        addVehicle (db, "Toyota Yaris","Toyota", "car", "1","9.520€", "false", "false",R.mipmap.outcast2);
        addVehicle (db, "SEAT Leon","SEAT", "car", "1","4.660€", "false", "true", R.mipmap.gears5);
        addVehicle (db, "Peugeot 306","Peugeot", "car", "2","5.572€", "false", "true",R.mipmap.doom);
        addVehicle (db, "Volkswagen Bettle","Volkswagen","car", "2","15.125€", "false", "true", R.mipmap.callofduty4);
        addVehicle (db, "Ford Focus Mk4","Ford","car", "1","21.230€", "false", "true",R.mipmap.farcry);

    }



    public static void addVehicle (SQLiteDatabase db, String model, String company,String type,String oferta,String precio,String seleccionado,String novedades, int imageID)
    {
        ContentValues vehiclesData = new ContentValues();
        vehiclesData.put("MODEL", model);
        vehiclesData.put("COMPANY", company);
        vehiclesData.put("TYPE", type);
        vehiclesData.put("OFERTA",oferta);
        vehiclesData.put("PRECIO",precio);
        vehiclesData.put("CARRITO", seleccionado);
        vehiclesData.put("NOVEDADES", novedades);
        vehiclesData.put("IMAGE_ID", imageID);
        db.insert("VEHICLES", null, vehiclesData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
