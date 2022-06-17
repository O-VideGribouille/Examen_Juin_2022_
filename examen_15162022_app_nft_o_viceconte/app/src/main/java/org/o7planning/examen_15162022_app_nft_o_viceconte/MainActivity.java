package org.o7planning.examen_15162022_app_nft_o_viceconte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.o7planning.examen_15162022_app_nft_o_viceconte.bean.MyDatabaseHelper;
import org.o7planning.examen_15162022_app_nft_o_viceconte.bean.NFT_Cat;
import org.o7planning.examen_15162022_app_nft_o_viceconte.bean.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import  java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    public static MyDatabaseHelper db;

    private ListView listV;
   /* private static final int MENU_ITEM_VIEW = 111;
    private static final int MENU_ITEM_EDIT = 222;
    private static final int MENU_ITEM_CREATE = 333;
    private static final int MENU_ITEM_DELETE = 444;*/

    private static final int MY_REQUEST_CODE = 1000;

    private final List<User> userList = new ArrayList<User>();
    private ArrayAdapter<User> listViewAdapterU;

    private final List<NFT_Cat> catList = new ArrayList<NFT_Cat>();
    private ArrayAdapter<NFT_Cat> listViewAdapterC;


    ///Récupération User Name et MP
    //Reconnaissance Pseudo
    EditText edt_Psd;
    EditText edt_Mp;

    NavController nvctllr;
    Button btn_1;

    //utilisée dans la fonction, puis pour la récupération Valid_From
    String str_User_Name;
    String str_User_Mp;

    //boolean edttxt_empty_h;
    /////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //concerne le splash screen,
        //permet de retourner sur le thème principale de notre layout
        setTheme(R.style.thm_secondaire);

        //concerne le layout sur lequelle nous travaillons
        setContentView(R.layout.activity_main);

        //Appel web service CoinGecko
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                //.penaltyDeath()
                .build());
    //Concerne web service CoinGecko
        double cout_eur = 0;
        double cout_btc =0;
        try {
            URL url = new URL("https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=eur%2Cbtc%2Cusd%2Cxlm");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Log.i("mec", "je suis avant");
            conn.getResponseCode();
            if(conn.getResponseCode() == HttpsURLConnection.HTTP_OK){
                Log.i("Hey", "Mec cool");
                InputStream inputStream = null;
                try {
                    inputStream = conn.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // ...que l'on transforme ici en String par simplicité d'usage (note :
                // il peut s'agit d'autre chose qu'un String pour
                // d'autres webservices, comme des images)
                String data = readStringData(inputStream);

                Log.i("Request", data);

                JSONObject js = new JSONObject(data);
                cout_eur = Double.parseDouble(js.getJSONObject("ethereum").getString("eur"));
                cout_btc = Double.parseDouble(js.getJSONObject("ethereum").getString("btc"));

                Log.i("cc", js.getJSONObject("ethereum").getString("btc"));
            }
            else {
                Log.i("Hey", "Perdu...");
                String response = "FAILED"; // See documentation for more info on response handling
            }

        } catch (IOException | JSONException e) {
            //TODO Handle problems..
        }


        //Concerne les listes User et NFT_Cat
        //Obtenir objet ListView par xml
        //this.listV=(ListView) findViewById(R.id.listView);

        db = new MyDatabaseHelper(this);
        SQLiteDatabase db2 = db.getReadableDatabase();
        db.onUpgrade(db2, 0, 1);
        //Log.i("Nb user", Integer.toString(db.getUsersCount()));
        db.createDefaultUserIfNeed();
        //User temp = new User(1,"paul","aaa",4);
        //db.addUser(temp);
        //BDD Cat
        Log.i("Val", String.valueOf(db.getCatsCount()));
        if(db.getCatsCount() == 0){
            double val_eur = 0;
            double val_eth = 0;
            double val_btc = 0;

            //Cat 1
            val_eth = 0.001;
            val_eur = val_eth* cout_eur;
            val_btc =val_eth* cout_btc;

            NFT_Cat cat1 = new NFT_Cat("Botté", val_eur, val_eth,val_btc, 1, 1, false);
            Log.i("Valeur ETH : ", String.valueOf(val_eth));
            Log.i("Valeur EUR : ", String.valueOf(val_eur));
            Log.i("Valeur BTC : ", String.valueOf(val_btc));


            //Cat 2
            val_eth = 0.005;
            val_eur = val_eth* cout_eur;
            val_btc =val_eth* cout_btc;

            NFT_Cat cat2 = new NFT_Cat("Rominagrobis", val_eur, val_eth,val_btc, 2, 1, false);

            //Cat 3
            val_eth = 0.009;
            val_eur = val_eth* cout_eur;
            val_btc =val_eth* cout_btc;

            NFT_Cat cat3 = new NFT_Cat("Saha", val_eur, val_eth,val_btc, 3, 1, false);

            //Cat 4
            val_eth = 0.1;
            val_eur = val_eth* cout_eur;
            val_btc =val_eth* cout_btc;

            NFT_Cat cat4 = new NFT_Cat("Arsene", val_eur, val_eth,val_btc, 4, 4, false);

            //Cat 5
            val_eth = 0.3;
            val_eur = val_eth* cout_eur;
            val_btc =val_eth* cout_btc;

            NFT_Cat cat5 = new NFT_Cat("Dina", val_eur, val_eth,val_btc, 5, 5, false);
            db.addCat(cat1);
            db.addCat(cat2);
            db.addCat(cat3);
            db.addCat(cat4);
            db.addCat(cat5);
        }

        List<User> listU = db.getAllUsers();
        List<NFT_Cat> listC = db.getAllCats();

        //Definir un nouvel Adapter
        //1 - COntexte
        //2 - Layout de la ligne
        //3 - ID du TextView où la donné est écrit
        //4 - la list de donnée

        //USER
        //this.listViewAdapterU = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.userList);

        //Assigné l'adapter à ListView // USER
        //this.listV.setAdapter(this.listViewAdapterU);

        // ... // USER
        //registerForContextMenu(this.listV);

       // this.listViewAdapterU = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.userList);

        //PARTIE CONNECTION USER

        //////Récupérer les donées
        List<User> listuser = db.getAllUsers();
        //listuser.get(0);


        //NAVIGATION PAGE 1 à 2
        btn_1 = (Button) findViewById(R.id.btn_val);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //récupération texte saisie
                edt_Psd = (EditText) findViewById(R.id.edttxt_Pseudo);
                edt_Mp = (EditText) findViewById(R.id.edttxt_Mp);
                str_User_Name = edt_Psd.getText().toString();
                str_User_Mp = edt_Mp.getText().toString();

                for(int n_i = 0; n_i < listuser.size(); n_i++) {
                    //if (str_User_Name.equals(listuser.toString())) {
                    if (str_User_Name.equals(listuser.get(n_i).getUserName())) {
                        if (str_User_Mp.equals(listuser.get(n_i).getUserMP())) {
                            //if (str_User_Name.equals("Egerie")) {

                            Toast.makeText(MainActivity.this, "Bienvenue !", Toast.LENGTH_LONG).show();
                            Intent monIntent = new Intent(MainActivity.this, Game_Page.class);
                            startActivity(monIntent);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Erreur : Le nom ou le mot de passe est incorrect.", Toast.LENGTH_SHORT).show();


                    }
                }



            }
        });



    }
//////////////////////////////////////
    // Concerne web service CoinGecko
    private String readStringData(InputStream stream)  {
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
            //return null;

        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "not working", e);

        } finally {
            // On ferme tout les flux dans tout les cas
            if(reader != null){
                try {
                    reader.close();

                } catch (IOException exp2) {
                    Log.e(getClass().getSimpleName(), "not working again", exp2);
                }
            }
        }
        return null;
    }
    ///
    // Concerne les listes User



}