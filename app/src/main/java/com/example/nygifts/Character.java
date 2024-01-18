package com.example.nygifts;

public class Character {
    int correct_variant1, correct_variant2;
    boolean is_bought = false;
    boolean is_correct;

    public Character(int correct_variant1, int correct_variant2){
        this.correct_variant1 = correct_variant1;
        this.correct_variant2 = correct_variant2;
    }
}
