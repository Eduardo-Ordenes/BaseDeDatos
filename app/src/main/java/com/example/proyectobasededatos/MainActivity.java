package com.example.proyectobasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.proyectobasededatos.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;

    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            case R.id.crearBase:
                crearBase();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }


    private void nuevoRegistro(){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

    }


    private void crearBase(){
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db != null){

            Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(MainActivity.this, "Error al crear base de datos", Toast.LENGTH_SHORT).show();

        }

    }




}