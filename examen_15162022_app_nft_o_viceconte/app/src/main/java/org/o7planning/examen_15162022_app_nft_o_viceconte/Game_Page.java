package org.o7planning.examen_15162022_app_nft_o_viceconte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game_Page extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        //Go Refuge
        btn_1 = (Button) findViewById(R.id.btn_rfg);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Game_Page.this, Refuge_Page.class);
                startActivity(monIntent);

            }
        });

        //Go Boutique
        btn_2 = (Button) findViewById(R.id.btn_btqu);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Game_Page.this, Boutique_Page.class);
                startActivity(monIntent);

            }
        });
    }
}