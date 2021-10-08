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

import androidx.appcompat.app.AppCompatActivity;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new NumbersFragment())
                .commit();
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
