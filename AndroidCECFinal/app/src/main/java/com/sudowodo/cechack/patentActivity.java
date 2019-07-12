package com.sudowodo.cechack;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class patentActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    private patientAdapter listViewAdapter;
    private List<patientDetails> listEvent = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patent);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        Log.d("Activity patient","Hello");
        //mDatabase = FirebaseDatabase.getInstance();
        //databaseReference=mDatabase.getReference("Root").child("patientData");
        listView = findViewById(R.id.listViewPatient);
        patientDetails patientDetails = new patientDetails();
        patientDetails.setAge("70");
        patientDetails.setDiseaseType("Diagnosis: ALS");
        patientDetails.setName("Santhosh Pandit");
        patientDetails.setNurseID("State: Critical");
        patientDetails.setKey("1234");
        listEvent.add(patientDetails);

        listView = findViewById(R.id.listViewPatient);
        patientDetails patientDetails2 = new patientDetails();
        patientDetails2.setAge("Age: 68");
        patientDetails2.setDiseaseType("Diagnosis: Old Age");
        patientDetails2.setName("Donald Trump");
        patientDetails2.setNurseID("State: Critical");
        patientDetails2.setKey("1234");
        listEvent.add(patientDetails2);

//        addChildEventListener();
        listViewAdapter = new patientAdapter(this, listEvent);
        listView.setAdapter(listViewAdapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent navMain= new Intent(this, MainActivity.class);
                startActivity(navMain);
                break;

            case R.id.navigation_patients:
                break;

            case R.id.navigation_profile:
//                fragment = new ProfileFragment();
                Intent navPro= new Intent(this, profileActivity.class);
                startActivity(navPro);
                break;
        }

        return false;
    }


//    private void addChildEventListener() {
//        databaseReference.addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                //patientDetails patient= dataSnapshot.getValue(patientDetails.class);
//                Log.d("Abhishek patient",dataSnapshot.toString());
//                //Log.d("classEvent",dataSnapshot.child("eventName").toString());
//                //Log.d("classEventActual",dataSnapshot.getValue(patient.class).getTextOne());
//                //if(patient != null){
//                //    patient.setKey(dataSnapshot.getKey());
//                //    listEvent.add(dataSnapshot.getValue(patientDetails.class));
//                //    listViewAdapter.notifyDataSetChanged();
//               // }
//            }
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                //patient patient = dataSnapshot.getValue(patient.class);
//                Log.d("classAbhishek",dataSnapshot.toString());
////                if(patient != null){
////                    String key = dataSnapshot.getKey();
////                    for(int i=0;i<listEvent.size();i++){
////                        patient event1= listEvent.get(i);
////                        if(event1.getKey().equals(key)){
////                            listEvent.set(i, patient);
////                            listViewAdapter.notifyDataSetChanged();
//////                            return;
////                        }
////                    }
////                }
//            }
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                listEvent.remove(dataSnapshot.getValue(patient.class));
//                listViewAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        });
    }
