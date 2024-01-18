package com.example.nygifts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;


public class CharactersActivity extends AppCompatActivity {
    Button btn_mom, btn_dad, btn_sister, btn_grandma, btn_grandpa, btn_bf, btn_gf, btn_godmother;

    Story story = new Story();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        btn_mom = findViewById(R.id.btn_mom);

        class Listener_bought implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                Toast.makeText(CharactersActivity.this, "Вы уже купили этот подарок", Toast.LENGTH_LONG).show();
            }
        }

        class Listener1 implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                Story.current_situation_number = 1;
                Story.current_character_number = 0;
                Intent intent = new Intent(CharactersActivity.this, GameActivity.class);
                startActivity(intent);
            }
        }
        Listener_bought listener_bought = new Listener_bought();
        Listener1 listener1 = new Listener1();

        if (!story.characters[0].is_bought){
            btn_mom.setOnClickListener(listener1);
        }
        else{
            btn_mom.setOnClickListener(listener_bought);
        }
    }
}