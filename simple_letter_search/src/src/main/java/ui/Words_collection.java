package src.main.java.ui;

import java.util.ArrayList;
public class Words_collection {
    private ArrayList<Word> wordsList;
    private int sum_all_letters;
    private int sum_key_letters;

    public Words_collection() {
        this.wordsList = new ArrayList<>();
    }

    public void addWord(Word word){
        this.wordsList.add(word);
    }

    public ArrayList<Word> getArrayList() {
        return wordsList;
    }

    public void setArrayList(ArrayList<Word> arrayList) {
        this.wordsList = arrayList;
    }

    public int getSum_all_letters() {
        return sum_all_letters;
    }

    public void setSum_all_letters(int sum_all_letters) {
        this.sum_all_letters = sum_all_letters;
    }

    public int getSum_key_letters() {
        return sum_key_letters;
    }

    public void setSum_key_letters(int sum_key_letters) {
        this.sum_key_letters = sum_key_letters;
    }
}
