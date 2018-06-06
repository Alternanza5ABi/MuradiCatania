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
                    R.drawable.bastione_degli_infetti,
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,//bastione san giovanni, bastione santa croce
                    R.drawable.bastione_del_tindaro, R.drawable.bastione_del_santo_carcere,
                    R.drawable.porta_lapide_carlo_v, R.drawable.porta_decima,
                    R.drawable.ic_launcher_foreground, //porta saracena
                    R.drawable.porta_porticello_foto,
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, //porta di ferro, porta del re
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, //porta del tindaro, porta sant'orsola,
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,// porta del sale, porta della consolazione,
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,//porta di sardo, porta della lanza,
                    R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,// postierle, fontana dei sette canali
                    R.drawable.fonte_lanaria, R.drawable.biscari_angolo, R.drawable.biscari_stili_diversi,
                    R.drawable.ursino_con_mura, R.drawable.scala_gammazita
                };

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
