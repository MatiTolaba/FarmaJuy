package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class activity_cargar_producto extends AppCompatActivity {

    private Spinner spinner_op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_producto);

        spinner_op = (Spinner)findViewById((R.id.spinner));


        String [] opciones = {"Medicamento", "Dermocosmetica", "Perfumes y Fragancias", "Bebes y Maternidad"}; //contenedor de opciones
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, opciones);
        spinner_op.setAdapter(adapter);
    }
}