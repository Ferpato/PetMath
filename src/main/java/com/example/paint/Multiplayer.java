package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Multiplayer extends AppCompatActivity {
    TextView Operacionp1,Operacionp2,num1p1,num2p1,num1p2,num2p2;
    ProgressBar BarraJuego;
    Dialog Victoria;
ImageView Img1p1,Img2p1,Img3p1,Img4p1,Img1p2,Img2p2,Img3p2,Img4p2,casitas;
Button op1p1,op2p1,op3p1,op4p1,op1p2,op2p2,op3p2,op4p2;
int jugador,Vp1=1,Vp2=1;
boolean op1p1V,op2p1V,op3p1V,op4p1V,op1p2V,op2p2V,op3p2V,op4p2V;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Victoria = new Dialog(this);
        setContentView(R.layout.activity_multiplayer);


        casitas = findViewById(R.id.casita);
        casitas.setClickable(true);
        casitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intencion);
            }
        });

        SharedPreferences plays= getSharedPreferences("plays", Context.MODE_PRIVATE);
        BarraJuego = findViewById(R.id.BarraJuego);
        BarraJuego.setProgress( plays.getInt("plays",100));

        Operacionp1 = findViewById(R.id.operacionp1);
        Operacionp2 = findViewById(R.id.operacionp2);
        num1p1=findViewById(R.id.num1p1);
        num2p1=findViewById(R.id.num2p1);
        num1p2=findViewById(R.id.num1p2);
        num2p2=findViewById(R.id.num2p2);

        Img1p1=findViewById(R.id.img1p1);
        Img2p1=findViewById(R.id.img2p1);
        Img3p1=findViewById(R.id.img3p1);
        Img4p1=findViewById(R.id.img4p1);

        Img1p2=findViewById(R.id.img1p2);
        Img2p2=findViewById(R.id.img2p2);
        Img3p2=findViewById(R.id.img3p2);
        Img4p2=findViewById(R.id.img4p2);

        op1p1=findViewById(R.id.op1p1);
        op2p1=findViewById(R.id.op2p1);
        op3p1=findViewById(R.id.op3p1);
        op4p1=findViewById(R.id.op4p1);
        op1p2=findViewById(R.id.op1p2);
        op2p2=findViewById(R.id.op2p2);
        op3p2=findViewById(R.id.op3p2);
        op4p2=findViewById(R.id.op4p2);


        SharedPreferences MascotaElegida = getSharedPreferences("mascota", Context.MODE_PRIVATE);
        switch(MascotaElegida.getString("mascota","Poro")){
            case "Poro":
                Img1p1.setImageResource(R.drawable.poro);
                Img2p1.setImageResource(R.drawable.poro);
                Img3p1.setImageResource(R.drawable.poro);
                Img4p1.setImageResource(R.drawable.poro);


                break;
            case "Slime":
                Img1p1.setImageResource(R.drawable.slimehydro);
                Img2p1.setImageResource(R.drawable.slimehydro);
                Img3p1.setImageResource(R.drawable.slimehydro);
                Img4p1.setImageResource(R.drawable.slimehydro);

                break;
            case "Doggo":
                Img1p1.setImageResource(R.drawable.doggo);
                Img2p1.setImageResource(R.drawable.doggo);
                Img3p1.setImageResource(R.drawable.doggo);
                Img4p1.setImageResource(R.drawable.doggo);

                break;
        }

        Img2p1.setVisibility(View.INVISIBLE);
        Img3p1.setVisibility(View.INVISIBLE);
        Img4p1.setVisibility(View.INVISIBLE);
        Img2p2.setVisibility(View.INVISIBLE);
        Img3p2.setVisibility(View.INVISIBLE);
        Img4p2.setVisibility(View.INVISIBLE);

        nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
        nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);

        op1p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(op1p1V==true){

                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }
                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp1){
                        case 1:
                           Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.VISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                        break;
                        case 2:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.VISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                         mostrarPopVictoria(1);
                            break;

                    }
                }
                nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
            }
        });
        op2p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(op2p1V==true){
                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp1){
                        case 1:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.VISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.VISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(1);
                            break;

                    }
                }
                nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
            }
        });
        op3p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(op3p1V==true){
                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp1){
                        case 1:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.VISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.VISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(1);
                            break;

                    }
                }
                nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
            }
        });
        op4p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(op4p1V==true){
                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp1){
                        case 1:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.VISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.VISIBLE);
                            Img4p1.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp1++;
                            Img1p1.setVisibility(View.INVISIBLE);
                            Img2p1.setVisibility(View.INVISIBLE);
                            Img3p1.setVisibility(View.INVISIBLE);
                            Img4p1.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(1);
                            break;

                    }
                }
                nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
            }
        });
        op1p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op1p2V==true){

                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp2){
                        case 1:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.VISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.VISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(2);
                            break;

                    }
                }
                nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);
            }
        });
        op2p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op2p2V==true){

                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp2){
                        case 1:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.VISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.VISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(2);
                            break;

                    }
                }
                nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);
            }
        });
        op3p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op3p2V==true){

                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }

                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp2){
                        case 1:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.VISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.VISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(2);
                            break;

                    }
                }
                nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);
            }
        });
        op4p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op4p2V==true){

                    SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= plays.edit();
                    int hambrenueva= plays.getInt("plays",100);
                    if((plays.getInt("plays",100)+5)<105) {
                        editor.putInt("plays", hambrenueva + 5);
                        editor.apply();
                    }
                    BarraJuego.setProgress(plays.getInt("plays",100));
                    switch (Vp2){
                        case 1:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.VISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.VISIBLE);
                            Img4p2.setVisibility(View.INVISIBLE);
                            break;
                        case 3:
                            Vp2++;
                            Img1p2.setVisibility(View.INVISIBLE);
                            Img2p2.setVisibility(View.INVISIBLE);
                            Img3p2.setVisibility(View.INVISIBLE);
                            Img4p2.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            mostrarPopVictoria(2);
                            break;

                    }
                }
                nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);
            }
        });
    }

    public void nuevaOperacion(TextView operacion,TextView numero1,TextView numero2,Button op1,Button op2,Button op3,Button op4,int jugador ){
        Random random = new Random ();
        int ojo=random.nextInt(2);

        switch(ojo){
            case 0:
                int suma1=random.nextInt(19)+1;
                int suma2=random.nextInt(19)+1;
                operacion.setText("+");
                numero1.setText(String.valueOf(suma1));
                numero2.setText(String.valueOf(suma2));
                int correcto=random.nextInt(3)+1;
                switch(correcto){
                    case 1:
                        if(jugador==1) {
                            op1p1V = true;
                            op2p1V = false;
                            op3p1V = false;
                            op4p1V = false;



                        }
                        else{
                            op1p2V = true;
                            op2p2V = false;
                            op3p2V = false;
                            op4p2V =  false;
                        }
                        op1.setText(String.valueOf((suma1+suma2)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 2:
                        if(jugador==1) {
                            op2p1V = true;
                            op1p1V = false;
                            op3p1V = false;
                            op4p1V =  false;


                        }
                        else{
                            op2p2V = true;
                            op1p2V = false;
                            op3p2V = false;
                            op4p2V =  false;
                        }
                        op2.setText(String.valueOf((suma1+suma2)));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 3:
                        if(jugador==1) {
                            op3p1V = true;
                            op1p1V = false;
                            op2p1V = false;
                            op4p1V =  false;


                        }
                        else{
                            op3p2V = true;
                            op2p2V = false;
                            op1p2V = false;
                            op4p2V =  false;

                        }
                        op3.setText(String.valueOf((suma1+suma2)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 4:
                        if(jugador==1) {
                            op4p1V = true;
                            op2p1V = false;
                            op3p1V = false;
                            op1p1V =  false;


                        }
                        else{
                            op4p2V = true;
                            op2p2V = false;
                            op3p2V = false;
                            op1p2V =  false;
                        }
                        op4.setText(String.valueOf((suma1+suma2)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                }

                break;
            case 1:
                int resta1=random.nextInt(19)+1;
                int resta2=random.nextInt(19)+1;
                int resultado;
                operacion.setText("-");
                if(resta1>resta2){
                    numero1.setText(String.valueOf(resta1));
                    numero2.setText(String.valueOf(resta2));
                    resultado=resta1-resta2;
                }
                else {
                    numero2.setText(String.valueOf(resta1));
                    numero1.setText(String.valueOf(resta2));
                    resultado = resta2 - resta1;
                }
                int correcto2=random.nextInt(3)+1;
                switch(correcto2){
                    case 1:
                        if(jugador==1) {
                            op1p1V = true;
                            op2p1V = false;
                            op3p1V = false;
                            op4p1V = false;



                        }
                        else{
                            op1p2V = true;
                            op2p2V = false;
                            op3p2V = false;
                            op4p2V =  false;
                        }
                        op1.setText(String.valueOf((resultado)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 2:
                        if(jugador==1) {
                            op2p1V = true;
                            op1p1V = false;
                            op3p1V = false;
                            op4p1V =  false;


                        }
                        else{
                            op2p2V = true;
                            op1p2V = false;
                            op3p2V = false;
                            op4p2V =  false;
                        }
                        op2.setText(String.valueOf((resultado)));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 3:
                        if(jugador==1) {
                            op3p1V = true;
                            op1p1V = false;
                            op2p1V = false;
                            op4p1V =  false;


                        }
                        else{
                            op3p2V = true;
                            op2p2V = false;
                            op1p2V = false;
                            op4p2V =  false;
                        }
                        op3.setText(String.valueOf((resultado)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        op4.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                    case 4:
                        if(jugador==1) {
                            op4p1V = true;
                            op2p1V = false;
                            op3p1V = false;
                            op1p1V =  false;


                        }
                        else{
                            op4p2V = true;
                            op2p2V = false;
                            op3p2V = false;
                            op1p2V =  false;
                        }
                        op4.setText(String.valueOf((resultado)));
                        op2.setText(String.valueOf(random.nextInt(39)+1));
                        op3.setText(String.valueOf(random.nextInt(39)+1));
                        op1.setText(String.valueOf(random.nextInt(39)+1));
                        break;
                }

                break;

        }


    }
    public void mostrarPopVictoria(int victorioso){
        Button Confirmar;
        TextView p1,p2;
        Victoria.setContentView(R.layout.victoriapopup);
        Img1p1=findViewById(R.id.img1p1);
        Img2p1=findViewById(R.id.img2p1);
        Img3p1=findViewById(R.id.img3p1);
        Img4p1=findViewById(R.id.img4p1);

        Img1p2=findViewById(R.id.img1p2);
        Img2p2=findViewById(R.id.img2p2);
        Img3p2=findViewById(R.id.img3p2);
        Img4p2=findViewById(R.id.img4p2);
        Confirmar= (Button) Victoria.findViewById(R.id.confirmar);
        p1 = (TextView) Victoria.findViewById(R.id.txtp1);
        p2 = (TextView) Victoria.findViewById(R.id.txtp2);

     if(victorioso==1){
         p1.setText("Victoria");
         p2.setText("Derrota");
     }
     else{
         p1.setText("Derrota");
         p2.setText("Victoria");
     }
        Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Img1p1.setVisibility(View.VISIBLE);
                Img2p1.setVisibility(View.INVISIBLE);
                Img3p1.setVisibility(View.INVISIBLE);
                Img4p1.setVisibility(View.INVISIBLE);
                Img1p2.setVisibility(View.VISIBLE);
                Img2p2.setVisibility(View.INVISIBLE);
                Img3p2.setVisibility(View.INVISIBLE);
                Img4p2.setVisibility(View.INVISIBLE);

                nuevaOperacion(Operacionp1,num1p1,num2p1,op1p1,op2p1,op3p1,op4p1,1);
                nuevaOperacion(Operacionp2,num1p2,num2p2,op1p2,op2p2,op3p2,op4p2,2);
                Vp1=1;
                Vp2=1;

                Victoria.dismiss();
            }
        });



       Victoria.show();
    }


}