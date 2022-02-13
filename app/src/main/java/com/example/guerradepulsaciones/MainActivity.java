package com.example.guerradepulsaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected TextView puntuacionAzul;
    protected TextView puntuacionRojo;
    protected TextView comentarios;
    protected Button botonRojo;
    protected Button botonAzul;
    protected Button botonEmpezar;
    protected int estado;
    protected int iAzul;
    protected int iRojo;
    protected int nPulsaciones;
    protected String SnPulsaciones;
    protected EditText etnPulsaciones;
    protected   TextView tvNpulsaciones;
    protected TextView txCuentaAtras;



    public void actualizaMensaje (){
        if(iAzul<iRojo) {
            comentarios.setTextColor(Color.argb(255,255,0,0));
            comentarios.setText("va ganando Rojo");



        }else if(iAzul>iRojo) {
            comentarios.setTextColor(Color.argb(255,0,0,255));
            comentarios.setText("va ganando Azul");

        }else {
            comentarios.setText("EMPATE");
            comentarios.setTextColor(Color.BLACK);

        }

        if(iAzul==nPulsaciones){
            comentarios.setText("Ganador\n Azul");
            etnPulsaciones.setVisibility(View.VISIBLE);
            tvNpulsaciones.setVisibility(View.VISIBLE);
            botonEmpezar.setText("Reiniciar");
            botonEmpezar.setBackgroundColor(Color.argb(255,0,214,87));
            comentarios.setTextColor(Color.argb(255,0,0,255));
            comentarios.setTextSize(60);
            estado=0;

        }

        if(iRojo==nPulsaciones){
            comentarios.setText("Ganador\n Rojo");
            etnPulsaciones.setVisibility(View.VISIBLE);
            tvNpulsaciones.setVisibility(View.VISIBLE);
            botonEmpezar.setText("Reiniciar");
            botonEmpezar.setBackgroundColor(Color.argb(255,0,214,87));
            comentarios.setTextColor(Color.argb(255,255,0,0));
            comentarios.setTextSize(60);
            estado=0;

        }


    }


    public void clickAzul (){
        if(estado==1) {
            iAzul++;
            puntuacionAzul.setText(Integer.toString(iAzul));
            actualizaMensaje();
        }

    }
    public void clickRojo (){
        if(estado==1) {
            iRojo++;
            puntuacionRojo.setText(Integer.toString(iRojo));
            actualizaMensaje();
        }

    }
    public void clickReset (){

        if(estado==1) {
            etnPulsaciones.setVisibility(View.VISIBLE);
            tvNpulsaciones.setVisibility(View.VISIBLE);
            botonEmpezar.setText("Empezar");
            botonEmpezar.setBackgroundColor(Color.argb(255,0,214,87));
            comentarios.setText("");
            comentarios.setTextColor(Color.BLACK);
            comentarios.setTextSize(25);
            iAzul=0;
            iRojo=0;
            puntuacionAzul.setText(Integer.toString(iAzul));
            puntuacionRojo.setText(Integer.toString(iRojo));
            estado=0;
        }
        else if(estado==0) {

            etnPulsaciones.setVisibility(View.GONE);
            tvNpulsaciones.setVisibility(View.GONE);

            txCuentaAtras.setText("3");

            txCuentaAtras.setText("2");

            txCuentaAtras.setText("1");

            txCuentaAtras.setText("YA");

            SnPulsaciones= etnPulsaciones.getText().toString();
            if(SnPulsaciones.length()>0) {
                nPulsaciones = Integer.parseInt(SnPulsaciones);
                if (nPulsaciones <= 0) {
                    nPulsaciones = 20;
                }
            }else{
                nPulsaciones = 20;
            }
            etnPulsaciones.setText(Integer.toString(nPulsaciones));

            iAzul=0;
            iRojo=0;
            puntuacionAzul.setText(Integer.toString(iAzul));
            puntuacionRojo.setText(Integer.toString(iRojo));
            comentarios.setText("");
            comentarios.setTextColor(Color.BLACK);
            comentarios.setTextSize(25);
            botonEmpezar.setText("Parar");
            botonEmpezar.setBackgroundColor(Color.argb(255,255,0,0));
            estado=1;
            txCuentaAtras.setText("");
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        estado=0;

        puntuacionAzul = findViewById(R.id.marcAzul);
        puntuacionRojo = findViewById(R.id.marcRojo);
        comentarios = findViewById(R.id.comentarios);
        botonRojo = findViewById(R.id.btRojo);
        botonAzul = findViewById(R.id.btAzul);
        botonEmpezar = findViewById(R.id.btEmpezar);
        etnPulsaciones = findViewById(R.id.etnPulsaciones);
        tvNpulsaciones = findViewById(R.id.npulsaciones);
        txCuentaAtras = findViewById(R.id.tx_cuentaAtras);
       botonEmpezar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            clickReset();
           }
       });



        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clickRojo();
            }
        });


        botonAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clickAzul();
            }
        });




    }
}