package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fi.unju.farmajuy.entidades.Producto;
import fi.unju.farmajuy.adaptadores.AdaptadorProducto;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductos;
    ArrayList<Producto> productos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle productoActivityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_producto);

        if (productoActivityBundle != null){

            productos = (ArrayList<Producto>) productoActivityBundle.getSerializable("listaProductos");

            recyclerViewProductos = (RecyclerView) findViewById(R.id.recyclerViewItemsProducto);
            recyclerViewProductos.setLayoutManager( new LinearLayoutManager(this));

            AdaptadorProducto adaptadorProducto = new AdaptadorProducto(this, productos);
            recyclerViewProductos.setAdapter(adaptadorProducto);
        }

    }
}