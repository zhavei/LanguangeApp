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
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private static final String TAG = "NumbersActivity";

    ArrayList<NumbersWord> numbersArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        numbersArray = new ArrayList<NumbersWord>();

        numbersArray.add(new NumbersWord("one", "satu"));
        numbersArray.add(new NumbersWord("two", "dua"));
        numbersArray.add(new NumbersWord("three", "tiga"));
        numbersArray.add(new NumbersWord("four", "empat"));
        numbersArray.add(new NumbersWord("five", "lima"));
        numbersArray.add(new NumbersWord("six", "enam"));
        numbersArray.add(new NumbersWord("seven", "tujuh"));
        numbersArray.add(new NumbersWord("eight", "delapan"));
        numbersArray.add(new NumbersWord("nine", "sembilan"));
        numbersArray.add(new NumbersWord("ten", "sepuluh"));
        numbersArray.add(new NumbersWord("eleven", "sebelas"));
        numbersArray.add(new NumbersWord("twoeleve", "duabelas"));
        numbersArray.add(new NumbersWord("threeten", "tigabelas"));
        numbersArray.add(new NumbersWord("fourten", "empatbelas"));
        numbersArray.add(new NumbersWord("fiveten", "limabelas"));
        numbersArray.add(new NumbersWord("sixten", "enambelas"));
        numbersArray.add(new NumbersWord("seventen", "tujubelas"));
        numbersArray.add(new NumbersWord("eighten", "delapanbelas"));
        numbersArray.add(new NumbersWord("nineten", "sembilanbelas"));
        numbersArray.add(new NumbersWord("twoenty", "duapuluh"));
        numbersArray.add(new NumbersWord("twoentyone", "duapuluhsatu"));

        // using simple recycle view
        NumbersWordAdapater stringArrayAdapter = new NumbersWordAdapater(this, numbersArray);
        GridView listView = (GridView) findViewById(R.id.number_activity_list);
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
