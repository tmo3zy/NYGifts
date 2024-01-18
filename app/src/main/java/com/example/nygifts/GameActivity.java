package com.example.nygifts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    Button v1, v2, v3, v4;
    TextView situation, time, money;
    Player player = new Player();

    Story story = new Story();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        v1 = findViewById(R.id.btn_v1);
        v2 = findViewById(R.id.btn_v2);
        v3 = findViewById(R.id.btn_v3);
        v4 = findViewById(R.id.btn_v4);
        situation = findViewById(R.id.tv_situation);
        time = findViewById(R.id.tv_time);
        money = findViewById(R.id.tv_money);



        String text = (1320 - player.time) / 60 + ":" + (1320 - player.time) % 60;

        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.INVISIBLE);
        v4.setVisibility(View.INVISIBLE);

        situation.setText(story.current_situation.description);
        money.setText(String.valueOf(player.money));
        time.setText(text);

        v1.setText(story.current_situation.answers[0].text);

        class Listener implements View.OnClickListener{
            @Override
            public void onClick(View v) {
                situation.setText(story.current_situation.description);
                v1.setText(story.current_situation.answers[0].text);
                Intent intent = new Intent(GameActivity.this, CharactersActivity.class);
                startActivity(intent);
            }
        }


        class ChooseListener implements View.OnClickListener{
            int btn_num;

            public ChooseListener(int btn_num){
                this.btn_num = btn_num;
            }

            @Override
            public void onClick(View v) {
                if(player.money >= story.current_situation.answers[btn_num].cMoney && player.time >= story.current_situation.answers[btn_num].cTime){
                    story.current_situation.choose(btn_num, story, player);
                    Toast.makeText(GameActivity.this, "Подарок успешно куплен", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GameActivity.this, CharactersActivity.class);
                    startActivity(intent);
                    time.setText(text);
                    money.setText(String.valueOf(player.money));
                }
                else{
                    Toast.makeText(GameActivity.this, "Вы не можете купить этот подарок", Toast.LENGTH_SHORT).show();
                }
            }
        }


        Listener listener = new Listener();
        ChooseListener listener1 = new ChooseListener(0);
        ChooseListener listener2 = new ChooseListener(1);
        ChooseListener listener3 = new ChooseListener(2);
        ChooseListener listener4 = new ChooseListener(3);

        if (Story.current_situation_number == 0){
            v2.setVisibility(View.INVISIBLE);
            v3.setVisibility(View.INVISIBLE);
            v4.setVisibility(View.INVISIBLE);
            v1.setOnClickListener(listener);
        }
        else{
            v2.setVisibility(View.VISIBLE);
            v3.setVisibility(View.VISIBLE);
            v4.setVisibility(View.VISIBLE);
            v2.setText(story.current_situation.answers[1].text);
            v3.setText(story.current_situation.answers[2].text);
            v4.setText(story.current_situation.answers[3].text);
            v1.setOnClickListener(listener1);
            v2.setOnClickListener(listener2);
            v3.setOnClickListener(listener3);
            v4.setOnClickListener(listener4);
        }
    }
}