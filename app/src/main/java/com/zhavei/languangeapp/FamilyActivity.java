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

public class FamilyActivity extends AppCompatActivity {

    ArrayList<WordDataModel> familyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        familyArrayList = new ArrayList<WordDataModel>();

        familyArrayList.add(new WordDataModel("daughter", "anak cewe", R.drawable.family_daughter));
        familyArrayList.add(new WordDataModel("father", "ayah", R.drawable.family_father));
        familyArrayList.add(new WordDataModel("grandfather", "kakek", R.drawable.family_grandfather));
        familyArrayList.add(new WordDataModel("grandmother", "nenek", R.drawable.family_grandmother));
        familyArrayList.add(new WordDataModel("mother", "emak", R.drawable.family_mother));
        familyArrayList.add(new WordDataModel("older brother", "abang", R.drawable.family_older_brother));
        familyArrayList.add(new WordDataModel("older sister", "empo", R.drawable.family_older_sister));
        familyArrayList.add(new WordDataModel("son", "anak", R.drawable.family_son));
        familyArrayList.add(new WordDataModel("younger brother", "adek cowo", R.drawable.family_younger_brother));
        familyArrayList.add(new WordDataModel("younger sister", "adik cewe", R.drawable.family_younger_sister));

        WordAdapater stringFamilyAdapter = new WordAdapater(this, familyArrayList);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringFamilyAdapter);
    }
}
