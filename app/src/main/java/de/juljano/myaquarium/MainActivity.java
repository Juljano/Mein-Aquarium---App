package de.juljano.myaquarium;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private AquariumValues aquariumValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Read from the database

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Aquargbbium");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {

                    String getTemperature = ds.child("Temperatur").getValue(String.class);
                    String getWattage = ds.child("Info").getValue(String.class);
                    String getTDS = ds.child("TDS").getValue(String.class);
                    String getLightStatus = ds.child("Beleuchtung").getValue(String.class);
                    Log.d(TAG, getTemperature + " / " + getWattage + " / " + getTDS);
                    Toast.makeText(MainActivity.this, getTemperature + " / " + getWattage + " / " + getTDS + " / " + getLightStatus, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                Log.w("F", "Failed to read value.", error.toException());
            }
        });
    }
}
