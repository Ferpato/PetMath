package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView Mascota,cama,comer,juego;
Button Confirmar;
Dialog Dialogo,Dialogo2;
TextView Nombrepet,HORA;
String Nombre,MascotaImg;
ProgressBar BarraHambre,Barracomida,BarraJuego;

int i;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
int hambre;
long lasTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Dialogo = new Dialog(this);
        Dialogo2 = new Dialog(this);
        setContentView(R.layout.activity_main);
        Nombrepet=findViewById(R.id.NamePet);
        juego=findViewById(R.id.juego);
        cama=findViewById(R.id.cama);
        Mascota=findViewById(R.id.imageView2);
        BarraHambre=findViewById(R.id.BarraHambre);
        BarraJuego=findViewById(R.id.BarraJuego2);
        comer=findViewById(R.id.comer);
        Mascota.setClickable(true);
        Barracomida=findViewById(R.id.Barracomida);

        //SHARED PREFERENCES
        SharedPreferences MascotaElegida = getSharedPreferences("mascota", Context.MODE_PRIVATE);
        SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
        SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
        SharedPreferences plays = getSharedPreferences("plays", Context.MODE_PRIVATE);

        BarraHambre.setProgress(hambre.getInt("hambre",100));
        Barracomida.setProgress(comida.getInt("comida",100));
        BarraJuego.setProgress(plays.getInt("plays",100));

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
        SharedPreferences Nombre = getSharedPreferences("nombre", Context.MODE_PRIVATE);
        Nombrepet.setText(Nombre.getString("nombre","Nombre Mascota"));

        Mascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarPop();
            }
        });
        Nombrepet.setClickable(true);
        Nombrepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarPopNombre();
            }
        });
        cama.setClickable(true);
        cama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intencion = new Intent(getApplicationContext(), Limpiar.class);
                startActivity(intencion);
            }
        });
        comer.setClickable(true);
        comer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intencion = new Intent(getApplicationContext(), Comida.class);
                startActivity(intencion);
            }
        });
        juego.setClickable(true);
        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intencion = new Intent(getApplicationContext(), Multiplayer.class);
                startActivity(intencion);
            }
        });


    }
    public void MostrarPop(){
        ImageView Anterior,Siguiente,MascotaPop;
        Dialogo.setContentView(R.layout.custompopup);
        MascotaPop= Dialogo.findViewById(R.id.imageView12);
        SharedPreferences miCompartido = getSharedPreferences("mascota", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= miCompartido.edit();

        MascotaImg = miCompartido.getString("mascota","Poro");
        Confirmar= (Button) Dialogo.findViewById(R.id.Confirmar);



        switch(miCompartido.getString("mascota","Poro")){
            case "Poro":
                MascotaPop.setImageResource(R.drawable.poro);


                break;
            case "Slime":
                MascotaPop.setImageResource(R.drawable.slimehydro);

                break;
            case "Doggo":
                MascotaPop.setImageResource(R.drawable.doggo);

                break;
        }

        Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("mascota", MascotaImg);
                editor.commit();
                switch(miCompartido.getString("mascota","Poro")){
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


                Dialogo.dismiss();
            }
        });


        Anterior=Dialogo.findViewById(R.id.anterior);
        Anterior.setClickable(true);
        Anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(MascotaImg){
                    case "Poro":
                        MascotaPop.setImageResource(R.drawable.doggo);
                        MascotaImg="Doggo";

                        break;
                    case "Slime":
                        MascotaPop.setImageResource(R.drawable.poro);
                        MascotaImg="Poro";
                        break;
                    case "Doggo":
                        MascotaPop.setImageResource(R.drawable.slimehydro);
                        MascotaImg="Slime";
                        break;
                }

            }
        });

        Siguiente=Dialogo.findViewById(R.id.siguiente);
        Siguiente.setClickable(true);

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(MascotaImg){
                    case "Poro":
                        MascotaPop.setImageResource(R.drawable.slimehydro);
                        MascotaImg="Slime";

                        break;
                    case "Slime":
                        MascotaPop.setImageResource(R.drawable.doggo);
                        MascotaImg="Doggo";
                        break;
                    case "Doggo":
                        MascotaPop.setImageResource(R.drawable.poro);
                        MascotaImg="Poro";
                        break;
                }

            }
        });




            Dialogo.show();
    }


    public void mostrarPopNombre(){
        Button Cambiar;
        EditText Nombre;
        Dialogo2.setContentView(R.layout.nombrepopup);
        Cambiar= (Button) Dialogo2.findViewById(R.id.Cambiar);
        Nombre = (EditText) Dialogo2.findViewById(R.id.editTextText);
        SharedPreferences miCompartido = getSharedPreferences("nombre", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= miCompartido.edit();
        Nombre.setText(miCompartido.getString("nombre","Nombre Mascota"));
        Cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("nombre", Nombre.getText().toString());
                editor.commit();
                Nombrepet.setText(Nombre.getText().toString());
                Dialogo2.dismiss();
            }
        });



        Dialogo2.show();
    }
    @Override
    protected void onResume() {
        super.onResume();
 TextView hora=findViewById(R.id.HORA);
        // Init
        // ialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();

        // Get the last updated time from SharedPreferences
        long lastUpdatedTime = sharedPreferences.getLong("lastUpdatedTime", 0);

        // Calculate the time difference in minutes
        long currentTime = System.currentTimeMillis();
        long timeDifference = (currentTime - lastUpdatedTime) / (60 * 1000);

        // Increment the variable i based on the time difference
        i += timeDifference;
        hora.setText("Minutos desde que entró "+String.valueOf(i));
        //HAMBRE BARRA
        SharedPreferences hambre = getSharedPreferences("hambre", Context.MODE_PRIVATE);
       int hambrenueva= hambre.getInt("hambre",100);
       if((hambrenueva-(i*5))>0) {
           hambrenueva = hambrenueva - (i * 5);
       }
       else{
           hambrenueva=0;
       }
        SharedPreferences.Editor editor= hambre.edit();
        editor.putInt("hambre", hambrenueva);
        editor.apply();
        BarraHambre=findViewById(R.id.BarraHambre);
        BarraHambre.setProgress(hambrenueva);


        //COMIDA BARRA
        SharedPreferences comida = getSharedPreferences("comida", Context.MODE_PRIVATE);
        int comidanueva= comida.getInt("comida",100);
        if((comidanueva-(i*5))>0) {
            comidanueva = comidanueva- (i * 5);
        }
        else{
            comidanueva=0;
        }
        SharedPreferences.Editor editor2= comida.edit();
        editor2.putInt("comida", comidanueva);
        editor2.apply();
        Barracomida=findViewById(R.id.Barracomida);
        Barracomida.setProgress(comidanueva);
//Juego Barra
        SharedPreferences plays= getSharedPreferences("plays", Context.MODE_PRIVATE);
        int juegonueva= plays.getInt("plays",100);
        if((juegonueva-(i*5))>0) {
            juegonueva =juegonueva- (i * 5);
        }
        else{
            juegonueva=0;
        }
        SharedPreferences.Editor editor3= plays.edit();
        editor3.putInt("plays", juegonueva);
        editor3.apply();
        Barracomida=findViewById(R.id.BarraJuego2);
        Barracomida.setProgress(juegonueva);





        // Save the current time as the last updated time
        editor = sharedPreferences.edit();
        editor.putLong("lastUpdatedTime", currentTime);
        editor.apply();
    }
    @Override
    protected void onPause() {
        super.onPause();

        // Save the current time as the last updated time
        long currentTime = System.currentTimeMillis();
        editor.putLong("lastUpdatedTime", currentTime);
        editor.apply();
        i=0;
    }


}
