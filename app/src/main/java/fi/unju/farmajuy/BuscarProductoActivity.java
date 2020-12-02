package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import fi.unju.farmajuy.entidades.Producto;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;

public class BuscarProductoActivity extends AppCompatActivity {

    EditText productoNombreDroga;

    ArrayList<Producto> listaProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_producto);

        productoNombreDroga = (EditText) findViewById(R.id.inputTextProductoNombreDroga);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBuscarProducto:

                listaProductos = buscarProductos();

                if ( !listaProductos.isEmpty() ){
                    Intent productoActivityIntent = new Intent(BuscarProductoActivity.this, ProductoActivity.class);
                    Bundle productoActivityBundle = new Bundle();

                    productoActivityBundle.putSerializable("listaProductos", listaProductos);
                    productoActivityIntent.putExtras(productoActivityBundle);

                    startActivity(productoActivityIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"No se han encontrado productos para su Busqueda ", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private ArrayList<Producto> buscarProductos() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        Producto producto = null;
        ArrayList<Producto> productos = new ArrayList<>();
        String parametro = productoNombreDroga.getText().toString();

        try {


            Cursor cursor = db.rawQuery("SELECT * FROM " + UtilidadesConexion.TABLA_PRODUCTO +
                    " WHERE "+ UtilidadesConexion.CAMPO_PRODUCTO_NOMBRE + " LIKE '%"+parametro+"%' ", null);

            while (cursor.moveToNext()){
                producto = new Producto();
                producto.setProducto_id(cursor.getInt(0));
                producto.setNombre(cursor.getString(1));
                producto.setDroga(cursor.getString(2));
                producto.setDescripcion(cursor.getString(3));
                producto.setPresentacion(cursor.getString(4));
                producto.setFoto((cursor.getString(5)));
                // TODO: hacer el de categoria id

                productos.add(producto);
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"No hay resultados", Toast.LENGTH_SHORT).show();
        }
        return productos;
    }

//    private void buscarMedicamento() {
//        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
//        SQLiteDatabase db = conexion.getReadableDatabase();
//
//        //String[] parametros = {medicamentoNombreDroga.getText().toString()};
//        //String[] camposDevueltos = {UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA};
//        String parametro = medicamentoNombreDroga.getText().toString();
//
//        try {
//            //Cursor cursor = db.query(UtilidadesConexion.TABLA_MEDICAMENTO,camposDevueltos,UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE+"=?", parametros,null,null,null);
//            Cursor cursor = db.rawQuery("SELECT "+UtilidadesConexion.CAMPO_MEDICAMENTO_DROGA+" FROM " + UtilidadesConexion.TABLA_MEDICAMENTO +
//                    " WHERE "+ UtilidadesConexion.CAMPO_MEDICAMENTO_NOMBRE + " LIKE '%"+parametro+"%' ", null);
//
//            cursor.moveToFirst();
//
//            pruebaDroga = cursor.getString(0);
//        } catch (Exception e) {
//
//        }
//    }
}