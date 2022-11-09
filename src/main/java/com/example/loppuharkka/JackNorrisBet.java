package com.example.loppuharkka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class JackNorrisBet extends AppCompatActivity {

    private int LatestVeto;
    private int tulos;
    private int LatestJTulos;
    private int LatestPTulos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacknorrisbet);

        if(savedInstanceState != null){
            tulos = savedInstanceState.getInt("tulos");
            LatestVeto = savedInstanceState.getInt("Veto");
            TextView Tulos = findViewById(R.id.Tulos);
            Tulos.setText( getString(R.string.jackinarvaus)+ (LatestVeto));
            //LatestJTulos = savedInstanceState.getInt("LatestJtulos");
            TextView Jtulos = findViewById(R.id.Jtulos);
            Jtulos.setText(""+(tulos));
            //LatestPTulos = savedInstanceState.getInt("LatestPtulos");
            TextView Ptulos = findViewById(R.id.Ptulos);
            Ptulos.setText("0");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("Jtulos", LatestJTulos );
        savedInstanceState.putInt("Ptulos", LatestPTulos );
        savedInstanceState.putInt("tulos", tulos );
        savedInstanceState.putInt("Veto",LatestVeto );
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
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

    public void press(View view){
        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("MAARA", tulos);
        startActivity(intent);
    }
    public void Veto(View view){
        EditText vetoNumber = findViewById(R.id.Bets);
        LatestVeto = Integer.parseInt(vetoNumber.getText().toString());
        TextView Tulos = findViewById(R.id.Tulos);
        Tulos.setText( getString(R.string.jackinarvaus)+ LatestVeto);
        Jnumero();
        TextView Ptulos = findViewById(R.id.Ptulos);
        Ptulos.setText("0");
    }



    public void Jnumero(){
        TextView Jtulos = findViewById(R.id.Jtulos);
        Jtulos.setText(""+(++tulos));
    }
}