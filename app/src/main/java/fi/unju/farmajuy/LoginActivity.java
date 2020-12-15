package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;


public class LoginActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private RadioButton rb1, rb2;

    private TextInputLayout tilCorreo;
    private EditText edt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rb1 = (RadioButton)findViewById(R.id.rb_cliente);
        rb2 = (RadioButton)findViewById(R.id.rb_farmacia);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        edt1 = (TextInputEditText)findViewById((R.id.campo_correo));

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb1.isChecked()==true){
                    edt1.setInputType(InputType.TYPE_CLASS_TEXT);
                    tilCorreo.setHint("Email");
                }
                if (rb2.isChecked()==true){
                    edt1.setInputType(InputType.TYPE_CLASS_PHONE);
                    tilCorreo.setHint("CUIT");
                }
            }});

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Aceptar(View view){
        if (rb1.isChecked()==true){
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }
        if (rb2.isChecked()==true){
            Intent intent = new Intent(LoginActivity.this, MenuFarmaciaActivity.class);
            startActivity(intent);
        }
    }

    public void RegistroCliente(View view){
        Intent intent = new Intent(LoginActivity.this, RegistroClienteActivity.class);
        startActivity(intent);
    }

    public void RegistroFarmacia(View view){
        Intent intent = new Intent(LoginActivity.this, RegistroFarmaciaActivity.class);
        startActivity(intent);
    }

}