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

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<WordDataModel> numbersArray = new ArrayList<WordDataModel>();

        numbersArray.add(new WordDataModel("lutti", "satu", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new WordDataModel("otiiko", "dua",R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new WordDataModel("tolookosu", "tiga",R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new WordDataModel("oyyisa", "empat",R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new WordDataModel("massokka", "lima",R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new WordDataModel("temmokka", "enam",R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new WordDataModel("kenekaku", "tujuh",R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new WordDataModel("kawinta", "delapan",R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new WordDataModel("wo’e", "sembilan",R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new WordDataModel("na’aacha", "sepuluh",R.drawable.number_ten, R.raw.number_ten));

        // using simple recycle view
        WordAdapater stringArrayAdapter = new WordAdapater(this, numbersArray, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = numbersArray.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, wordDataModel.getAudioResaourceId());
                mMediaPlayer.start();
            }
        });
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
