package com.example.ankesh.anku;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MyDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ank";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_PARA = "para";

    DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\n" +
                "    " + COL_ID + " INTEGER NOT NULL CONSTRAINT ankesh_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COL_NAME + " varchar(200) NOT NULL,\n" +
                "    " + COL_PARA + " varchar(30000) NOT NULL\n" +
                ");";
        sqLiteDatabase.execSQL(sql);
        //add();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);


    }
    public void add(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        String name = "Ankesh";
        String para = "Kumar Nayak";
        cv.put(COL_NAME, name);
        cv.put(COL_PARA, para);
        Log.d(TAG, "Add Deteils  ");
        sqLiteDatabase.insert(TABLE_NAME, null, cv);
        sqLiteDatabase.close();
    }

    /*  Cursor getAllInfo(){
          SQLiteDatabase sqLiteDatabase=getReadableDatabase();
          return sqLiteDatabase.rawQuery("select "+COL_PARA+ " from ankeshdb where id=?",new String[]{"11"} );
      }*/


    Cursor getParticularInfo(int id) {
        Log.d(TAG, "ASus  " + id);
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Log.d(TAG, "ASus  " + id);
        return sqLiteDatabase.rawQuery("select " + COL_PARA + " from ank where id=?", new String[]{"" + id});

    }

}
