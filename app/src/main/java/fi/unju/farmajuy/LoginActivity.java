package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;

import fi.unju.farmajuy.entidades.Cliente;
import fi.unju.farmajuy.entidades.Producto;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;


public class LoginActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private RadioButton rb1, rb2;

    private TextInputLayout tilCorreo;
    private TextInputLayout tilContraseña;
    private EditText edt1;

    private EditText campoCorreo;
    private EditText campoContraseña;
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rb1 = (RadioButton)findViewById(R.id.rb_cliente);
        rb2 = (RadioButton)findViewById(R.id.rb_farmacia);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        tilContraseña = (TextInputLayout) findViewById(R.id.til_contraseña);
        edt1 = (TextInputEditText)findViewById((R.id.campo_correo));
        campoCorreo = (EditText) findViewById(R.id.campo_correo);
        campoContraseña = (EditText) findViewById(R.id.campo_contraseña);

        //precargamos clientes al iniciar la pantalla, solo como ejemplo
        cargarClientes();

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
        String password = campoContraseña.getText().toString();
        if (rb1.isChecked()==true){

            listaClientes = buscarClientes();
            if ( !listaClientes.isEmpty()){
                if(listaClientes.get(0).getContrasenia().equals(password)){
                    Intent productoActivityIntent = new Intent(LoginActivity.this, MenuActivity.class);

                    startActivity(productoActivityIntent);
                }else {
                    Toast.makeText(getApplicationContext(),"Contraseña Incorrecta.", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(getApplicationContext(),"Error en los campos.", Toast.LENGTH_SHORT).show();
            }
        }

        if (rb2.isChecked()==true){
            Intent intent = new Intent(LoginActivity.this, MenuFarmaciaActivity.class);
            startActivity(intent);
        }
    }


    private ArrayList<Cliente> buscarClientes() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        Cliente cliente = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();


        String email = campoCorreo.getText().toString();
        String password = campoContraseña.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()){
            try {
                Cursor cursor = db.rawQuery("SELECT * FROM " + UtilidadesConexion.TABLA_CLIENTE +
                        " WHERE "+ UtilidadesConexion.CAMPO_CLIENTE_EMAIL + " = '"+email+"' ", null);

                while (cursor.moveToNext()){
                    cliente = new Cliente();
                    cliente.setCorreo(cursor.getString(0));
                    cliente.setNombre(cursor.getString(1));
                    cliente.setTelefono(cursor.getString(2));
                    cliente.setContrasenia(cursor.getString(3));

                    clientes.add(cliente);

                }

                db.close();

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"No existe el Cliente", Toast.LENGTH_LONG).show();
                db.close();
            }
        }


        return clientes;
    }

    public void cargarClientes(){
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();

        //CLIENTES
        valores.put(UtilidadesConexion.CAMPO_CLIENTE_EMAIL, "josenery@gmail.com");
        valores.put(UtilidadesConexion.CAMPO_CLIENTE_NOMBRE, "Jose");
        valores.put(UtilidadesConexion.CAMPO_CLIENTE_TELEFONO, "3885128002");
        valores.put(UtilidadesConexion.CAMPO_CLIENTE_CONTRASENIA, "123456");

        db.insert(UtilidadesConexion.TABLA_CLIENTE, null, valores);

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