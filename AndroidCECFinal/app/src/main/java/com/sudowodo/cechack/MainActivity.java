package com.sudowodo.cechack;


//1x iv, 4x tv patientName, Age, NurseID DiseaseType

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.List;
//implements BottomNavigationView.OnNavigationItemSelectedListener
//implement the interface OnNavigationItemSelectedListener in your activity class
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private MyAdapter listViewAdapter;
    private List<patient> listEvent = new ArrayList<>();

    public DatabaseReference databaseReference;
    public FirebaseDatabase mDatabase;
    public Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Inside main activity","after set context");
        mDatabase = FirebaseDatabase.getInstance();
        databaseReference=mDatabase.getReference("Root").child("Realpatient");
        Log.d("Database",databaseReference.toString());

//        patient patient = new patient();
//        patient.textOne="Rabeeh";
//        patient.textTwo="has requested food";
//        listEvent.add(patient);
//
//        patient patient2 = new patient();
//        patient2.textOne="Rabeeh";
//        patient2.textTwo="has requested your assistance.";
//        listEvent.add(patient2);

        listView = findViewById(R.id.listView);
        addChildEventListener();
        listViewAdapter = new MyAdapter(this, listEvent);
        listView.setAdapter(listViewAdapter);


        //loading the default fragment
        //loadFragment(new HomeFragment());


        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(this);
    }




//    @Override
//    protected void onStart(){
//        super.onStart();
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Log.d("onDataChange",dataSnapshot.toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//    }
    private void addChildEventListener() {
        databaseReference.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                patient patient= dataSnapshot.getValue(patient.class);
                Log.d("Abhishek main",dataSnapshot.toString());
                Log.d("I hope this works ", patient.textTwo);
                //Log.d("classEvent",dataSnapshot.child("eventName").toString());
                //Log.d("classEventActual",dataSnapshot.getValue(patient.class).getTextOne());
                if(patient != null){
                    patient.setKey(dataSnapshot.getKey());
                    listEvent.add(dataSnapshot.getValue(patient.class));
                    listViewAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                //patient patient = dataSnapshot.getValue(patient.class);
                Log.d("classAbhishek",dataSnapshot.toString());
//                if(patient != null){
//                    String key = dataSnapshot.getKey();
//                    for(int i=0;i<listEvent.size();i++){
//                        patient event1= listEvent.get(i);
//                        if(event1.getKey().equals(key)){
//                            listEvent.set(i, patient);
//                            listViewAdapter.notifyDataSetChanged();
////                            return;
//                        }
//                    }
//                }
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                listEvent.remove(dataSnapshot.getValue(patient.class));
                listViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                break;

            case R.id.navigation_patients:
                Intent navPat= new Intent(this, patentActivity.class);
                startActivity(navPat);
                break;

            case R.id.navigation_profile:
//                fragment = new ProfileFragment();
                Intent navPro= new Intent(this, profileActivity.class);
                startActivity(navPro);
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }





}