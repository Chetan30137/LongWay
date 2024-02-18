package com.example.item_cart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_an_account extends AppCompatActivity {

    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("LongWay");
        Log.d("debug",reference.toString());
    }

    public void gotoLogin(View view) {
        User user = new User("Harsha","Nallapadu",37,"sriharsha1103@gmail.com","9908055084","password");
        reference.child("users").setValue(user);
        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(Create_an_account.this,LoginPage.class);
        startActivity(intent);
        finish();
    }
}