package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Array containing list of english words members
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.family_father,"father", "әpә", R.raw.family_father));
        words.add(new Word(R.drawable.family_mother,"mother", "әṭa", R.raw.family_mother));
        words.add(new Word(R.drawable.family_son,"son", "angsi", R.raw.family_son));
        words.add(new Word(R.drawable.family_daughter,"daughter", "tune", R.raw.family_daughter));
        words.add(new Word(R.drawable.family_older_brother,"older brother", "taachi", R.raw.family_older_brother));
        words.add(new Word(R.drawable.family_younger_brother,"younger brother", "chalitti", R.raw.family_younger_brother));
        words.add(new Word(R.drawable.family_older_sister,"older sister", "teṭe", R.raw.family_older_sister));
        words.add(new Word(R.drawable.family_younger_sister,"younger sister", "kolliti", R.raw.family_younger_sister));
        words.add(new Word(R.drawable.family_grandmother,"grandmother", "ama", R.raw.family_grandmother));
        words.add(new Word(R.drawable.family_grandfather,"grandfather", "paapa", R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word currentWord = words.get(position);
                Log.v("FamilyMembersActivity", "Current word: " + currentWord);
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, currentWord.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
