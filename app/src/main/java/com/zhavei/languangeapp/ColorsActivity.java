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

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<WordDataModel> colorsArray = new ArrayList<WordDataModel>();

        colorsArray.add(new WordDataModel("kelelli", "putih", R.drawable.color_white, R.raw.color_white));
        colorsArray.add(new WordDataModel("weṭeṭṭi", "merah", R.drawable.color_red, R.raw.color_red));
        colorsArray.add(new WordDataModel("chokokki", "hijau", R.drawable.color_green, R.raw.color_green));
        colorsArray.add(new WordDataModel("ṭakaakki", "cokelat", R.drawable.color_brown, R.raw.color_brown));
        colorsArray.add(new WordDataModel("ṭopoppi", "abu abuy", R.drawable.color_gray, R.raw.color_gray));
        colorsArray.add(new WordDataModel("kululli", "hitam", R.drawable.color_black, R.raw.color_black));
        colorsArray.add(new WordDataModel("ṭopiisә", "kuning biasa", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArray.add(new WordDataModel("chiwiiṭә", "kuning telor", R.drawable.color_dusty_yellow, R.raw.color_mustard_yellow));

        WordAdapater stringArrayColors = new WordAdapater(this, colorsArray, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayColors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = colorsArray.get(position);

                mediaPlayer = MediaPlayer.create(ColorsActivity.this, wordDataModel.getAudioResaourceId());

                mediaPlayer.start();
            }
        });


    }
}
