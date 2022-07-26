package com.example.drdroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicineRVAdapter extends RecyclerView.Adapter<MedicineRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<MedicineModal> medicineModalArrayList;
    private Context context;

    // constructor
    public MedicineRVAdapter(ArrayList<MedicineModal> medicineModalArrayList, Context context) {
        this.medicineModalArrayList = medicineModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        MedicineModal modal = medicineModalArrayList.get(position);
        holder.medName.setText(modal.getMedName());
        holder.medType.setText(modal.getMedType());
        holder.medDose.setText(modal.getMedDose());
        holder.medTime.setText(modal.getMedTime());

        holder.isSunday.setText(getSelectedDays("Sun",modal.getIsSunday()));
        holder.isMonday.setText(getSelectedDays("Mon",modal.getIsMonday()));
        holder.isTuesday.setText(getSelectedDays("Tue",modal.getIsTuesday()));
        holder.isWednesday.setText(getSelectedDays("Wed",modal.getIsWednesday()));
        holder.isThursday.setText(getSelectedDays("Thu",modal.getIsThursday()));
        holder.isFriday.setText(getSelectedDays("Fri",modal.getIsFriday()));
        holder.isSaturday.setText(getSelectedDays("Sat",modal.getIsSaturday()));




        holder.medEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateActivity.class);


                intent.putExtra("medId",modal.getMedId());
                intent.putExtra("medName",modal.getMedName());
                intent.putExtra("medType",modal.getMedType());
                intent.putExtra("medDose",modal.getMedDose());
                intent.putExtra("medTime",modal.getMedTime());

                intent.putExtra("isSunday",modal.getIsSunday());
                intent.putExtra("isMonday",modal.getIsMonday());
                intent.putExtra("isTuesday",modal.getIsTuesday());
                intent.putExtra("isWednesday",modal.getIsWednesday());
                intent.putExtra("isThursday",modal.getIsThursday());
                intent.putExtra("isFriday",modal.getIsFriday());
                intent.putExtra("isSaturday",modal.getIsSaturday());




                context.startActivity(intent);

            }
        });


    }



    @Override
    public int getItemCount() {
        // returning the size of our array list
        return medicineModalArrayList.size();
    }

    public String getSelectedDays(String dayName, String dayValue){
        if (dayValue.equals("1")){

            return dayName;
        }else{
            return "";
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView  medName, medType, medTime, medDose;
        private TextView isSunday,isMonday,isTuesday,isWednesday,isThursday,isFriday,isSaturday;
        private View medEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views

            medName = itemView.findViewById(R.id.tv_medName);
            medType = itemView.findViewById(R.id.tv_medType);
            medTime = itemView.findViewById(R.id.tv_medTime);
            medDose = itemView.findViewById(R.id.tv_medDose);
            medEdit = itemView.findViewById(R.id.edit_button);

            isSunday = itemView.findViewById(R.id.is_sunday);
            isMonday = itemView.findViewById(R.id.is_monday);
            isTuesday = itemView.findViewById(R.id.is_tuesday);
            isWednesday = itemView.findViewById(R.id.is_wednesday);
            isThursday = itemView.findViewById(R.id.is_thursday);
            isFriday = itemView.findViewById(R.id.is_friday);
            isSaturday = itemView.findViewById(R.id.is_saturday);



        }
    }
}
