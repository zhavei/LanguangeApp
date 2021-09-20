package com.zhavei.languangeapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapater extends ArrayAdapter<WordDataModel> {


    public WordAdapater(@NonNull Activity context, ArrayList<WordDataModel> wordDataModelArrayList) {
        super(context, 0, wordDataModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_layout, parent, false);
        }
        WordDataModel currentNumbersList = getItem(position);
        TextView listItemDefaultTranslation = (TextView) listItemView.findViewById(R.id.default_languange);
        listItemDefaultTranslation.setText(currentNumbersList.getDefaultTrasnlation());

        TextView indoTranslationList = (TextView) listItemView.findViewById(R.id.indo_languange_list);
        indoTranslationList.setText(currentNumbersList.getLanguangeTranslation());

        return listItemView;
    }
}
