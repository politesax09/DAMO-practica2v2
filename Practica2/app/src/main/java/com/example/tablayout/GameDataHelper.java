package com.example.tablayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameDataHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "vehiclesDB";
    private static final int DBVERSION = 2;


    public GameDataHelper(Context context) {
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

        addVehicle (db, "FIFA19","APPEAL", "ps4", "1","46€", "false", "false", R.mipmap.caca);
        addVehicle (db, "The Witcher 3","APPEAL", "ps4", "1","54.6€", "false", "false", R.mipmap.thewitcher3);
        addVehicle (db, "SHENMUE","SEGA","xbox", "2","460€", "false", "false", R.mipmap.shenmue3);
        addVehicle (db, "GTA 5","LEVEL5","xbox", "2","468€", "true", "true",R.mipmap.gta5);
        addVehicle(db,"God of war","shdjhdjsh","ps4","2","463€", "true","true",R.mipmap.godofwar);
        addVehicle(db,"CyberPunk","holiwi","ps4","2","462€", "false", "false", R.mipmap.cyberpunk);
        addVehicle (db, "Village","APPEAL", "ps4","2","461€", "false","true", R.mipmap.village);
        addVehicle (db, "OUTCAST","APPEAL", "ps4", "1","444€", "false", "false",R.mipmap.outcast2);
        addVehicle (db, "Gears 5","APPEAL", "xbox", "1","456€", "false", "true", R.mipmap.gears5);
        addVehicle (db, "DOOM","APPEAL", "xbox", "2","466€", "false", "true",R.mipmap.doom);
        addVehicle (db, "CALL OF DUTY 4","SEGA","ps4", "2","426€", "false", "true", R.mipmap.callofduty4);
        addVehicle (db, "FAR CRY","SEGA","xbox", "1","46€", "false", "true",R.mipmap.farcry);

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
