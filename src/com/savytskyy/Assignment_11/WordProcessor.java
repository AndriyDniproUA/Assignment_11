package com.savytskyy.Assignment_11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor {
    public static void countWords (String testString) {
        MyMap<String,Integer> wordSet = new MyMap<>();

        Pattern pattern = Pattern.compile("[а-яА-Я]+");
        Matcher matcher = pattern.matcher(testString);

        while (matcher.find()){
            String word =  matcher.group().toLowerCase();
            int counter = 1;

            if (wordSet.containsKey(word)) {
                counter = wordSet.get(word)+1;
            }
            wordSet.put(word, counter);
        }

        for (MyMap.Pair<String, Integer> pair: wordSet.pairSet()) {
            System.out.println(pair.getKey()+"-"+pair.getValue());
        }
    }
}
