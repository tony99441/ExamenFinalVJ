package com.example.finalvjbrionesquiroz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterLibro extends RecyclerView.Adapter<AdapterLibro.viewLibro> {
    private final List<Libro> list;
    private final Context mContext;

    public AdapterLibro(List<Libro> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public AdapterLibro.viewLibro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewLibro(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_libro,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLibro.viewLibro holder, int position) {
        Libro libro = list.get(position);
        Picasso.get().load("https://upn.lumenes.tk/"+libro.getUrl_imagen()).into(holder.image_libro);
        holder.text_libro.setText(libro.getNombre());
        holder.text_libro.setText(libro.getVistas());

       //String ID = String.valueOf(libro.getId());

        holder.btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,LibroDetalleActivity.class);

            //   intent.putExtra("ID", ID);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class viewLibro extends RecyclerView.ViewHolder {
        ImageView image_libro;
        TextView text_libro, getText_libro;
        CardView card_click;
        Button btnDetalle;

        public viewLibro(@NonNull View itemView) {
            super(itemView);

            image_libro = itemView.findViewById(R.id.image_libro);
            text_libro = itemView.findViewById(R.id.text_libro);
            text_libro = itemView.findViewById(R.id.text_description);
            card_click = itemView.findViewById(R.id.card_click);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);


        }
    }
}
