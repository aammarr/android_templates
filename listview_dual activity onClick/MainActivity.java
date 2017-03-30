package com.example.ammarahmed.hla03;

import android.content.Intent;
import android.os.WorkSource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static android.R.attr.inAnimation;
import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> words = new ArrayList<String>();
    ArrayList<String> meanings = new ArrayList<String>();
    ArrayList<String> sentences = new ArrayList<String>();
    String[] temp ;
    String line;
    public static final String WORDS="Words";
    public static final String Meaning="Meaning";
    public static final String Sentence="Sentence";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.lv1);

        ArrayList<String> arrayList = new ArrayList<String>();

        InputStream is = getResources().openRawResource(R.raw.words);
        Scanner scanner = new Scanner(is);

        try{
            while(scanner.hasNext()){
                line=scanner.nextLine();
                temp=line.split(";");
                words.add(temp[0]);
                meanings.add(temp[1]);
                sentences.add(temp[2]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT)
//                        .show();

                Intent j = new Intent(MainActivity.this,DetailActivity.class);
                j.putExtra(WORDS,words.get(i));
                j.putExtra(Meaning,meanings.get(i));
                j.putExtra(Sentence,sentences.get(i));
                startActivity(j);

            }
        });


        scanner.close();

    }
}