package com.example.advancedpcproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Switch swh;
    TextView speed, led, heat, speedValue, ledValue, heatValue, title, motorTxt;

    Float valueOfHeat;
    Integer valueOfSpeed, valueOfRelay, valueOfLed;
    String valueOfLedColor;
    DatabaseReference roleDurumSet,roleDurumGet, sicaklik, ledRenk, hiz, ledDurum; //veriyolları
    FirebaseDatabase database; //database


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SetTemperature setTemperature =new SetTemperature(getApplicationContext());
        SetColor setColor = new SetColor(getApplicationContext());
        SetSpeed setSpeed = new SetSpeed(getApplicationContext());
        SetLed setLed = new SetLed(getApplicationContext());

        btn = findViewById(R.id.main_btn_motor);
        swh = findViewById(R.id.mainSwitch);
        speed = findViewById(R.id.mainTxtSpeed);
        led = findViewById(R.id.mainTxtLed);
        heat = findViewById(R.id.mainTxtHeat);
        speedValue = findViewById(R.id.mainTxtValueOfSpeed);
        ledValue = findViewById(R.id.mainTxtValueOfColor);
        heatValue = findViewById(R.id.mainTxtValueOfHeat);
        title = findViewById(R.id.mainTxtTitle);
        motorTxt = findViewById(R.id.mainTxtMotor);

        database = FirebaseDatabase.getInstance();

        roleDurumGet = database.getReference("roleDurumSet/int"); //veri yolları
        roleDurumSet = database.getReference("roleDurumGet/int");
        sicaklik = database.getReference("temperature/int");
        ledRenk = database.getReference("ledRenk/String");
        hiz = database.getReference("hiz/int");
        ledDurum = database.getReference("ledDurum/int");

        roleDurumGet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot veriTabaniVerisi) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueOfRelay = veriTabaniVerisi.getValue(Integer.class);
                databaseHelper.addRelay(valueOfRelay);

                if (valueOfRelay == 1) {
                    swh.setChecked(true);
                } else {
                    swh.setChecked(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
            }
        });

        sicaklik.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot veriTabaniVerisi) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueOfHeat = veriTabaniVerisi.getValue(Float.class);
                heatValue.setText(valueOfHeat + " C°");
                setTemperature.addTemp(valueOfHeat);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
            }
        });

        ledRenk.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot veriTabaniVerisi) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueOfLedColor = veriTabaniVerisi.getValue(String.class);
                setColor.addColor(valueOfLedColor);
                if(valueOfLed == 1){
                    ledValue.setText(valueOfLedColor);
                }else{
                    ledValue.setText("Led Kapalı");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
            }
        });

        hiz.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot veriTabaniVerisi) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueOfSpeed = veriTabaniVerisi.getValue(Integer.class);
                setSpeed.addSpeed(valueOfSpeed);
                speedValue.setText(valueOfSpeed + " Km/h");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
            }
        });

        ledDurum.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot veriTabaniVerisi) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                valueOfLed = veriTabaniVerisi.getValue(Integer.class);
                setLed.addLed(valueOfLed);
                if (valueOfLed == 1) {
                    motorTxt.setText("Led Açık");
                } else {
                    motorTxt.setText("Led Kapalı");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "" + error, Toast.LENGTH_LONG).show();
            }
        });

        swh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swh.isChecked()) {
                    roleDurumSet.setValue(1);

                } else {
                    roleDurumSet.setValue(0);

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valueOfLed==1){
                    ledDurum.setValue(0);
                    motorTxt.setText("Led Kapalı");
                    ledValue.setText("Led Kapalı");
                }else{
                    ledDurum.setValue(1);
                    motorTxt.setText("Led Açık");
                    ledValue.setText(valueOfLedColor);
                }
            }
        });

    }


}