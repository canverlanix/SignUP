package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class Signup extends AppCompatActivity {

    EditText EMAIL;
    EditText PASSWORD;
    EditText FIRSTNAME;
    EditText LASTNAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // llamar los ids
        EMAIL = findViewById(R.id.idEmail);
        //PASSWORD = findViewById(R.id.idPassword);
        //FIRSTNAME = findViewById(R.id.idFirstname);
       // LASTNAME = findViewById(R.id.idLastname);

    }
    public void Register(View view) {
        // 1. create database manager
        //llmar la clase
        connectionDB manager = new connectionDB(this, "data", null, 1);

        //2. let database
        SQLiteDatabase market = manager.getReadableDatabase();
        //3. get values /number
        String Email = EMAIL.getText().toString();
        String Password = "1234";
        String Fname = "Ruiz";
        String Lname = "Carlos";
        //crear ek contenedor de values

        if(!Email.isEmpty() ||Password.isEmpty() || !Lname.isEmpty() || !Fname.isEmpty()){

            ContentValues DATA = new ContentValues();
            //5. crear los paquete de datos o contenedor de datos
            DATA.put("email", Email);
            DATA.put("password", Password);
            DATA.put("firstname", Fname);
//.6 save data inft market database
            market.insert("users",null,DATA);
            Toast.makeText(this, "The user has been dreated !!!", Toast.LENGTH_SHORT).show();
            market.close();
        }else{
            Toast.makeText(this, "You must complete all fields", Toast.LENGTH_SHORT).show();
        }

        }



    }
