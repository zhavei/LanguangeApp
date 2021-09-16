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

    ArrayList<String> numbersArray ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        numbersArray = new ArrayList<String>();

        numbersArray.add("one");
        numbersArray.add("two");
        numbersArray.add("tree");
        numbersArray.add("four");
        numbersArray.add("five");
        numbersArray.add("six");
        numbersArray.add("seven");
        numbersArray.add("eight");
        numbersArray.add("nine");
        numbersArray.add("ten");
        numbersArray.add("eleven");
        numbersArray.add("twoelve");
        numbersArray.add("thirteen");
        numbersArray.add("fourteen");
        numbersArray.add("fiveteen");
        numbersArray.add("sixteen");

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

            // using simple recycle view
          ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbersArray);
          GridView listView = (GridView) findViewById(R.id.number_activity_list);
          listView.setAdapter(stringArrayAdapter);

    }
}
