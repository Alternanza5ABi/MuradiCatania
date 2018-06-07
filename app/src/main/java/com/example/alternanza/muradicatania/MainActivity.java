package com.example.alternanza.muradicatania;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton ib_monuments = findViewById(R.id.ib_home_monuments);
        ImageButton ib_map = findViewById(R.id.ib_home_map);

        ib_monuments.setOnClickListener(this);
        ib_map.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Intent intent;

        if( v.getId() == R.id.ib_home_monuments )
        {
            intent= new Intent(this, CardListActivity.class);
            startActivity(intent);
        }
        else
        {
            intent= new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
    }
}
