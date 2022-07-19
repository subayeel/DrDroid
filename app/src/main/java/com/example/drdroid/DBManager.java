package com.example.drdroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    private static final String dbname="medicineRemainder.db";
    private static final String TABLE_NAME = "tbl_medicine";
    public DBManager( Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tbl_medicine (id integer primary key autoincrement,name text,dose text,type text,time text)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS tbl_medicine");
        onCreate(db);
    }
    public  String addRecord(
            String medicineName,
            String medDose,
            String medType,
            String medTime)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",medicineName);
        cv.put("dose",medDose);
        cv.put("type",medType);
        cv.put("time",medTime);


        long res=db.insert("tbl_medicine",null,cv);

        if(res==-1)
            return "Failed";
        else
            return "Successfully inserted";
    }
    // we have created a new method for reading all the courses.
    public ArrayList<MedicineModal> readMedicines() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorMedicines = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<MedicineModal> medicineModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorMedicines.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                medicineModalArrayList.add(new MedicineModal(
                        cursorMedicines.getString(0),
                        cursorMedicines.getString(1),
                        cursorMedicines.getString(2),
                        cursorMedicines.getString(3),
                        cursorMedicines.getString(4)));
            } while (cursorMedicines.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorMedicines.close();
        return medicineModalArrayList;
    }

    public boolean dbEmpty(){
        boolean empty = true;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM "+TABLE_NAME, null);
        if (cur != null && cur.moveToFirst()) {
            empty = (cur.getInt (0) == 0);
        }
        cur.close();

        return empty;
    }

    public void deleteMedicine(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME,"id=?",new String[]{id});

    }
}
