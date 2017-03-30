package com.example.ammarahmed.hla03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    Intent i ;
    String w,m,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView word_tv = (TextView) findViewById(R.id.tv_Word);
        TextView meaning_tv = (TextView) findViewById(R.id.tv_Meaning);
        TextView sentence_tv = (TextView) findViewById(R.id.tv_Sentence);

        i = getIntent();
        w = i.getStringExtra(MainActivity.WORDS);
        m = i.getStringExtra(MainActivity.Meaning);
        s = i.getStringExtra(MainActivity.Sentence);

        word_tv.setText(w);
        meaning_tv.setText(m);
        sentence_tv.setText(s);

    }
}
