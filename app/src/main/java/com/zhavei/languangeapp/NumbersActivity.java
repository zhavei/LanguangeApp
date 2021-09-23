/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhavei.languangeapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<WordDataModel> numbersArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        numbersArray = new ArrayList<WordDataModel>();

        numbersArray.add(new WordDataModel("one", "satu", R.drawable.number_one));
        numbersArray.add(new WordDataModel("two", "dua", R.drawable.number_two));
        numbersArray.add(new WordDataModel("three", "tiga", R.drawable.number_three));
        numbersArray.add(new WordDataModel("four", "empat", R.drawable.number_four));
        numbersArray.add(new WordDataModel("five", "lima", R.drawable.number_five));
        numbersArray.add(new WordDataModel("six", "enam", R.drawable.number_six));
        numbersArray.add(new WordDataModel("seven", "tujuh", R.drawable.number_seven));
        numbersArray.add(new WordDataModel("eight", "delapan", R.drawable.number_eight));
        numbersArray.add(new WordDataModel("nine", "sembilan", R.drawable.number_nine));
        numbersArray.add(new WordDataModel("ten", "sepuluh", R.drawable.number_ten));
        numbersArray.add(new WordDataModel("eleven", "sebelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("twoeleve", "duabelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("threeten", "tigabelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("fourten", "empatbelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("fiveten", "limabelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("sixten", "enambelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("seventen", "tujubelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("eighten", "delapanbelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("nineten", "sembilanbelas", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("twoenty", "duapuluh", R.mipmap.ic_launcher_round));
        numbersArray.add(new WordDataModel("twoentyone", "duapuluhsatu", R.mipmap.ic_launcher_round));

        // using simple recycle view
        WordAdapater stringArrayAdapter = new WordAdapater(this, numbersArray);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayAdapter);
    }
}

//        //get list index by one element
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.number_activity_layoutid);
//        TextView wordView = new TextView(this);
//        wordView.setText(numbersArray.get(7));
//        rootView.addView(wordView);

//        //iterate arraylist using forloop
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.number_activity_list);
//        for (int i = 0; i < numbersArray.size(); i++) {
//            // Create a new TextView
//            TextView wordView = new TextView(this);
//            // Set the text to be word at the current index
//            wordView.setText(numbersArray.get(i));
//            // Add this TextView as another child to the root view of this layout
//            rootView.addView(wordView);
//        }
//        // iterate using whileloop
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.number_activity_layoutid);
//        int index = 0;
//        while (index < numbersArray.size()){
//            // Create a new TextView
//            TextView wordView = new TextView(this);
//            // Set the text to be word at the current index
//            wordView.setText(numbersArray.get(index));
//            // Add this TextView as another child to the root view of this layout
//            rootView.addView(wordView);
//            // Increment the index variable by 1 | shorthands for~ index = index + 1
//            index++;
//        }
