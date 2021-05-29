package src.main.java.ui;

import java.util.TreeSet;

public class Word {
    private TreeSet<String> letters;
    private Integer word_length;
    private Integer key_letter_sum;

    public Word() {
        this.key_letter_sum = 0;
        this.word_length = 0;
        this.letters = new TreeSet<>();
    }
    public void addLetterSum(){
        this.word_length++;
    }

    public void addKeySum(){
        this.key_letter_sum++;
    }

    public Integer getKey_letter_sum() {
        return key_letter_sum;
    }

    public void setKey_letter_sum(Integer key_letter_sum) {
        this.key_letter_sum = key_letter_sum;
    }

    public void addLetter(String letter){
        this.letters.add(letter);
    }

    public TreeSet<String> getLetters() {
        return letters;
    }

    public void setLetters(TreeSet<String> letters) {
        this.letters = letters;
    }

    public Integer getWord_length() {
        return word_length;
    }

    public void setWord_length(Integer word_length) {
        this.word_length = word_length;
    }
}
