package fi.unju.farmajuy.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fi.unju.farmajuy.DetalleMedicamentoActivity;
import fi.unju.farmajuy.R;
import fi.unju.farmajuy.entidades.DetalleMedicamento;
import fi.unju.farmajuy.entidades.Medicamento;


public class AdaptadorMedicamento extends RecyclerView.Adapter<AdaptadorMedicamento.ViewHolderMedicamento> {

    Context miContexto;
    ArrayList<Medicamento> listaMedicamento;

    public AdaptadorMedicamento(Context miContexto, ArrayList<Medicamento> listaMedicamento) {
        this.miContexto = miContexto;
        this.listaMedicamento = listaMedicamento;
    }

    @NonNull
    @Override
    public ViewHolderMedicamento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicamento,null,false);
        return new ViewHolderMedicamento(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMedicamento holder, int position) {
//        holder.asignarMedicamentos(listaMedicamento.get(position));

        Medicamento medicamento = listaMedicamento.get(position);
        Glide.with(miContexto)
                .load(medicamento.getFoto())
                .centerCrop()
                .into(holder.imagenMedicamento);

        holder.nombreMedicamento.setText(medicamento.getNombre());

    }

    @Override
    public int getItemCount() {
        return listaMedicamento.size();
    }

    public class ViewHolderMedicamento extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagenMedicamento;
        TextView nombreMedicamento;

        public ViewHolderMedicamento(@NonNull View itemView) {
            super(itemView);

            imagenMedicamento = itemView.findViewById(R.id.imageViewItemMedicamento);
            nombreMedicamento = itemView.findViewById(R.id.textViewNombreItemMedicamento);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(miContexto, DetalleMedicamentoActivity.class);
            intent.putExtra("claveMedicamento", listaMedicamento.get(getAdapterPosition()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            miContexto.startActivity(intent);
        }


//        public void asignarMedicamentos(Medicamento medicamento) {
//            //imagenMedicamento.setImageURI(medicamento.getFoto());
//
//            Glide.with(miContexto)
//                    .load(medicamento.getFoto())
//                    .into(holder.imageView);
//
//            nombreMedicamento.setText(medicamento.getNombre());
//        }
    }
}
