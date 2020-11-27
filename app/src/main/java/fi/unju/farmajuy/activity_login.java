package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }

    public void Omitir(View view){
        Intent intent = new Intent(activity_login.this, activity_menu.class);
        startActivity(intent);
    }

    public void RegistroCliente(View view){
        Intent intent = new Intent(activity_login.this, activity_reg_cliente.class);
        startActivity(intent);
    }

    public void RegistroFarmacia(View view){
        Intent intent = new Intent(activity_login.this, activity_reg_farmacia.class);
        startActivity(intent);
    }

}