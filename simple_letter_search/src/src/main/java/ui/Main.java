package src.main.java.ui;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final String TO_IGNORE = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String KEY = "LOGIC";
    public static void main(String[] args) {
	// write your code here
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        String key = KEY;
        //String key = myObj.nextLine(); za unos s tipkovnice
        compute(input, key);
    }

    private static void compute(String input, String key) {
        key = key.toLowerCase(Locale.ROOT);
        input = input.toLowerCase(Locale.ROOT);
        WordsCollection words_collection = countLettersInWord(key, input);
        words_collection.getArrayList().sort((word1,word2)->compare(word1, word2));
        ArrayList<String> all_outputs = new ArrayList<>();
        for(Word word : words_collection.getArrayList()){
            String output = "{ (";
            for(String letter : key.split("")){
                if(word.getLetters().contains(letter)){
                    output += ", "+letter;
                }
            }
            output = output.replaceFirst(", ","");
            float calculation = (float)word.getKey_letter_sum()/words_collection.getSum_key_letters();
            output += "), " + word.getWord_length() + "} = " +String.format("%.2f",calculation) +" ("+ word.getKey_letter_sum() + "/" + words_collection.getSum_key_letters()+")";
            all_outputs.add(output);
        }
        all_outputs.add("TOTAL Frequency: " + String.format("%.2f (",(float) words_collection.getSum_key_letters()/words_collection.getSum_all_letters()) + words_collection.getSum_key_letters() + "/" + words_collection.getSum_all_letters() + ")");
        for(String s : all_outputs){
            System.out.println(s);
        }
        //for returning it as array:
        //return all_outputs
    }

    private static int compare(Word word1, Word word2) {
        if(word1.getKey_letter_sum()>word2.getKey_letter_sum()){
            return 1;
        }
        else if (word1.getKey_letter_sum()<word2.getKey_letter_sum()){
            return -1;
        }
        else {
            if (word1.getWord_length()<word2.getWord_length()){
                return -1;
            }
            else if (word1.getWord_length()>word2.getWord_length()){
                return 1;
            }
            else{
                return word1.getLetters().first().compareTo(word2.getLetters().first());
            }
        }
    }

    private static WordsCollection countLettersInWord(String key, String input) {
        WordsCollection words_collection = new WordsCollection();
        int sum_all_letters = 0;
        int sum_key_letters = 0;
        for(String inputs : input.split(" ")){
            Word word = new Word();
            for(String letter : inputs.split("")){
                if(!TO_IGNORE.contains(letter)) {
                    sum_all_letters++;
                    word.addLetterSum();
                    if (key.contains(letter)) {
                        word.addLetter(letter);
                        word.addKeySum();
                        sum_key_letters++;
                    }
                }
            }
            if(word.getLetters().size()!=0)//to avoid empty
                words_collection.addWord(word);
        }
        words_collection.setSum_all_letters(sum_all_letters);
        words_collection.setSum_key_letters(sum_key_letters);
        return words_collection;
    }
}
