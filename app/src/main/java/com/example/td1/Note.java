package com.example.td1;

import android.text.Layout;

import java.util.Date;

public class Note {
    Date date;
    String module;
    int note;
    int coefficient;
    Layout layout;

    public Note(Date date, String module, int note, int coefficient, Layout layout) {
        this.date = date;
        this.module = module;
        this.note = note;
        this.coefficient = coefficient;
        this.layout = layout;
    }
}
