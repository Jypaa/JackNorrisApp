package com.example.loppuharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        if(getIntent().getIntExtra("MAARA", 0) != 0){
            int mMaara =getIntent().getIntExtra("MAARA",0);
            TextView arvaukset = findViewById(R.id.Jackinarvaukset);
            arvaukset.setText(getString(R.string.mainarvausket) + mMaara);
        }
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


    public void Vitsi(View view){

        Button Vitsi = findViewById(R.id.Vitsi);
        Intent intent = new Intent(this, JackNorrisJokes.class);
        startActivity(intent);

    }
    public void Veto(View view){

        Button Veto = findViewById(R.id.Veto);
        Intent intent = new Intent(this, JackNorrisBet.class);
        startActivity(intent);

    }
}