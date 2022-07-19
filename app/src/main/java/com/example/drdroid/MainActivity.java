package com.example.drdroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addMedicineBtn;
    LinearLayout noMedicineLayout;
    private ArrayList<MedicineModal> medicineModalArrayList;
    private DBManager dbHandler;
    private MedicineRVAdapter medicineRVAdapter;
    private RecyclerView medicineRV;
    private boolean dbEmpty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addMedicineBtn = findViewById(R.id.addMedicineBtn);
        noMedicineLayout = findViewById(R.id.noMedicineLayout);


        addMedicineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddMedicineActivity.class);
                startActivity(intent);
                }
        });


        // initializing our all variables.
        medicineModalArrayList = new ArrayList<>();
        dbHandler = new DBManager(MainActivity.this);
        dbEmpty = dbHandler.dbEmpty();
        if(dbEmpty){
            noMedicineLayout.setVisibility(View.VISIBLE);
        }else{
            noMedicineLayout.setVisibility(View.GONE);
        }
        // getting our medicine array
        // list from db handler class.
        medicineModalArrayList = dbHandler.readMedicines();




        // on below line passing our array lost to our adapter class.
        medicineRVAdapter = new MedicineRVAdapter(medicineModalArrayList, MainActivity.this);
        medicineRV = findViewById(R.id.idRVMedicine);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        medicineRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        medicineRV.setAdapter(medicineRVAdapter);




    }


}