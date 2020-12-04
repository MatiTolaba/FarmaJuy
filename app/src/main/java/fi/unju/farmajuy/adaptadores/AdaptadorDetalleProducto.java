package fi.unju.farmajuy.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fi.unju.farmajuy.R;

import fi.unju.farmajuy.entidades.Farmacia;

public class AdaptadorDetalleProducto extends RecyclerView.Adapter<AdaptadorDetalleProducto.ViewHolderDetalleProducto>{

    Context miContexto;
    ArrayList<Farmacia> listaFarmaciasConStock;
    Double precioProducto;

    public AdaptadorDetalleProducto(Context miContexto, ArrayList<Farmacia> listaFarmaciasConStock, Double precioProducto) {
        this.miContexto = miContexto;
        this.listaFarmaciasConStock = listaFarmaciasConStock;
        this.precioProducto = precioProducto;
    }

    @NonNull
    @Override
    public AdaptadorDetalleProducto.ViewHolderDetalleProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmacia,null,false);
        return new AdaptadorDetalleProducto.ViewHolderDetalleProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetalleProducto.ViewHolderDetalleProducto holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaFarmaciasConStock.size();
    }

    public class ViewHolderDetalleProducto extends RecyclerView.ViewHolder {

        ImageView imagenFarmacia;
        TextView nombreFarmacia;

        public ViewHolderDetalleProducto(@NonNull View itemView) {
            super(itemView);

            imagenFarmacia = itemView.findViewById(R.id.imageViewFarmacia);
            nombreFarmacia = itemView.findViewById(R.id.textViewNombreFarmacia);
        }
    }
}
