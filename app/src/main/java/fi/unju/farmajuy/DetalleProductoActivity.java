package fi.unju.farmajuy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


import fi.unju.farmajuy.entidades.Producto;
import fi.unju.farmajuy.utilidades.UtilidadesConexion;


public class DetalleProductoActivity extends AppCompatActivity {

    TextView nombreProducto, drogaProducto, presentacionProducto, descripcionProducto, categoriaProducto;
    ImageView imagenProducto;

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

        Producto producto = (Producto) getIntent().getSerializableExtra("claveProducto");

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
}