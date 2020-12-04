package fi.unju.farmajuy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


import java.util.ArrayList;

import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.entidades.Producto;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;


public class DetalleProductoActivity extends AppCompatActivity {

    TextView nombreProducto, drogaProducto, presentacionProducto, descripcionProducto, categoriaProducto;
    ImageView imagenProducto;

    ArrayList<Farmacia> listaFarmaciasConStock = new ArrayList<>();
    ArrayList<Double> preciosProducto = new ArrayList<>();

    Producto producto;
    //Double precioProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_producto);

        nombreProducto = (TextView) findViewById(R.id.tvNombreProducto);
        drogaProducto = (TextView) findViewById(R.id.tvDrogaProducto);
        presentacionProducto = (TextView) findViewById(R.id.tvPresentacionProducto);
        descripcionProducto = (TextView) findViewById(R.id.tvDescripcionProducto);
        imagenProducto = (ImageView) findViewById(R.id.imageViewProducto);
        categoriaProducto = (TextView) findViewById(R.id.tvNombreCategoriaProducto);

        producto = (Producto) getIntent().getSerializableExtra("claveProducto");

        if (producto != null){
            nombreProducto.setText(producto.getNombre());
            drogaProducto.setText(producto.getDroga());
            presentacionProducto.setText(producto.getPresentacion());
            descripcionProducto.setText(producto.getDescripcion());

            Glide.with(getApplicationContext())
                    .load(producto.getFoto())
                    .centerCrop()
                    .into(imagenProducto);

            obtenerCategoriaProducto(producto.getCategoria_id());
        }

    }

    private void obtenerCategoriaProducto(Integer categoriaId) {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        String parametro = categoriaId.toString();

        try {
            Cursor cursor = db.rawQuery("SELECT "+UtilidadesConexion.CAMPO_CATEGORIA_NOMBRE+" FROM " + UtilidadesConexion.TABLA_CATEGORIA +
                   " WHERE "+ UtilidadesConexion.CAMPO_CATEGORIA_ID + " = "+parametro, null);

            cursor.moveToFirst();

            categoriaProducto.setText(cursor.getString(0));
            cursor.close();
        } catch (Exception e) {

        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBuscarFarmacias:

                buscarFarmaciasConStock();

                if ( !listaFarmaciasConStock.isEmpty() ){
                    Intent activityIntent = new Intent(DetalleProductoActivity.this, FarmaciasConStockActivity.class);
                    Bundle activityBundle = new Bundle();

                    activityBundle.putSerializable("listaFarmaciasConStock", listaFarmaciasConStock);
                    //activityBundle.putDouble("precioProducto",precioProducto);
                    activityBundle.putSerializable("preciosProducto", preciosProducto);
                    activityIntent.putExtras(activityBundle);

                    startActivity(activityIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"No se han encontrado farmacias cercanas con stock de este medicamento ", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void buscarFarmaciasConStock() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_manager_medic_plus", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        // cambiar acá

        //DetalleProducto detalleProducto = null;
        Farmacia farmacia = null;
        Double precioProducto;
        //ArrayList<DetalleProducto> detallesProductos = new ArrayList<>();
        //String parametro = producto.getProducto_id().toString();

        try {


//            Cursor cursor = db.rawQuery("SELECT * FROM " + UtilidadesConexion.TABLA_DETALLE_PRODUCTO +
//                    " WHERE "+ UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID + " = "+parametro+" AND " +
//                    UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK + " > 0", null);
//
//            while (cursor.moveToNext()){
//                detalleProducto = new DetalleProducto();
//                detalleProducto.setDetalle_producto_id(cursor.getInt(0));
//                detalleProducto.setFarmacia_id(cursor.getInt(1));
//                detalleProducto.setProducto_id(cursor.getInt(2));
//                detalleProducto.setPrecio(cursor.getDouble(3));
//                //detalleProducto.setFecha_Vencimiento(cursor.getDate(4));
//                detalleProducto.setStock(cursor.getInt(5));
//
//                detallesProductos.add(detalleProducto);
//            }

            Cursor cursor = db.rawQuery("SELECT "+ UtilidadesConexion.TABLA_FARMACIA +"."+UtilidadesConexion.CAMPO_FARMACIA_ID +
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_NOMBRE+
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_DIRECCION+
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_HORARIO+
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_TELEFONO+
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_UBICACION+
                    ", "+ UtilidadesConexion.CAMPO_FARMACIA_FOTO+
                    ", "+ UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRECIO+
                    " FROM " + UtilidadesConexion.TABLA_FARMACIA +
                    " INNER JOIN "+ UtilidadesConexion.TABLA_DETALLE_PRODUCTO +
                    " on " + UtilidadesConexion.TABLA_DETALLE_PRODUCTO+
                    "."+UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_FARMACIA_ID+
                    " = "+ UtilidadesConexion.TABLA_FARMACIA +"."+ UtilidadesConexion.CAMPO_FARMACIA_ID+
                    " WHERE "+ UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_STOCK + " > 0", null);

            //+ UtilidadesConexion.CAMPO_DETALLE_PRODUCTO_PRODUCTO_ID +
            //                    " = "+parametro+" AND "

            while (cursor.moveToNext()){
//                detalleProducto = new DetalleProducto();
//                detalleProducto.setDetalle_producto_id(cursor.getInt(0));
//                detalleProducto.setFarmacia_id(cursor.getInt(1));
//                detalleProducto.setProducto_id(cursor.getInt(2));
//                detalleProducto.setPrecio(cursor.getDouble(3));
//                //detalleProducto.setFecha_Vencimiento(cursor.getDate(4));
//                detalleProducto.setStock(cursor.getInt(5));
//
//                detallesProductos.add(detalleProducto);
                farmacia = new Farmacia();
                farmacia.setNombre(cursor.getString(0));
                farmacia.setDireccion(cursor.getString(1));
                farmacia.setHorario(cursor.getString(2));
                farmacia.setTelefono(cursor.getString(3));
                //farmacia.setUbicacion(cursor.getString(4));
                farmacia.setFoto(cursor.getString(5));

                listaFarmaciasConStock.add(farmacia);

                System.out.println(listaFarmaciasConStock.size());

                precioProducto = cursor.getDouble(6);

                preciosProducto.add(precioProducto);
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"No hay resultados", Toast.LENGTH_SHORT).show();
        }
    }

}