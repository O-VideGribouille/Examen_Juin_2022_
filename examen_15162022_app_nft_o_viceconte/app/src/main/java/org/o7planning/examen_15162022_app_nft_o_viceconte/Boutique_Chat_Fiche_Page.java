package org.o7planning.examen_15162022_app_nft_o_viceconte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Boutique_Chat_Fiche_Page extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boutique_chat_fiche_page);


        //Go Rtour Boutique
        btn_1 = (Button) findViewById(R.id.btn_rtr_4);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monIntent = new Intent(Boutique_Chat_Fiche_Page.this, Boutique_Page.class);
                startActivity(monIntent);
            }
        });

        //Go Achat
        btn_2 = (Button) findViewById(R.id.btn_acht);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Boutique_Chat_Fiche_Page.this, "Il n'y a rien a acheter", Toast.LENGTH_LONG).show();

            }
        });
    }
}