package fi.unju.farmajuy.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fi.unju.farmajuy.R;

import fi.unju.farmajuy.entidades.Farmacia;
import fi.unju.farmajuy.entidades.Producto;

public class AdaptadorDetalleProducto extends RecyclerView.Adapter<AdaptadorDetalleProducto.ViewHolderDetalleProducto>{

    Context miContexto;
    ArrayList<Farmacia> listaFarmaciasConStock;
    ArrayList<Double> preciosProducto;

    public AdaptadorDetalleProducto(Context miContexto, ArrayList<Farmacia> listaFarmaciasConStock, ArrayList<Double> preciosProducto) {
        this.miContexto = miContexto;
        this.listaFarmaciasConStock = listaFarmaciasConStock;
        this.preciosProducto = preciosProducto;
    }

    @NonNull
    @Override
    public AdaptadorDetalleProducto.ViewHolderDetalleProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmacia,null,false);
        return new AdaptadorDetalleProducto.ViewHolderDetalleProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetalleProducto.ViewHolderDetalleProducto holder, int position) {

        Farmacia farmacia = listaFarmaciasConStock.get(position);
        Glide.with(miContexto)
                .load(farmacia.getFoto())
                .centerCrop()
                .into(holder.imagenFarmacia);

        holder.nombreFarmacia.setText(farmacia.getNombre());

        Double precioProducto = preciosProducto.get(position);

        holder.precioProducto.setText("$ "+precioProducto.toString());

    }

    @Override
    public int getItemCount() {
        return listaFarmaciasConStock.size();
    }

    public class ViewHolderDetalleProducto extends RecyclerView.ViewHolder {

        ImageView imagenFarmacia;
        TextView nombreFarmacia, precioProducto;

        public ViewHolderDetalleProducto(@NonNull View itemView) {
            super(itemView);

            imagenFarmacia = itemView.findViewById(R.id.imageViewFarmacia);
            nombreFarmacia = itemView.findViewById(R.id.textViewNombreFarmacia);
            precioProducto = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
