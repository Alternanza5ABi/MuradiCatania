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
