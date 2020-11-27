package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import fi.unju.farmajuy.adaptadores.AdaptadorMedicamento;
import fi.unju.farmajuy.entidades.Medicamento;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class MedicamentoBusquedaActivity extends AppCompatActivity {

    RecyclerView recyclerViewMedicamentos;
    ArrayList<Medicamento> medicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            medicamentos = buscarMedicamentos(query);
        }

        recyclerViewMedicamentos = (RecyclerView) findViewById(R.id.recyclerViewItemsMedicamento);
        recyclerViewMedicamentos.setLayoutManager( new LinearLayoutManager(this));

        AdaptadorMedicamento adaptadorMedicamento = new AdaptadorMedicamento(this, medicamentos);
        recyclerViewMedicamentos.setAdapter(adaptadorMedicamento);

    }

    private ArrayList<Medicamento> buscarMedicamentos(String parametro) {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        Medicamento medicamento = null;
        ArrayList<Medicamento> medicamentos = new ArrayList<>();

        try {

            Cursor cursor = db.rawQuery("SELECT * FROM " + UtilidadesConexion.TABLA_MEDICAMENTO +
                    " WHERE "+ UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE + " LIKE '%"+parametro+"%' ", null);

            while (cursor.moveToNext()){
                medicamento = new Medicamento();
                medicamento.setMedicamento_id(cursor.getInt(0));
                medicamento.setNombre(cursor.getString(1));
                medicamento.setDroga(cursor.getString(2));
                medicamento.setDescripcion(cursor.getString(3));
                medicamento.setPresentacion(cursor.getString(4));
                medicamento.setFoto((cursor.getString(5)));
                // TODO: hacer el de categoria id

                medicamentos.add(medicamento);
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"No hay resultados", Toast.LENGTH_SHORT).show();
        }
        return medicamentos;
    }
}