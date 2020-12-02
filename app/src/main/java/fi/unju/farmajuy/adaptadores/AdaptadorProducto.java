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

import fi.unju.farmajuy.DetalleProductoActivity;
import fi.unju.farmajuy.R;
import fi.unju.farmajuy.entidades.Producto;


public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ViewHolderProducto> {

    Context miContexto;
    ArrayList<Producto> listaProducto;

    public AdaptadorProducto(Context miContexto, ArrayList<Producto> listaProducto) {
        this.miContexto = miContexto;
        this.listaProducto = listaProducto;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto,null,false);
        return new ViewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {

        Producto producto = listaProducto.get(position);
        Glide.with(miContexto)
                .load(producto.getFoto())
                .centerCrop()
                .into(holder.imagenProducto);

        holder.nombreProducto.setText(producto.getNombre());

    }

    @Override
    public int getItemCount() {
        return listaProducto.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagenProducto;
        TextView nombreProducto;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);

            imagenProducto = itemView.findViewById(R.id.imageViewItemProducto);
            nombreProducto = itemView.findViewById(R.id.textViewNombreItemProducto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(miContexto, DetalleProductoActivity.class);
            intent.putExtra("claveProducto", listaProducto.get(getAdapterPosition()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            miContexto.startActivity(intent);
        }
    }
}
