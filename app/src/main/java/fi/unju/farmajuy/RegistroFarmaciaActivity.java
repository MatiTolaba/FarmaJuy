package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegistroFarmaciaActivity extends AppCompatActivity {

    private TextInputLayout tilCUIT;
    private TextInputLayout tilNombre;
    private TextInputLayout tilTelefono;
    private TextInputLayout tilDireccion;
    private TextInputLayout tilHorario;
    private TextInputLayout tilContraseña;
    private TextInputLayout tilContraseña2;
    private EditText campoCUIT;
    private EditText campoNombre;
    private EditText campoTelefono;
    private EditText campoDireccion;
    private EditText campoHorario;
    private EditText campoContraseña;
    private EditText campoContraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_farmacia);

        //poner el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Referencias TILs
        tilCUIT = (TextInputLayout) findViewById(R.id.til_cuit);
        tilNombre = (TextInputLayout) findViewById(R.id.til_nombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.til_telefono);
        tilDireccion = (TextInputLayout) findViewById(R.id.til_direccion);
        tilHorario = (TextInputLayout) findViewById(R.id.til_horario);
        tilContraseña = (TextInputLayout) findViewById(R.id.til_contraseña);
        tilContraseña2 = (TextInputLayout) findViewById(R.id.til_contraseña2);

        // Referencias ETs
        campoCUIT = (EditText) findViewById(R.id.campo_cuit);
        campoNombre = (EditText) findViewById(R.id.campo_nombre);
        campoTelefono = (EditText) findViewById(R.id.campo_telefono);
        campoDireccion = (EditText) findViewById(R.id.campo_direccion);
        campoHorario = (EditText) findViewById(R.id.campo_horario);
        campoContraseña = (EditText) findViewById(R.id.campo_contraseña);
        campoContraseña2 = (EditText) findViewById(R.id.campo_contraseña2);

        campoNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilNombre.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        campoTelefono.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tilTelefono.setError(null);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });


        campoContraseña.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tilContraseña.setError(null);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });

        campoContraseña2.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tilContraseña.setError(null);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });



    // Referencia Botón
    Button botonAceptar = (Button) findViewById(R.id.boton_aceptar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            validarDatos();
        }
    });

}

    private boolean esCUITValido(String cuit) {
        if (!Patterns.PHONE.matcher(cuit).matches()) {
            tilCUIT.setError("CUIT inválido");
            return false;
        } else {
            tilCUIT.setError(null);
        }

        return true;
    }


    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            tilNombre.setError("Nombre inválido");
            return false;
        } else {
            tilNombre.setError(null);
        }

        return true;
    }

    private boolean esTelefonoValido(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches()) {
            tilTelefono.setError("Teléfono inválido");
            return false;
        } else {
            tilTelefono.setError(null);
        }

        return true;
    }

    private boolean esDirValido(String dir) {
        //Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if ( dir.length() > 50) {
            tilDireccion.setError("Direccion inválida");
            return false;
        } else {
            tilDireccion.setError(null);
        }

        return true;
    }




    private boolean esContraValido(String contra, String contra2) {
        if (contra.length() < 5) {
            tilContraseña.setError("Contraseña muy corta. Debe superar los 4 caracteres.");
            return false;
        } else if (!contra.equals(contra2)){
            tilContraseña2.setError("Las contraseñas deben coincidir");
            return false;
        } else{
            tilContraseña.setError(null);
            tilContraseña2.setError(null);
        }

        return true;
    }

    private void validarDatos() {
        String nombre = tilNombre.getEditText().getText().toString();
        String telefono = tilTelefono.getEditText().getText().toString();
        String dir = tilDireccion.getEditText().getText().toString();
        String contraseña = tilContraseña.getEditText().getText().toString();
        String contraseña2 = tilContraseña2.getEditText().getText().toString();
        String cuit = tilCUIT.getEditText().getText().toString();

        boolean a = esNombreValido(nombre);
        boolean b = esTelefonoValido(telefono);
        boolean c = esDirValido(dir);
        boolean d = esContraValido(contraseña,contraseña2);
        boolean e = esCUITValido(cuit);

        if (a && b && c && d && e) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guardo la farmacia.", Toast.LENGTH_LONG).show();
        }

    }

}