package com.example.guerradepulsaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import android.os.*;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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
    protected int iFAzul;
    protected int iFRojo;
    protected int nPulsaciones;
    protected String SnPulsaciones;
    protected EditText etnPulsaciones;
    protected TextView tvNpulsaciones;
    protected TextView txCuentaAtras;
    protected Switch cambioModo;
    protected Guideline lineaMedia;
    protected TextView barraAzul;
    protected TextView barraRoja;
    protected TextView objetivo;


public void cambiarmodo(){

    if(cambioModo.isChecked()){

        puntuacionRojo.setVisibility(View.GONE);
        puntuacionAzul.setVisibility(View.GONE);
        etnPulsaciones.setVisibility(View.GONE);
        tvNpulsaciones.setVisibility(View.GONE);
        barraRoja.setVisibility(View.VISIBLE);
        barraAzul.setVisibility(View.VISIBLE);

    }else{
        puntuacionRojo.setVisibility(View.VISIBLE);
        puntuacionAzul.setVisibility(View.VISIBLE);
        etnPulsaciones.setVisibility(View.VISIBLE);
        tvNpulsaciones.setVisibility(View.VISIBLE);
        barraRoja.setVisibility(View.GONE);
        barraAzul.setVisibility(View.GONE);
    }
}


    public void cuentaAtras(){



        botonEmpezar.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                txCuentaAtras.setText("3");

            }
        }, 500);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                txCuentaAtras.setText("2");

            }
        }, 1500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                txCuentaAtras.setText("1");

            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                txCuentaAtras.setText("¡YA!");

            }
        }, 3500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                txCuentaAtras.setText("");
                botonEmpezar.setVisibility(View.VISIBLE);
                botonEmpezar.setText("Parar");
                botonEmpezar.setBackgroundColor(Color.argb(255,255,0,0));
                estado=1;
            }
        }, 3650);



    }

    public void actualizaMensaje (){

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) lineaMedia.getLayoutParams();



            if (iAzul < iRojo ||params.guidePercent<0.5 ) {
                comentarios.setTextColor(Color.argb(255, 255, 0, 0));
                comentarios.setText("va ganando Rojo");


            } else if (iAzul > iRojo||params.guidePercent>0.5) {
                comentarios.setTextColor(Color.argb(255, 0, 0, 255));
                comentarios.setText("va ganando Azul");

            } else {
                comentarios.setText("EMPATE");
                comentarios.setTextColor(Color.BLACK);

            }

        if(cambioModo.isChecked()){



            if(params.guidePercent >= 0.69f){

                comentarios.setText("Ganador\n Azul");
                botonEmpezar.setText("Reiniciar");
                botonEmpezar.setBackgroundColor(Color.argb(255, 0, 214, 87));
                comentarios.setTextColor(Color.argb(255, 0, 0, 255));
                comentarios.setTextSize(50);
                cambioModo.setVisibility(View.VISIBLE);
                estado = 0;

            }
            if(params.guidePercent <= 0.31f){

                comentarios.setText("Ganador\n Rojo");
                botonEmpezar.setText("Reiniciar");
                botonEmpezar.setBackgroundColor(Color.argb(255, 0, 214, 87));
                comentarios.setTextColor(Color.argb(255, 255, 0, 0));
                comentarios.setTextSize(50);
                cambioModo.setVisibility(View.VISIBLE);
                estado = 0;

            }



        }else {

            if (iAzul == nPulsaciones) {
                comentarios.setText("Ganador\n Azul");
                etnPulsaciones.setVisibility(View.VISIBLE);
                tvNpulsaciones.setVisibility(View.VISIBLE);
                botonEmpezar.setText("Reiniciar");
                botonEmpezar.setBackgroundColor(Color.argb(255, 0, 214, 87));
                comentarios.setTextColor(Color.argb(255, 0, 0, 255));
                comentarios.setTextSize(50);
                cambioModo.setVisibility(View.VISIBLE);
                estado = 0;
                objetivo.setVisibility(View.GONE);

            }

            if (iRojo == nPulsaciones) {
                comentarios.setText("Ganador\n Rojo");
                etnPulsaciones.setVisibility(View.VISIBLE);
                tvNpulsaciones.setVisibility(View.VISIBLE);
                botonEmpezar.setText("Reiniciar");
                botonEmpezar.setBackgroundColor(Color.argb(255, 0, 214, 87));
                comentarios.setTextColor(Color.argb(255, 255, 0, 0));
                comentarios.setTextSize(50);
                cambioModo.setVisibility(View.VISIBLE);
                estado = 0;
                objetivo.setVisibility(View.GONE);

            }
        }


    }

    public void clickAzul (){

        if(estado==1) {


            if(cambioModo.isChecked()){


                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) lineaMedia.getLayoutParams();
                params.guidePercent += 0.01f;
                lineaMedia.setLayoutParams(params);
                actualizaMensaje();


            }else {


                iAzul++;

                puntuacionAzul.setText(Integer.toString(iAzul));
                actualizaMensaje();
            }
        }

    }

    public void clickRojo (){


        if(estado==1) {

            if(cambioModo.isChecked()){


                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) lineaMedia.getLayoutParams();
                params.guidePercent -= 0.01f;
                lineaMedia.setLayoutParams(params);
                actualizaMensaje();


            }else {


                iRojo++;

                puntuacionRojo.setText(Integer.toString(iRojo));
                actualizaMensaje();
            }
        }

    }

    public void clickReset () {


        if (estado == 1) {



            objetivo.setVisibility(View.GONE);

            if (cambioModo.isChecked()) {
                //
            } else {
                etnPulsaciones.setVisibility(View.VISIBLE);
                tvNpulsaciones.setVisibility(View.VISIBLE);
            }



            cambioModo.setVisibility(View.VISIBLE);
            botonEmpezar.setText("Empezar");
            botonEmpezar.setBackgroundColor(Color.argb(255, 0, 214, 87));
            comentarios.setText("");
            comentarios.setTextColor(Color.BLACK);
            comentarios.setTextSize(25);
            iAzul = 0;
            iRojo = 0;
            iFAzul = 0;
            iFRojo = 0;
            puntuacionAzul.setText(Integer.toString(iAzul));
            puntuacionRojo.setText(Integer.toString(iRojo));
            estado = 0;
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) lineaMedia.getLayoutParams();
            params.guidePercent = 0.50f;
            lineaMedia.setLayoutParams(params);


        } else if (estado == 0) {

            iAzul = 0;
            iRojo = 0;
            iFAzul = 0;
            iFRojo = 0;
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) lineaMedia.getLayoutParams();
            params.guidePercent = 0.50f;
            lineaMedia.setLayoutParams(params);


            cuentaAtras();


            SnPulsaciones = etnPulsaciones.getText().toString();
            if (SnPulsaciones.length() > 0) {
                nPulsaciones = Integer.parseInt(SnPulsaciones);
                if (nPulsaciones <= 0) {
                    nPulsaciones = 20;
                }
            } else {
                nPulsaciones = 20;
            }

            etnPulsaciones.setText(Integer.toString(nPulsaciones));


            puntuacionAzul.setText(Integer.toString(iAzul));
            puntuacionRojo.setText(Integer.toString(iRojo));
            comentarios.setText("");
            comentarios.setTextColor(Color.BLACK);
            comentarios.setTextSize(25);
            txCuentaAtras.setText("");
            objetivo.setVisibility(View.VISIBLE);
            etnPulsaciones.setVisibility(View.GONE);
            tvNpulsaciones.setVisibility(View.GONE);
            cambioModo.setVisibility(View.GONE);



        if (cambioModo.isChecked()) {

            puntuacionRojo.setVisibility(View.GONE);
            puntuacionAzul.setVisibility(View.GONE);
            barraRoja.setVisibility(View.VISIBLE);
            barraAzul.setVisibility(View.VISIBLE);
            objetivo.setVisibility(View.GONE);

        } else {
            puntuacionRojo.setVisibility(View.VISIBLE);
            puntuacionAzul.setVisibility(View.VISIBLE);
            barraRoja.setVisibility(View.GONE);
            barraAzul.setVisibility(View.GONE);
            objetivo.setVisibility(View.VISIBLE);
            objetivo.setText("objetivo: " + etnPulsaciones.getText().toString());
        }

    }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        estado=0;
        iRojo=0;
        iAzul=0;
        iFAzul=0;
        iFRojo=0;

        puntuacionAzul = findViewById(R.id.marcAzul);
        puntuacionRojo = findViewById(R.id.marcRojo);
        comentarios = findViewById(R.id.comentarios);
        botonRojo = findViewById(R.id.btRojo);
        botonAzul = findViewById(R.id.btAzul);
        botonEmpezar = findViewById(R.id.btEmpezar);
        etnPulsaciones = findViewById(R.id.etnPulsaciones);
        tvNpulsaciones = findViewById(R.id.npulsaciones);
        txCuentaAtras = findViewById(R.id.tx_cuentaAtras);
        lineaMedia = findViewById(R.id.guiaModo2);
        cambioModo  = findViewById(R.id.swCambioModo);
        barraAzul = findViewById(R.id.Barra_Azul);
        barraRoja = findViewById(R.id.Barra_Roja);
        objetivo =findViewById(R.id.tvObjeivo);



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

        cambioModo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarmodo();
            }
        });


    }
}