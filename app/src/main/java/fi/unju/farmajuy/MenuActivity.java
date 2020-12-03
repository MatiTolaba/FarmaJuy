package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Coloco el icono en el actionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Registramos productos al iniciar esta pantalla, solo como ejemplo
        RegistrarProductos();
    }

    private void RegistrarProductos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE, "Medicamentos");

        db.insert(UtilidadesConexion.TABLA_CATEGORIA, UtilidadesConexion.CAMPO_CATEGORIA_ID, valores);

        valores = new ContentValues();

        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_ID, 1);
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE, "Rivotril");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DROGA, "Clonazepam");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_DESCRIPCION, "Ansiolítico");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_PRESENTACION, "Capsulas de 10 mg");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_FOTO, "https://images2.imgbox.com/80/ce/ZKCZRars_o.jpeg");
        valores.put(UtilidadesConexion.CAMPO_PRODUCTO_CATEGORIA_ID, 1);

        Long idResultanteBaseDatos = db.insert(UtilidadesConexion.TABLA_PRODUCTO, UtilidadesConexion.CAMPO_PRODUCTO_ID, valores);

        Toast.makeText(getApplicationContext(),"ID Producto: "+idResultanteBaseDatos, Toast.LENGTH_SHORT).show();

        db.close();
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
        Intent intent = new Intent(getApplicationContext(), BuscarProductoActivity.class);
        startActivity(intent);
    }
}