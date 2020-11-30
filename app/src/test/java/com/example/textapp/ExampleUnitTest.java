package com.example.textapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Ordering;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    MainActivity mainActivity = new MainActivity();
    WordSuggest wordsuggest = new WordSuggest();
    @Test
    public void no_words_with_non_alpha() throws Exception {
        ArrayList<String> all_alpha_words = wordsuggest.readContentsFromFile(mainActivity.getApplication());
        for (String word: all_alpha_words){
            assertTrue("There is a non-alpha character in the word "+ word,stringContainsNonAlpha(word));
        }
    }



    private boolean stringContainsNonAlpha(String wordStr) throws Exception {
        boolean containsNonAlpha = false;
            int strLen = wordStr.length();

            for (int index = 0; index < strLen - 1; index++) {
                if (!Character.isAlphabetic(wordStr.charAt(index))) {
                    containsNonAlpha = true;
                }
            }
        return containsNonAlpha;
    }

}