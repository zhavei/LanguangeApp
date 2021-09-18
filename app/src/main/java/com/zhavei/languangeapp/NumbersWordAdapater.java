package com.zhavei.languangeapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NumbersWordAdapater extends ArrayAdapter<NumbersWord> {


    public NumbersWordAdapater(@NonNull Activity context, ArrayList<NumbersWord> numbersWordArrayList) {
        super(context, 0, numbersWordArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
