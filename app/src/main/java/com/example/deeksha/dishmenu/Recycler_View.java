package com.example.deeksha.dishmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recycler_View extends AppCompatActivity {

    DatabaseReference mDatabase;
         DatabaseReference   dishes;

    public Recycler_View(DatabaseReference mDatabase) {
        this.mDatabase = mDatabase;
    }

    RecyclerView recyclerView;
    List<dishes> list = new ArrayList<>();
    private  com.example.deeksha.dishmenu.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__view);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        mAdapter=new Adapter(list);



        mDatabase= FirebaseDatabase.getInstance().getReference();
        dishes= mDatabase.child("Dishes");

        dishes.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                HashMap hashMap = (HashMap) dataSnapshot.getValue();
                String a = (String)hashMap.get("Name");

                String b = (String)hashMap.get("Price");
                dishes f = new dishes(a,b);
                list.add(f);
                mAdapter=new Adapter(list);
                recyclerView.setAdapter(mAdapter);



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
