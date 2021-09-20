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
import java.util.ListIterator;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<WordDataModel> phrasesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        phrasesArrayList = new ArrayList<WordDataModel>();
        phrasesArrayList.add(new WordDataModel("example", "contoh"));
        phrasesArrayList.add(new WordDataModel("find", "cari"));
        phrasesArrayList.add(new WordDataModel("walk", "jalan"));
        phrasesArrayList.add(new WordDataModel("run", "lari"));
        phrasesArrayList.add(new WordDataModel("sleep", "tidur"));
        phrasesArrayList.add(new WordDataModel("eat", "makan"));
        phrasesArrayList.add(new WordDataModel("sit", "duduk"));
        phrasesArrayList.add(new WordDataModel("read", "baca"));
        phrasesArrayList.add(new WordDataModel("hit", "pukul"));
        phrasesArrayList.add(new WordDataModel("push", "dorong"));

        WordAdapater stringArrayPhrasesAdapter = new WordAdapater(this, phrasesArrayList);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayPhrasesAdapter);
    }
}
