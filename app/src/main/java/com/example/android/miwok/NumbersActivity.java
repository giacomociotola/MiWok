package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Array containing list of english words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.number_one,"one", "lutti", R.raw.number_one));
        words.add(new Word(R.drawable.number_two,"two", "otiiko", R.raw.number_two));
        words.add(new Word(R.drawable.number_three,"three", "tolookosu", R.raw.number_three));
        words.add(new Word(R.drawable.number_four,"four", "oyyisa", R.raw.number_four));
        words.add(new Word(R.drawable.number_five,"five", "massokka", R.raw.number_five));
        words.add(new Word(R.drawable.number_six,"six", "temmokka", R.raw.number_six));
        words.add(new Word(R.drawable.number_seven,"seven", "kenekaku", R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight,"eight", "kawinta", R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine,"nine", "wo'e", R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten,"ten", "na'aacha", R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Word currentWord = words.get(position);
                Log.v("NumbersActivity", "Current word: " + currentWord);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, currentWord.getmAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
