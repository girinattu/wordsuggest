package com.example.textapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WordSuggest wordSuggest = new WordSuggest();
        ArrayList<String> wordList = null;
        try {
            wordList = wordSuggest.readContentsFromFile(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] autoSuggestTexts = wordSuggest.convertListToArrayForAdapter(wordList);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, autoSuggestTexts);
        autoCompleteTextView.setAdapter(adapter);
    }



}