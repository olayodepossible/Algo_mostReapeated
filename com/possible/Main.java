package com.possible;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public String findMostRepeatedWord(String input){
        // Create a Hashmap to keep track of how often we have seen each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Normalize your input data i.e clean the data
        String lowerCase = input.toLowerCase().trim();
        String [] words = lowerCase.split("[\\n\\t\\r.,;:!?()' ']");

        System.out.println(Arrays.toString(words)); // see what the data turned to

        // Iterate through the words array ->
        //   count how many times we've seen each word
        for (String word : words) {
            // take away spaces
            if(word.length() > 0){
                if(wordCountMap.containsKey(word)){
//                    if(wordCountMap.containsKey(word) && !isCommonWord(word)){
                    // if the word exit int the hashMap increment its value
                    wordCountMap.put(word, wordCountMap.get(word)+1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }

        // Iterate the wordCountMap to find out which word was repeated the most
        int max = 0;
        String mostReapeatedWord = "";
        for (String key : wordCountMap.keySet()) {
            int currentValue = wordCountMap.get(key);
            if(currentValue > max){
                mostReapeatedWord = key;
                max = currentValue;
            }
        }

        System.out.println("Most repeated word is: "+ mostReapeatedWord + "\nRepeated: "+ max + " times");
        return mostReapeatedWord;

    }


    public static void main(String[] args) {
        String data = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

       Main app = new Main();
        app.findMostRepeatedWord(data);
    }
}
