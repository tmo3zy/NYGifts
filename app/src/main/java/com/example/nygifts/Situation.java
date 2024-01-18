package com.example.nygifts;

import com.google.android.material.color.utilities.Variant;

public class Situation {
    String description;
    Variants[] answers;
    Variants chosen_variant;

    public Situation(String description){
        this.description = description;
    }

    public void choose(int index, Story story, Player player){
        story.current_situation.chosen_variant = story.current_situation.answers[index];
        story.current_character.is_bought = true;
        player.time -= story.current_situation.answers[index].cTime;
        player.money -= story.current_situation.answers[index].cMoney;
        if(story.current_character.correct_variant1 == index || story.current_character.correct_variant2 == index){
            story.current_character.is_correct = true;
            player.points ++;
        }
    }
}
