package com.example.textapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordSuggest {


    protected ArrayList<String> readContentsFromFile(Context context) throws IOException {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String wordFileName = "words";
        try {
            InputStream ins = context.getResources().openRawResource(
                    context.getResources().getIdentifier(wordFileName,
                            "raw", context.getPackageName()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ins));
            String line = bufferedReader.readLine();

            while (line != null) {
                if (!stringContainsNonAlpha(line)) {
                    stringArrayList.add(line);
                }
                line = bufferedReader.readLine();
            }
            ins.close();

        }


        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return stringArrayList;
    }

    private boolean stringContainsNonAlpha(String wordStr){

        boolean containsNonAlpha = false;
        try{
            int strLen = wordStr.length();

            for (int index = 0; index < strLen - 1; index++) {
                if (!Character.isAlphabetic(wordStr.charAt(index))) {
                    containsNonAlpha = true;
                }
            }
        } catch (NullPointerException ee){
            Log.d("End of File..",ee.getMessage());
        }
        return containsNonAlpha;
    }

    protected String[] convertListToArrayForAdapter(ArrayList<String> wordList){
        String[] autoSuggestTexts = new String[wordList.size()-1];
        for(int index =0; index< wordList.size()-1; index++){
            autoSuggestTexts[index] = wordList.get(index);
        }
        return autoSuggestTexts;
    }
}
