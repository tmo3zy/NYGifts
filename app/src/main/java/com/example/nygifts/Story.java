package com.example.nygifts;

public class Story {
    Situation current_situation;
    Situation[] situations;
    Variants[] chosen_variants;
    Character[] characters;
    Character current_character;
    static int current_situation_number = 0;
    static int current_character_number;



    public Story(){
        Situation start = new Situation("30 декабря. Вы просыпаетесь в 11 часов дня и понимаете, что забыли купить подарки на Новый Год... " +
                "Вы оценили свой бюджет и имеющееся время. Ваша задача - уложиться по времени и деньгам в покупку подарков.");
        Variants next = new Variants("Далее","Далее", 0, 0);
        start.answers = new Variants[]{next};

        Character mom, dad, sister, grandma, grandpa, bf, gf, godmother;

        mom = new Character(0, 2);
        dad = new Character(1, 3);
        sister = new Character(1, 2);
        grandma = new Character(2, 3);
        grandpa = new Character(0, 1);
        bf = new Character(0, 3);
        gf = new Character(0, 2);
        godmother = new Character(1, 2);

        Situation mom_gift = new Situation("Ваша мама любит ухаживать за собой. Она часто ходит в салоны красоты и занимается спортом. Что вы выберете?");
        Variants mom_variant1 = new Variants("Духи (-15 мин, +2000руб.)", "Купить духи (15 мин, 2000руб.)", 2000, 30);
        Variants mom_variant2 = new Variants("Конфеты (-10 мин, +250 руб.)","Купить коробку конфет (10 мин, 250руб.", 250, 10);
        Variants mom_variant3 = new Variants("Спортивная бутылка (-40мин, +500руб.)","Купить новую спортивную бутылку (40 мин, 500руб.)", 500, 40);
        Variants mom_variant4 = new Variants("Набор для вышивания (-20 мин. +400руб.)","Купить набор для вышивания (20 мин, 400руб.)", 400, 25);
        mom_gift.answers = new Variants[]{mom_variant1, mom_variant2, mom_variant3, mom_variant4};

        Situation mom_gift_bought = new Situation("Вы успешно купили подарок для мамы");
        mom_gift_bought.answers = new Variants[]{next};

        this.characters = new Character[]{mom, dad, sister, grandma, grandpa, bf, gf, godmother};
        this.current_character = characters[current_character_number];
        this.situations = new Situation[]{start, mom_gift, mom_gift_bought};
        this.current_situation = situations[current_situation_number];
        this.chosen_variants = new Variants[]{mom_gift.chosen_variant};
    }
}
