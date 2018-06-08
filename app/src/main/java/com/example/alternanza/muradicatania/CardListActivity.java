package com.example.alternanza.muradicatania;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardListActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this) );

        List<Monument> monumentList= new ArrayList<>();

        int numMonument = 26;

        int img_array[] =
                {
                    R.drawable.ruderi_bastione_san_giorgio, R.drawable.bastione_san_michele_palazzo_manganelli,
                    R.drawable.bastione_degli_infetti_25, R.drawable.bastione_san_giovanni, R.drawable.bastione_santa_croce,
                    R.drawable.bastionedeltindaro, R.drawable.bastione_del_santocarcere, R.drawable.porta_carlo,
                    R.drawable.porta_decima, R.drawable.porta_saracena, R.drawable.porta_porticello,
                    R.drawable.porta_di_ferro, R.drawable.porta_del_re, R.drawable.ic_launcher_foreground, //Porta del tindaro manca
                    R.drawable.porta_sant_orsola, R.drawable.porta_del_sale, R.drawable.porta_della_consolazione,
                    R.drawable.porta_di_sardo, R.drawable.porta_della_lanza, R.drawable.postierla,
                    R.drawable.fontana_dei_sette_canali, R.drawable.fonte_lanaria, R.drawable.mura_cinquecentesche_del_palazzo_biscari,
                    R.drawable.palazzo_biscari, R.drawable.ursino_con_mura, R.drawable.scala_gammazita
                };

        /*
        //SOLO PER TESTARE IN ATTESA CHE VENGA RIEMPITA L'APP CON LE IMMAGINI
        //DA RIMUOVERE UNA VOLTA CARICATE TUTTE LE IMMAGINI E AVER SISTEMATO L'img_array SUPERIORE
        int img_array[]= new int[numMonument];

        for(int i=0; i<numMonument; i++)
        {
            img_array[i] = R.drawable.ic_launcher_foreground;
        }
        */
        String name[] = getResources().getStringArray(R.array.name);
        String desc[] = getResources().getStringArray(R.array.descriptions);
        String latd[] = getResources().getStringArray(R.array.Latitude);
        String lond[] = getResources().getStringArray(R.array.Longitude);

        for(int i=0; i<numMonument; i++)
        {
            monumentList.add( new Monument(name[i], desc[i], latd[i], lond[i], img_array[i])  );
        }

        MonumentAdapter adapter = new MonumentAdapter(this, monumentList);

        recyclerView.setAdapter(adapter);

    }
}
