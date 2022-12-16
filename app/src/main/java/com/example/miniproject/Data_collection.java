package com.example.miniproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Data_collection{
    String reg_no, suggestion;

    public Data_collection(String reg_no, String suggestion) {
        this.reg_no = reg_no;
        this.suggestion = suggestion;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getSuggestion() {
        return suggestion;
    }
}
