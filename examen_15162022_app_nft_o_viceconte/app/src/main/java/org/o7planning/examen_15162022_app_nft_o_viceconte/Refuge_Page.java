package org.o7planning.examen_15162022_app_nft_o_viceconte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Refuge_Page extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuge_page);


        //Go Rtour Game Page
        btn_1 = (Button) findViewById(R.id.btn_rtr_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Refuge_Page.this, Game_Page.class);
                startActivity(monIntent);
            }
        });

        //Go Go Visu Chat
        btn_2 = (Button) findViewById(R.id.btn_temp_fiche_chat);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Refuge_Page.this, Refuge_Cat_Fiche_Page.class);
                startActivity(monIntent);
            }
        });
    }
}