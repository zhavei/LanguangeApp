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


public class ColorsFragment extends Fragment {

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


    public ColorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<WordDataModel> colorsArray = new ArrayList<WordDataModel>();

        colorsArray.add(new WordDataModel("kelelli", "putih", R.drawable.color_white, R.raw.color_white));
        colorsArray.add(new WordDataModel("weṭeṭṭi", "merah", R.drawable.color_red, R.raw.color_red));
        colorsArray.add(new WordDataModel("chokokki", "hijau", R.drawable.color_green, R.raw.color_green));
        colorsArray.add(new WordDataModel("ṭakaakki", "cokelat", R.drawable.color_brown, R.raw.color_brown));
        colorsArray.add(new WordDataModel("ṭopoppi", "abu abuy", R.drawable.color_gray, R.raw.color_gray));
        colorsArray.add(new WordDataModel("kululli", "hitam", R.drawable.color_black, R.raw.color_black));
        colorsArray.add(new WordDataModel("ṭopiisә", "kuning biasa", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArray.add(new WordDataModel("chiwiiṭә", "kuning telor", R.drawable.color_dusty_yellow, R.raw.color_mustard_yellow));

        WordAdapater stringArrayColors = new WordAdapater(getActivity(), colorsArray, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayColors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                WordDataModel wordDataModel = colorsArray.get(position);

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