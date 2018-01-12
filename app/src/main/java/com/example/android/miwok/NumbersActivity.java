package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Array containing list of english numbers
        ArrayList<String> englishNumbers= new ArrayList<String>();
        englishNumbers.add("one");
        englishNumbers.add("two");
        englishNumbers.add("three");
        englishNumbers.add("four");
        englishNumbers.add("five");
        englishNumbers.add("six");
        englishNumbers.add("seven");
        englishNumbers.add("eight");
        englishNumbers.add("nine");
        englishNumbers.add("ten");

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        for(int i = 0;i<englishNumbers.size();i++) {
            TextView textView = new TextView(this);
            textView.setText(englishNumbers.get(i));
            rootView.addView(textView);
            Log.v("NumbersActivity", "Number at index " + i + " = " + englishNumbers.get(i));
        }
    }
}
