package fi.unju.farmajuy;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainBusquedaActivity extends AppCompatActivity {
    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);

        RegistrarMedicamentos();

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) findViewById(R.id.searchViewMedicamento);
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        searchView.setSubmitButtonEnabled(true);
    }

    private void RegistrarMedicamentos() {

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE, "Rivotril");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA, "Clonazepam");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_DESCRIPCION, "Ansiolítico");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_PRESENTACION, "Capsulas de 10 mg");
        //valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_FOTO, "https://imgbox.com/ZKCZRars");
        valores.put(UtilidadesConexion.CAMPO_MEDICAMENTO_FOTO, "https://images2.imgbox.com/80/ce/ZKCZRars_o.jpeg");


        Long idResultanteBaseDatos = db.insert(UtilidadesConexion.TABLA_MEDICAMENTO, UtilidadesConexion.CAMPO_MEDICAMENTO_ID, valores);

        Toast.makeText(getApplicationContext(),"ID Medicamento: "+idResultanteBaseDatos, Toast.LENGTH_SHORT).show();

        db.close();
    }
}