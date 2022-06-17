package org.o7planning.examen_15162022_app_nft_o_viceconte;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.BaseColumns;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.o7planning.examen_15162022_app_nft_o_viceconte.bean.MyDatabaseHelper;
import org.o7planning.examen_15162022_app_nft_o_viceconte.bean.User;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link firstfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class firstfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public firstfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment firstfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static firstfragment newInstance(String param1, String param2) {
        firstfragment fragment = new firstfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstfragment, container, false);
    }


    /////////////////////////////////////////////////////////////////////
    //MyDatabaseHelper dtbsHlp = new MyDatabaseHelper(this.getContext());
    //MyDatabaseHelper db3 = MainActivity.db;
   //   MyDatabaseHelper db3 = new MyDatabaseHelper(this.getActivity());
    //Reconnaissance Pseudo
    EditText edt_Psd;
    EditText edt_Mp;

    NavController nvctllr;
    Button btn_1;

    //utilisée dans la fonction, puis pour la récupération Valid_From
    String str_User_Name;
    String str_User_Mp;

    //boolean edttxt_empty_h;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity act = (MainActivity)this.getActivity();
        //this.getActivity();

        //récupération texte saisie
       /* edt_Psd.addTextChangedListener(nextStep);
        edt_Mp.addTextChangedListener(nextStep);*/


        //////Récupérer les donées
       // List<User> listuser =  db3.getAllUsers();
        //listuser.get(0);


        //NAVIGATION PAGE 1 à 2
        /*nvctllr = Navigation.findNavController(view);
        btn_1 = (Button) btn_1.findViewById(R.id.btn_val);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //récupération texte saisie
                str_User_Name = edt_Psd.getText().toString();
                str_User_Mp = edt_Mp.getText().toString();

                for (int n_i = 0; n_i < listuser.size(); n_i++ ){

                    if (str_User_Name == "Egerie"){

                        Toast.makeText(getContext(), "Bienvenue !", Toast.LENGTH_LONG).show();
                        nvctllr.navigate(R.id.action_firstfragment_to_secondfragment);

                    } else {
                        Toast.makeText(getContext(), "Erreur, ce compte n'existe pas.", Toast.LENGTH_LONG).show();
                    }


                }


            }
        });*/

        nvctllr.navigate(R.id.action_firstfragment_to_secondfragment);


    }




}