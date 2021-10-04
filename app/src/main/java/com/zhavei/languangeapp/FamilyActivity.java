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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<WordDataModel> familyArrayList = new ArrayList<WordDataModel>();

        familyArrayList.add(new WordDataModel("tune", "anak cewe", R.drawable.family_daughter, R.raw.family_daughter));
        familyArrayList.add(new WordDataModel("әpә", "ayah", R.drawable.family_father, R.raw.family_father));
        familyArrayList.add(new WordDataModel("paapa", "kakek", R.drawable.family_grandfather, R.raw.family_grandfather));
        familyArrayList.add(new WordDataModel("ama", "nenek", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyArrayList.add(new WordDataModel("әṭa", "emak", R.drawable.family_mother, R.raw.family_mother));
        familyArrayList.add(new WordDataModel("taachi", "abang", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyArrayList.add(new WordDataModel("teṭe", "empo", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyArrayList.add(new WordDataModel("angsi", "anak", R.drawable.family_son, R.raw.family_son));
        familyArrayList.add(new WordDataModel("chalitti", "adek cowo", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyArrayList.add(new WordDataModel("kolliti", "adik cewe", R.drawable.family_younger_sister, R.raw.family_younger_sister));

        WordAdapater stringFamilyAdapter = new WordAdapater(this, familyArrayList, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringFamilyAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = familyArrayList.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, wordDataModel.getAudioResaourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                Toast.makeText(FamilyActivity.this, "finish play", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer !=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
