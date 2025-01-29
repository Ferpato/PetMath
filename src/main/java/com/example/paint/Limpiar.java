package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Limpiar extends AppCompatActivity {
    ProgressBar BarraHambre;
ImageView casa,Mascota,imagenDream;
Button Letra1,Letra2,Letra3,Letra4;
TextView L1,L2,L3,L4,L5,L6,L7,L8;
boolean btn1V,btn2V,btn3V,btn4V;


int palabra;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpiar);
        Letra1=findViewById(R.id.Letra1);
        Letra2=findViewById(R.id.Letra2);
        Letra3=findViewById(R.id.Letra3);
        Letra4=findViewById(R.id.Letra4);
        L1=findViewById(R.id.L1);
        L2=findViewById(R.id.L2);
        L3=findViewById(R.id.L3);
        L4=findViewById(R.id.L4);
        L5=findViewById(R.id.L5);
        L6=findViewById(R.id.L6);
        L7=findViewById(R.id.L7);
        L8=findViewById(R.id.L8);
        imagenDream=findViewById(R.id.imagensueno);
        BarraHambre=findViewById(R.id.barraHambre);
ronda();
        Mascota=findViewById(R.id.Mascota2);
        casa=findViewById(R.id.casa);
        casa.setClickable(true);
        casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intencion);
            }
        });
        //SHARED PREFERENCES
        SharedPreferences MascotaElegida = getSharedPreferences("mascota", Context.MODE_PRIVATE);
        switch(MascotaElegida.getString("mascota","Poro")){
            case "Poro":
                Mascota.setImageResource(R.drawable.poro);


                break;
            case "Slime":
                Mascota.setImageResource(R.drawable.slimehydro);

                break;
            case "Doggo":
                Mascota.setImageResource(R.drawable.doggo);

                break;
        }
        Letra1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         if(btn1V==true){
             switch(palabra){
                 case 1 :
                     imagenDream.setImageResource(R.drawable.alumno);
                     break;
                 case 2 :
                     imagenDream.setImageResource(R.drawable.castillo);
                     break;
                 case 3 :
                     imagenDream.setImageResource(R.drawable.pavo);
                     break;
                 case 4 :
                     imagenDream.setImageResource(R.drawable.zebra);
                     break;
                 case 5 :
                     imagenDream.setImageResource(R.drawable.hockey);
                     break;

             }
             SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
             SharedPreferences.Editor editor= hambre.edit();
             int hambrenueva= hambre.getInt("hambre",100);
             editor.putInt("hambre", hambrenueva+5);
             editor.apply();
             BarraHambre=findViewById(R.id.barraHambre);
             BarraHambre.setProgress(hambre.getInt("hambre",100));
                }
         else{
             imagenDream.setImageResource(R.drawable.cruz2);
         }
                ronda();
            }

        });
        Letra2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2V==true){
                    switch(palabra){
                        case 1 :
                            imagenDream.setImageResource(R.drawable.alumno);
                            break;
                        case 2 :
                            imagenDream.setImageResource(R.drawable.castillo);
                            break;
                        case 3 :
                            imagenDream.setImageResource(R.drawable.pavo);
                            break;
                        case 4 :
                            imagenDream.setImageResource(R.drawable.zebra);
                            break;
                        case 5 :
                            imagenDream.setImageResource(R.drawable.hockey);
                            break;
                    }
                    SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= hambre.edit();
                    int hambrenueva= hambre.getInt("hambre",100);
                    editor.putInt("hambre", hambrenueva+5);
                    editor.apply();
                    BarraHambre=findViewById(R.id.barraHambre);
                    BarraHambre.setProgress(hambre.getInt("hambre",100));
                }
                else{
                    imagenDream.setImageResource(R.drawable.cruz2);
                }
                ronda();
            }

        });
        Letra3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn3V==true){
                    switch(palabra){
                        case 1 :
                            imagenDream.setImageResource(R.drawable.alumno);
                            break;
                        case 2 :
                            imagenDream.setImageResource(R.drawable.castillo);
                            break;
                        case 3 :
                            imagenDream.setImageResource(R.drawable.pavo);
                            break;
                        case 4 :
                            imagenDream.setImageResource(R.drawable.zebra);
                            break;
                        case 5 :
                            imagenDream.setImageResource(R.drawable.hockey);
                            break;
                    }
                    SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= hambre.edit();
                    int hambrenueva= hambre.getInt("hambre",100);
                    editor.putInt("hambre", hambrenueva+5);
                    editor.apply();
                    BarraHambre=findViewById(R.id.barraHambre);
                    BarraHambre.setProgress(hambre.getInt("hambre",100));
                }
                else{
                    imagenDream.setImageResource(R.drawable.cruz2);
                }
                ronda();
            }

        });
        Letra4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn4V==true){
                    switch(palabra){
                        case 1 :
                            imagenDream.setImageResource(R.drawable.alumno);
                            break;
                        case 2 :
                            imagenDream.setImageResource(R.drawable.castillo);
                            break;
                        case 3 :
                            imagenDream.setImageResource(R.drawable.pavo);
                            break;
                        case 4 :
                            imagenDream.setImageResource(R.drawable.zebra);
                            break;
                        case 5 :
                            imagenDream.setImageResource(R.drawable.hockey);
                            break;
                    }
                    SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= hambre.edit();
                    int hambrenueva= hambre.getInt("hambre",100);
                    editor.putInt("hambre", hambrenueva+5);
                    editor.apply();
                    BarraHambre=findViewById(R.id.barraHambre);
                    BarraHambre.setProgress(hambre.getInt("hambre",100));
                }
                else{
                    imagenDream.setImageResource(R.drawable.cruz2);
                }
                ronda();
            }

        });


        SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
        BarraHambre.setProgress(hambre.getInt("hambre",100));
    }



    public void ronda(){
        L1.setTextColor(Color.BLACK);
        L2.setTextColor(Color.BLACK);
        L3.setTextColor(Color.BLACK);
        L4.setTextColor(Color.BLACK);
        L5.setTextColor(Color.BLACK);
        L6.setTextColor(Color.BLACK);
        L7.setTextColor(Color.BLACK);
        L8.setTextColor(Color.BLACK);

        int num,numerosletra=0;
        Random random = new Random ();
        num=random.nextInt(5) + 1;
        switch(num){
            case 1:
                L1.setText("a");
                L2.setText("l");
                L3.setText("u");
                L4.setText("m");
                L5.setText("n");
                L6.setText("o");
                L7.setText("");
                L8.setText("");
                palabra=1;
numerosletra=5;
                break;
            case 2:
                L1.setText("c");
                L2.setText("a");
                L3.setText("s");
                L4.setText("t");
                L5.setText("i");
                L6.setText("l");
                L7.setText("l");
                L8.setText("o");
                numerosletra=7;
                palabra=2;

                break;
            case 3:
                L1.setText("p");
                L2.setText("a");
                L3.setText("v");
                L4.setText("o");
                L5.setText("");
                L6.setText("");
                L7.setText("");
                L8.setText("");
                numerosletra=3;
                palabra=3;

                break;
            case 4:
                L1.setText("z");
                L2.setText("e");
                L3.setText("b");
                L4.setText("r");
                L5.setText("a");
                L6.setText("");
                L7.setText("");
                L8.setText("");
                numerosletra=4;
                palabra=4;

                break;
            case 5:
                L1.setText("h");
                L2.setText("o");
                L3.setText("c");
                L4.setText("k");
                L5.setText("e");
                L6.setText("y");
                L7.setText("");
                L8.setText("");
palabra=5;
                numerosletra=5;
                break;
        }
        String letra="";
        int num2=random.nextInt(numerosletra)+1;
        switch(num2){
            case 1:
                L1.setTextColor(Color.RED);
                letra=L1.getText().toString();
                break;
            case 2:
                L2.setTextColor(Color.RED);
                letra=L2.getText().toString();
                break;
            case 3:
                L3.setTextColor(Color.RED);
                letra=L3.getText().toString();
                break;
            case 4:
                L4.setTextColor(Color.RED);
                letra=L4.getText().toString();
                break;
            case 5:
                L5.setTextColor(Color.RED);
                letra=L5.getText().toString();
                break;
            case 6:
                L6.setTextColor(Color.RED);
                letra=L6.getText().toString();
                break;
            case 7:
                L7.setTextColor(Color.RED);
                letra=L7.getText().toString();
                break;
            case 8:
                L8.setTextColor(Color.RED);
                letra=L8.getText().toString();
                break;

        }
        int num3=random.nextInt(3)+1;
        switch(num3){
            case 1:
                btn1V=true;
                btn2V=false;
                btn3V=false;
                btn4V=false;
                Letra1.setText(letra);
                Letra2.setText(genLetra());
                Letra3.setText(genLetra());
                Letra4.setText(genLetra());
                break;
            case 2:
                btn1V=false;
                btn2V=true;
                btn3V=false;
                btn4V=false;
                Letra2.setText(letra);

                Letra1.setText(genLetra());
                Letra3.setText(genLetra());
                Letra4.setText(genLetra());
                break;
            case 3:
                btn1V=false;
                btn2V=false;
                btn3V=true;
                btn4V=false;
                Letra3.setText(letra);
                Letra2.setText(genLetra());
                Letra1.setText(genLetra());
                Letra4.setText(genLetra());
                break;
            case 4:
                btn1V=false;
                btn2V=false;
                btn3V=false;
                btn4V=true;
                Letra4.setText(letra);
                Letra2.setText(genLetra());
                Letra3.setText(genLetra());
                Letra1.setText(genLetra());
                break;
        }
    }
    public String genLetra(){
        Random random = new Random ();
        int num3=random.nextInt(25)+1;
        switch(num3){
            case 1:
                return "A";

            case 2:
                return "B";

            case 3:
                return "C";

            case 4:
                return "D";

            case 5:
                return "E";

            case 6:
                return "F";

            case 7:
                return "G";

            case 8:
                return "H";

            case 9:
                return "I";

            case 10:
                return "J";

            case 11:
                return "K";

            case 12:
                return "L";

            case 13:
                return "M";

            case 14:
                return "N";

            case 15:
                return "O";

            case 16:
                return "P";

            case 17:
                return "Q";

            case 18:
                return "R";

            case 19:
                return "S";

            case 20:
                return "T";

            case 21:
                return "U";

            case 22:
                return "V";

            case 23:
                return "w";

            case 24:
                return "x";

            case 25:
                return "y";

            case 26:
                return "z";



            default:
                return"JIJI";

        }
    }
}