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

public class ColorsActivity extends AppCompatActivity {

    ArrayList<WordDataModel> colorsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        colorsArray = new ArrayList<WordDataModel>();

        colorsArray.add(new WordDataModel("white", "putih"));
        colorsArray.add(new WordDataModel("red", "merah"));
        colorsArray.add(new WordDataModel("green", "hijau"));
        colorsArray.add(new WordDataModel("brown", "cokelat"));
        colorsArray.add(new WordDataModel("gray", "abu abuy"));
        colorsArray.add(new WordDataModel("black", "hitam"));
        colorsArray.add(new WordDataModel("dusty yellow", "kuning biasa"));
        colorsArray.add(new WordDataModel("mustard yellow", "kuning telor"));
        colorsArray.add(new WordDataModel("blue", "biru"));

        WordAdapater stringArrayColors = new WordAdapater(this, colorsArray);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayColors);


    }
}
