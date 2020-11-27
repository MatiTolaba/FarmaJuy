package fi.unju.farmajuy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


import fi.unju.farmajuy.entidades.Medicamento;



public class DetalleMedicamentoActivity extends AppCompatActivity {

    TextView nombreMedicamento, drogaMedicamento, presentacionMedicamento, descripcionMedicamento;
    ImageView imagenMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_medicamento);

        nombreMedicamento = (TextView) findViewById(R.id.tvNombreMedicamento);
        drogaMedicamento = (TextView) findViewById(R.id.tvDrogaMedicamento);
        presentacionMedicamento = (TextView) findViewById(R.id.tvPresentacionMedicamento);
        descripcionMedicamento = (TextView) findViewById(R.id.tvDescripcionMedicamento);
        imagenMedicamento = (ImageView) findViewById(R.id.imageViewMedicamento);

        Medicamento medicamento = (Medicamento) getIntent().getSerializableExtra("claveMedicamento");

        if (medicamento != null){
            nombreMedicamento.setText(medicamento.getNombre());
            drogaMedicamento.setText(medicamento.getDroga());
            presentacionMedicamento.setText(medicamento.getPresentacion());
            descripcionMedicamento.setText(medicamento.getDescripcion());

            Glide.with(getApplicationContext())
                    .load(medicamento.getFoto())
                    .centerCrop()
                    .into(imagenMedicamento);
        }

    }
}