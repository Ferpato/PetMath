package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

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

public class Comida extends AppCompatActivity {
    ImageView Mascota,casa,img1,img2,img3,img4,food1,food2,imagenrespuesta;
    TextView num1,num2,num3,num4;
    Button btn1,btn2,btn3,btn4;
    ProgressBar Barracomida;
    boolean btn1V,btn2V,btn3V,btn4V;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);
        SharedPreferences MascotaElegida = getSharedPreferences("mascota", Context.MODE_PRIVATE);
        Mascota=findViewById(R.id.mascota);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        food1=findViewById(R.id.food1);
        food2=findViewById(R.id.food2);
        btn1=findViewById(R.id.op1);
        btn2=findViewById(R.id.op2);
        btn3=findViewById(R.id.op3);
        btn4=findViewById(R.id.op4);
        casa=findViewById(R.id.casa2);
        Barracomida=findViewById(R.id.BarraComida);
        imagenrespuesta=findViewById(R.id.imagenrespuesta);
        casa.setClickable(true);
        casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intencion);
            }
        });
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
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(btn1V==true){
                   imagenrespuesta.setImageResource(R.drawable.fork);
                   nuevaRonda();
                   SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor= comida.edit();
                   int hambrenueva= comida.getInt("comida",100);
                   editor.putInt("comida", hambrenueva+5);
                   editor.apply();
                   Barracomida=findViewById(R.id.BarraComida);
                   Barracomida.setProgress(comida.getInt("comida",100));


               }
               else{
                   imagenrespuesta.setImageResource(R.drawable.cruz2);
                   nuevaRonda();
               }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2V==true){
                    imagenrespuesta.setImageResource(R.drawable.fork);
                    nuevaRonda();
                    SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= comida.edit();
                    int hambrenueva= comida.getInt("comida",100);
                    editor.putInt("comida", hambrenueva+5);
                    editor.apply();
                    Barracomida=findViewById(R.id.BarraComida);
                    Barracomida.setProgress(comida.getInt("comida",100));


                }
                else{
                    imagenrespuesta.setImageResource(R.drawable.cruz2);
                    nuevaRonda();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn3V==true){
                    imagenrespuesta.setImageResource(R.drawable.fork);
                    nuevaRonda();
                    SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= comida.edit();
                    int hambrenueva= comida.getInt("comida",100);
                    editor.putInt("comida", hambrenueva+5);
                    editor.apply();
                    Barracomida=findViewById(R.id.BarraComida);
                    Barracomida.setProgress(comida.getInt("comida",100));


                }
                else{
                    imagenrespuesta.setImageResource(R.drawable.cruz2);
                    nuevaRonda();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn4V==true){
                    imagenrespuesta.setImageResource(R.drawable.fork);
                    nuevaRonda();
                    SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= comida.edit();
                    int hambrenueva= comida.getInt("comida",100);
                    editor.putInt("comida", hambrenueva+5);
                    editor.apply();
                    Barracomida=findViewById(R.id.BarraComida);
                    Barracomida.setProgress(comida.getInt("comida",100));


                }
                else{
                    imagenrespuesta.setImageResource(R.drawable.cruz2);
                    nuevaRonda();
                }
            }
        });

       nuevaRonda();
        SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
        Barracomida.setProgress(comida.getInt("comida",100));
    }

    public void nuevaRonda(){
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        food1=findViewById(R.id.food1);
        food2=findViewById(R.id.food2);
        btn1=findViewById(R.id.op1);
        btn2=findViewById(R.id.op2);
        btn3=findViewById(R.id.op3);
        btn4=findViewById(R.id.op4);
int elegido1,elegido2;
        Random random = new Random ();
        int precio1=random.nextInt(19)+1;
        int precio2=random.nextInt(19)+1;
        int precio3=random.nextInt(19)+1;
        int precio4=random.nextInt(19)+1;
        num1.setText(String.valueOf(precio1));
        num2.setText(String.valueOf(precio2));
        num3.setText(String.valueOf(precio3));
        num4.setText(String.valueOf(precio4));

        elegido1=random.nextInt(3)+1;
        switch(elegido1){
            case 1:
                elegido1=precio1;
                food1.setImageResource(R.drawable.lemonade);
                break;
            case 2:
                elegido1=precio2;
                food1.setImageResource(R.drawable.pizza);
                break;
            case 3:
                elegido1=precio3;
                food1.setImageResource(R.drawable.queso);
                break;
            case 4:
                elegido1=precio4;
                food1.setImageResource(R.drawable.brocoli);
                break;
        }
        elegido2=random.nextInt(3)+1;
        switch(elegido2){
            case 1:
                elegido2=precio1;
                food2.setImageResource(R.drawable.lemonade);
                break;
            case 2:
                elegido2=precio2;
                food2.setImageResource(R.drawable.pizza);
                break;
            case 3:
                elegido2=precio3;
                food2.setImageResource(R.drawable.queso);
                break;
            case 4:
                elegido2=precio4;
                food2.setImageResource(R.drawable.brocoli);
                break;
        }
        int button=random.nextInt(3)+1;
        switch(button){
            case 1:
                btn1.setText(String.valueOf(elegido1+elegido2));
                btn2.setText(String.valueOf(random.nextInt(39)+1));
                btn3.setText(String.valueOf(random.nextInt(39)+1));
                btn4.setText(String.valueOf(random.nextInt(39)+1));
                btn1V=true;
                btn2V=false;
                btn3V=false;
                btn4V=false;

                break;
            case 2:
                btn2.setText(String.valueOf(elegido1+elegido2));
                btn1.setText(String.valueOf(random.nextInt(39)+1));
                btn3.setText(String.valueOf(random.nextInt(39)+1));
                btn4.setText(String.valueOf(random.nextInt(39)+1));
                btn2V=true;
                btn1V=false;
                btn3V=false;
                btn4V=false;

                break;
            case 3:
                btn3.setText(String.valueOf(elegido1+elegido2));
                btn2.setText(String.valueOf(random.nextInt(39)+1));
                btn1.setText(String.valueOf(random.nextInt(39)+1));
                btn4.setText(String.valueOf(random.nextInt(39)+1));
                btn3V=true;
                btn1V=false;
                btn2V=false;
                btn4V=false;

                break;
            case 4:
                btn4.setText(String.valueOf(elegido1+elegido2));
                btn2.setText(String.valueOf(random.nextInt(39)+1));
                btn3.setText(String.valueOf(random.nextInt(39)+1));
                btn1.setText(String.valueOf(random.nextInt(39)+1));
                btn4V=true;
                btn1V=false;
                btn2V=false;
                btn3V=false;

                break;
        }

    }









}