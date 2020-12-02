package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }


    public void Sitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsSitiosActivity.class);
        startActivity(intent);
    }



    public void Ubicacion(View view){
        Intent intent = new Intent(getApplicationContext(), MapsMiUbicacionActivity.class);
        startActivity(intent);
    }

    public void Busqueda(View view){
        Intent intent = new Intent(getApplicationContext(), IngresoMedicamentoActivity.class);
        startActivity(intent);
    }
}