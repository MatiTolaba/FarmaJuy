package fi.unju.farmajuy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import fi.unju.farmajuy.entidades.Farmacia;

public class DetalleFarmaciaActivity extends AppCompatActivity {

    TextView nombreFarmacia, direccionFarmacia, horarioFarmacia, telefonoFarmacia;
    ImageView imagenFarmacia;

    Farmacia farmacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_farmacia);

        nombreFarmacia = (TextView) findViewById(R.id.tvNombreFarmacia);
        direccionFarmacia = (TextView) findViewById(R.id.tvDireccionFarmacia);
        horarioFarmacia = (TextView) findViewById(R.id.tvHorarioFarmacia);
        telefonoFarmacia = (TextView) findViewById(R.id.tvTelefonoFarmacia);
        imagenFarmacia = (ImageView) findViewById(R.id.imageViewFarmacia);

        farmacia = (Farmacia) getIntent().getSerializableExtra("claveFarmacia");

        if (farmacia != null){
            nombreFarmacia.setText(farmacia.getNombre());
            direccionFarmacia.setText(farmacia.getDireccion());
            horarioFarmacia.setText(farmacia.getHorario());
            telefonoFarmacia.setText(farmacia.getTelefono());

            Glide.with(getApplicationContext())
                    .load(farmacia.getFoto())
                    .centerCrop()
                    .into(imagenFarmacia);
        }
    }
}
