package com.example.drdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class AddMedicineActivity extends AppCompatActivity {
 EditText medicineName,medDose;

 ExtendedFloatingActionButton addMedicine;
 Spinner medType,medTime;
 CheckBox isSunday,isMonday,isTuesday,isWednesday,isThursday,isFriday,isSaturday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        medicineName = findViewById(R.id.edit_med_name);
        medTime = findViewById(R.id.medicine_time);
        medDose= findViewById(R.id.med_dose);
        medType = findViewById(R.id.med_type);
        addMedicine = findViewById(R.id.btn_add_medicine);
        //weekdays checkboxes
        isSunday = findViewById(R.id.dv_sunday);
        isMonday = findViewById(R.id.dv_monday);
        isTuesday = findViewById(R.id.dv_tuesday);
        isWednesday = findViewById(R.id.dv_wednesday);
        isThursday = findViewById(R.id.dv_thursday);
        isFriday = findViewById(R.id.dv_friday);
        isSaturday = findViewById(R.id.dv_saturday);





        addMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(medicineName.getText().toString().equals("")){
                    Toast.makeText(AddMedicineActivity.this, "Please add name", Toast.LENGTH_SHORT).show();
                    return;
                } else if(medTime.getSelectedItem().toString().equals("Time")){
                    Toast.makeText(AddMedicineActivity.this, "Please enter time", Toast.LENGTH_SHORT).show();
                    return;
                }else if(medDose.getText().toString().equals("")){
                    Toast.makeText(AddMedicineActivity.this, "Please enter dose", Toast.LENGTH_SHORT).show();
                    return;
                }else if(medType.getSelectedItem().toString().equals("Type")){
                    Toast.makeText(AddMedicineActivity.this, "Please enter type", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    addRecord(view);
                    Intent i = new Intent(AddMedicineActivity.this, MainActivity.class);
                    startActivity(i);
                }


            }
        });
    }
    public void addRecord(View view)
    {
        DBManager db=new DBManager(this);

        String res=db.addRecord(
                medicineName.getText().toString(),
                medDose.getText().toString(),
                medType.getSelectedItem().toString(),
                medTime.getSelectedItem().toString()

                );

        Toast.makeText(this,res,Toast.LENGTH_LONG).show();


    }

}