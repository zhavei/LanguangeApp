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

import static android.media.AudioManager.AUDIOFOCUS_LOSS;


public class PhrasesFragment extends Fragment {
    MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public PhrasesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list_activity, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapater stringArrayPhrasesAdapter = new WordAdapater(getActivity(), phrasesArrayList, R.color.category_phrases);
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_activity);
        listView.setAdapter(stringArrayPhrasesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WordDataModel wordDataModel = phrasesArrayList.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(getActivity(), wordDataModel.getAudioResaourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
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
        Log.v("PhrasesActivity", "onStop");
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}