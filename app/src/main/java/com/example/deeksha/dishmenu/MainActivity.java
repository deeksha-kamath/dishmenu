package com.example.deeksha.dishmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button viewlist;

    private Button addButton;
    private EditText addName;
    private EditText addPrice;
    private DatabaseReference mDatabase;
    private DatabaseReference dish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        dish = mDatabase.child("Fishes");



        addButton=(Button) findViewById(R.id.addButton);
        addName=(EditText) findViewById(R.id.addName);
        addPrice=(EditText) findViewById(R.id.addPrice);
        viewlist =(Button) findViewById(R.id.viewList);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = addName.getText().toString().trim();
                String price = addPrice.getText().toString().trim();

                String userId=Dish.push().getKey();
                Dish nuste = new Dish (name,price);

                dish.child(userId).setValue(nuste);
                Toast.makeText(MainActivity.this,"NUste aDeed",Toast.LENGTH_SHORT).show();

            }
        });


        viewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent n = new Intent(MainActivity.this,Recycler_View.class);
                startActivity(n);
            }
        });




    }
}
