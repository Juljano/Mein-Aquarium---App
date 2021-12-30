package de.juljano.myaquarium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private AquariumValues aquariumValues;
    private RecyclerView recyclerView;
    private List<AquariumValues> aquariumValueslist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recyclerview

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initializing the list
        aquariumValueslist = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        // get Values from the Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Aquarium");

        // Read from the database and set the values
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {


                String getTemperature = ds.child("Temperatur").getValue().toString();
                String getWattage = ds.child("Info").getValue().toString();
                String getTDS = ds.child("TDS").getValue().toString();
                String getLightStatus = ds.child("Beleuchtung").getValue().toString();
                String getPH = ds.child("pH").getValue().toString();


                //removes the values if new ones are present
                aquariumValueslist.clear();

                aquariumValues = new AquariumValues(getTemperature, getTDS, getLightStatus, getPH, getWattage);


                //Create Cardview with the Information
                aquariumValueslist.add(new AquariumValues(aquariumValues.getTemperatur(), aquariumValues.getTds(), aquariumValues.getLightStatus(), aquariumValues.getpH(), aquariumValues.getWattage()));


                //creating recyclerview adapter
                CardviewAdapter adapter = new CardviewAdapter( MainActivity.this, aquariumValueslist);

                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(MainActivity.this, "Fehler beim lesen!", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
