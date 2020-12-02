package fi.unju.farmajuy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


import fi.unju.farmajuy.entidades.Producto;


public class DetalleProductoActivity extends AppCompatActivity {

    TextView nombreProducto, drogaProducto, presentacionProducto, descripcionProducto;
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
        }

    }
}