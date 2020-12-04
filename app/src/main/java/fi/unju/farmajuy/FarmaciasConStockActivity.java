package fi.unju.farmajuy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.unju.farmajuy.adaptadores.AdaptadorDetalleProducto;
import fi.unju.farmajuy.adaptadores.AdaptadorProducto;
import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.entidades.Producto;

public class FarmaciasConStockActivity extends AppCompatActivity {

    RecyclerView recyclerViewFarmacias;
    ArrayList<Farmacia> farmaciasConStock;
    Double precioProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle activityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_farmacia);

        if (activityBundle != null){

            farmaciasConStock = (ArrayList<Farmacia>) activityBundle.getSerializable("listaProductos");
            precioProducto = activityBundle.getDouble("precioProducto");

            recyclerViewFarmacias = (RecyclerView) findViewById(R.id.recyclerViewFarmaciasConStock);
            recyclerViewFarmacias.setLayoutManager( new LinearLayoutManager(this));

            AdaptadorDetalleProducto adaptadorDetalleProducto = new AdaptadorDetalleProducto(this, farmaciasConStock, precioProducto);
            recyclerViewFarmacias.setAdapter(adaptadorDetalleProducto);
        }

    }
}
