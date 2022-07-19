package com.example.drdroid;

import android.content.Context;
import android.util.Log;
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


    }


    @Override
    public int getItemCount() {
        // returning the size of our array list
        return medicineModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView  medName, medType, medTime, medDose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views

            medName = itemView.findViewById(R.id.tv_medName);
            medType = itemView.findViewById(R.id.tv_medType);
            medTime = itemView.findViewById(R.id.tv_medTime);
            medDose = itemView.findViewById(R.id.tv_medDose);



        }
    }
}
