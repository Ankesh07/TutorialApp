package com.example.ankesh.anku;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity{ //implements View.OnClickListener {


    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    DatabaseHandler mDatabase;
    //EditText editName, editPara;
    TextView textView;
    Cursor cursor;
    private static final String TABLE_NAME = "rita";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_PARA = "para";
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewParticularInfo(1);
        //editName = findViewById(R.id.n1);
        //editPara = findViewById(R.id.p1);
        textView = findViewById(R.id.textView);

         //findViewById(R.id.btn).setOnClickListener(this);
         //findViewById(R.id.button).setOnClickListener(this);


        mdrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);

        mdrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //  fragmentTransaction.add(R.id.main_frag,new BlankFragment());
        //  fragmentTransaction.commit();
        //getSupportActionBar().setTitle("Introduction");


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_intro:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(1);
                        getSupportActionBar().setTitle("Introduction");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l1:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(2);
                        getSupportActionBar().setTitle("OOP's Concept");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l2:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(3);
                        getSupportActionBar().setTitle("Classes & Object");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l3:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(4);
                        getSupportActionBar().setTitle("Access Specifier");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l4:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(5);
                        getSupportActionBar().setTitle("Method Overloading");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l5:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(6);
                        getSupportActionBar().setTitle("Method Overriding");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l6:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(7);
                        getSupportActionBar().setTitle("Constructor");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l7:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(8);
                        getSupportActionBar().setTitle("static keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l8:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(9);
                        getSupportActionBar().setTitle("super keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l9:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(10);
                        getSupportActionBar().setTitle("final keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l10:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(11);
                        getSupportActionBar().setTitle("this keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l11:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(12);
                        getSupportActionBar().setTitle("Interface");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l12:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(13);
                        getSupportActionBar().setTitle("Packages");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_l13:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(14);
                        getSupportActionBar().setTitle("Arrays");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l14:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(15);
                        getSupportActionBar().setTitle("Strings");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l15:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(16);
                        getSupportActionBar().setTitle("Exceptions");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l16:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(17);
                        getSupportActionBar().setTitle("throw & throws keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l17:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(18);
                        getSupportActionBar().setTitle("MultiThreading");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l18:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(19);
                        getSupportActionBar().setTitle("I/O Stream");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l19:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(20);
                        getSupportActionBar().setTitle("Byte Code & Unicode");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_l20:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        viewParticularInfo(21);
                        getSupportActionBar().setTitle("synchronized keyword");
                        menuItem.setChecked(true);
                        mdrawerLayout.closeDrawers();
                        break;
               }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


  /*  @Override
    public void onClick(View view) {
    switch (view.getId()) {
    case R.id.btn:
        add();
        break;
    case R.id.button:
        viewInfo();
        break;
    }
    }

    @Override
    protected void onDestroy() {
        mDatabase.close();
        super.onDestroy();
    }*/

//    private void add() {
//        String name ="sajksaddsa";//editName.getText().toString().trim();
//        String para ="dfssssssss";//editPara.getText().toString().trim();
//
////        if (name.isEmpty()) {
////            editName.setError("Can't Be Empty");
////            editName.requestFocus();
////            return;
////        }
////
////        if (para.isEmpty()) {
////            editPara.setError("Can't Be Empty");
////            editPara.requestFocus();
////            return;
////        }
//
//        if ((mDatabase.addDetails(name,para)) ==true) {
//            Log.d(TAG,"Data Inserted");
//        }
//      //      Toast.makeText(this, " Added Successfully", Toast.LENGTH_SHORT).show();
//        //else
//        //    Toast.makeText(this, " Added  NOt Successfully", Toast.LENGTH_SHORT).show();
//
//    }


//       private void viewInfo() {
//        Log.d(TAG, "viewInfo1: ");
//        cursor = mDatabase.getAllInfo();
//        String str = " ";
//        Log.d(TAG, "viewInfo2: ");
//        if (cursor.getCount() == 0) {
//            Toast.makeText(this, " No Data", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()) {
//                str = str + cursor.getString(0);
//            }
//            textView.setText(str);
//
//        }
//    }*/

    private void viewParticularInfo(int id) {
        Log.d(TAG, "Fetching: ");
        SQLiteDatabase db= openOrCreateDatabase(MainActivity.TABLE_NAME,MODE_PRIVATE,null);
        cursor=db.rawQuery("select " + COL_PARA + " from "+TABLE_NAME+" where id=?", new String[]{"" + id});
        String str = " ";
        if (cursor.getCount() == 0) {
            Toast.makeText(this, " Waiting...", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                str = str + cursor.getString(0);
            }
            Log.d(TAG, "Fetched " + str);
            textView.setText(str);
        }

    }
    }

