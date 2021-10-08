package com.zhavei.languangeapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamiliyFragment extends Fragment {

     private MediaPlayer mediaPlayer;
     private AudioManager mAudioManager;
     private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
         @Override
         public void onAudioFocusChange(int focusChange) {
             if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                     focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                 mediaPlayer.pause();
                 mediaPlayer.seekTo(0);
             } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                 mediaPlayer.start();
             } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                 releaseMediaPlayer();
             }
         }
     };


     private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
         @Override
         public void onCompletion(MediaPlayer mp) {
             releaseMediaPlayer();
         }
     };

    public FamiliyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapater stringFamilyAdapter = new WordAdapater(getActivity(), familyArrayList, R.color.category_family);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(stringFamilyAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                WordDataModel wordDataModel = familyArrayList.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(
                        onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mediaPlayer = MediaPlayer.create(getActivity(), wordDataModel.getAudioResaourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }

                Toast.makeText(getActivity(), "finish play", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

}