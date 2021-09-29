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

        colorsArray.add(new WordDataModel("white", "putih", R.drawable.color_white));
        colorsArray.add(new WordDataModel("red", "merah", R.drawable.color_red));
        colorsArray.add(new WordDataModel("green", "hijau", R.drawable.color_green));
        colorsArray.add(new WordDataModel("brown", "cokelat", R.drawable.color_brown));
        colorsArray.add(new WordDataModel("gray", "abu abuy", R.drawable.color_gray));
        colorsArray.add(new WordDataModel("black", "hitam", R.drawable.color_black));
        colorsArray.add(new WordDataModel("dusty yellow", "kuning biasa", R.drawable.color_dusty_yellow));
        colorsArray.add(new WordDataModel("mustard yellow", "kuning telor", R.drawable.color_dusty_yellow));

        WordAdapater stringArrayColors = new WordAdapater(this, colorsArray, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayColors);


    }
}
