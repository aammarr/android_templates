//spinner(dropdown).txt

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

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = (Spinner) findViewById(R.id.spinnerId);
        spin.setOnItemSelectedListener(this);

        List<String> list = new ArrayList<String>();
        list.add("male");
        list.add("female");
        list.add("nahi batana");

        ArrayAdapter theAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
        theAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theAdapter.notifyDataSetChanged();
        spin.setAdapter(theAdapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_SHORT)
                .show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}