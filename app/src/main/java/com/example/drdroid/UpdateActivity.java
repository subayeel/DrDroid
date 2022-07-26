package com.example.drdroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class UpdateActivity extends AppCompatActivity {
    EditText updateMedicineName,updateMedDose;

    Button updateBtn,deleteBtn;
    Spinner updateMedType,updateMedTime;
    DBManager dbManager;
    CheckBox updateIsSunday,updateIsMonday,updateIsTuesday,updateIsWednesday,updateIsThursday,updateIsFriday,updateIsSaturday;
    String medName,medType,medDose,medTime,medId;
    String isSunday,isMonday,isTuesday,isWednesday,isThursday,isFriday,isSaturday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateMedicineName = findViewById(R.id.update_edit_med_name);
        updateMedDose = findViewById(R.id.update_med_dose);
        updateMedType = findViewById(R.id.update_med_type);
        updateMedTime = findViewById(R.id.update_med_time);

        updateIsSunday = findViewById(R.id.update_dv_sunday);
        updateIsMonday = findViewById(R.id.update_dv_monday);
        updateIsTuesday = findViewById(R.id.update_dv_tuesday);
        updateIsWednesday = findViewById(R.id.update_dv_wednesday);
        updateIsThursday = findViewById(R.id.update_dv_thursday);
        updateIsFriday = findViewById(R.id.update_dv_friday);
        updateIsSaturday = findViewById(R.id.update_dv_saturday);



        updateBtn = findViewById(R.id.update_button);
        deleteBtn = findViewById(R.id.delete_button);

        //getting data intent data
        medId = getIntent().getStringExtra("medId");
        medName = getIntent().getStringExtra("medName");
        medType = getIntent().getStringExtra("medType");
        medDose = getIntent().getStringExtra("medDose");
        medTime = getIntent().getStringExtra("medTime");

        isSunday = getIntent().getStringExtra("isSunday");
        isMonday = getIntent().getStringExtra("isMonday");
        isTuesday = getIntent().getStringExtra("isTuesday");
        isWednesday = getIntent().getStringExtra("isWednesday");
        isThursday = getIntent().getStringExtra("isThursday");
        isFriday = getIntent().getStringExtra("isFriday");
        isSaturday = getIntent().getStringExtra("isSaturday");



        //setting data to text field
        updateMedicineName.setText(medName);
        updateMedDose.setText(medDose);
        updateMedTime.setSelection(3);
        updateMedType.setSelection(3);

        updateIsSunday.setChecked(isDaySelected(isSunday));
        updateIsMonday.setChecked(isDaySelected(isMonday));
        updateIsTuesday.setChecked(isDaySelected(isTuesday));
        updateIsWednesday.setChecked(isDaySelected(isWednesday));
        updateIsThursday.setChecked(isDaySelected(isThursday));
        updateIsFriday.setChecked(isDaySelected(isFriday));
        updateIsSaturday.setChecked(isDaySelected(isSaturday));


        dbManager = new DBManager(UpdateActivity.this);



        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.updateMedicine(medId,updateMedicineName.getText().toString(),
                        updateMedDose.getText().toString(),
                        updateMedType.getSelectedItem().toString(),
                        updateMedTime.getSelectedItem().toString());

                Toast.makeText(UpdateActivity.this, "Meds Updated", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManager.deleteMedicine(updateMedicineName.getText().toString());

                Toast.makeText(UpdateActivity.this, "Medicine deleted", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public boolean isDaySelected(String dayValue){
        if(dayValue.equals("1")){
            return true;
        }
        else{
            return false;
        }
    }
    
}