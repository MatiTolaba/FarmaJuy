package fi.unju.farmajuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fi.unju.farmajuy.entidades.Medicamento;
import fi.unju.farmajuy.adaptadores.AdaptadorMedicamento;

import java.util.ArrayList;

public class MedicamentoActivity extends AppCompatActivity {

    //TextView pruebaDroga;
    RecyclerView recyclerViewMedicamentos;
    ArrayList<Medicamento> medicamentos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle medicamentoActivityBundle = this.getIntent().getExtras();

        setContentView(R.layout.activity_medicamento);

        if (medicamentoActivityBundle != null){

            medicamentos = (ArrayList<Medicamento>) medicamentoActivityBundle.getSerializable("listaMedicamentos");

            recyclerViewMedicamentos = (RecyclerView) findViewById(R.id.recyclerViewItemsMedicamento);
            recyclerViewMedicamentos.setLayoutManager( new LinearLayoutManager(this));

            AdaptadorMedicamento adaptadorMedicamento = new AdaptadorMedicamento(this, medicamentos);
            recyclerViewMedicamentos.setAdapter(adaptadorMedicamento);
        }

    }
}