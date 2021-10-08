package com.zhavei.languangeapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudiomanager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);

        mAudiomanager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<WordDataModel> numbersArray = new ArrayList<WordDataModel>();

        numbersArray.add(new WordDataModel("lutti", "satu", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new WordDataModel("otiiko", "dua", R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new WordDataModel("tolookosu", "tiga", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new WordDataModel("oyyisa", "empat", R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new WordDataModel("massokka", "lima", R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new WordDataModel("temmokka", "enam", R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new WordDataModel("kenekaku", "tujuh", R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new WordDataModel("kawinta", "delapan", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new WordDataModel("wo’e", "sembilan", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new WordDataModel("na’aacha", "sepuluh", R.drawable.number_ten, R.raw.number_ten));

        // using simple recycle view
        WordAdapater stringArrayAdapter = new WordAdapater(getActivity(), numbersArray, R.color.category_numbers);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = numbersArray.get(position);

                Log.v("Numbers Activity", "current Word" + wordDataModel.toString());

                releaseMediaPlayer();

                int result = mAudiomanager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(getActivity(), wordDataModel.getAudioResaourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

                Toast.makeText(getActivity(), " finish play", Toast.LENGTH_SHORT).show();
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
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            // Abandon audio focus when playback complete
            mAudiomanager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}