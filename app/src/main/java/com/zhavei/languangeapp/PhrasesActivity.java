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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.ListIterator;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_activity);

        final ArrayList<WordDataModel> phrasesArrayList = new ArrayList<WordDataModel>();
        phrasesArrayList.add(new WordDataModel("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesArrayList.add(new WordDataModel("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrasesArrayList.add(new WordDataModel("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrasesArrayList.add(new WordDataModel("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrasesArrayList.add(new WordDataModel("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesArrayList.add(new WordDataModel("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrasesArrayList.add(new WordDataModel("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrasesArrayList.add(new WordDataModel("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        phrasesArrayList.add(new WordDataModel("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        phrasesArrayList.add(new WordDataModel("Come here.", "әnni'nem", R.raw.phrase_come_here));

        WordAdapater stringArrayPhrasesAdapter = new WordAdapater(this, phrasesArrayList, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayPhrasesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = phrasesArrayList.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, wordDataModel.getAudioResaourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(onCompletionListener);

                Toast.makeText(PhrasesActivity.this, "finish play", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        Log.v("PhrasesActivity", "onStop");

    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
