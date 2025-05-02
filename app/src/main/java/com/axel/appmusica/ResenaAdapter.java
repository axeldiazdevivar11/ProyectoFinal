package com.axel.appmusica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class ResenaAdapter extends BaseAdapter {

    private Context context;
    private List<Resena> resenas;

    public ResenaAdapter(Context context, List<Resena> resenas) {
        this.context = context;
        this.resenas = resenas;
    }

    @Override
    public int getCount() {
        return resenas.size();
    }

    @Override
    public Object getItem(int position) {
        return resenas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Si convertView es nulo, inflamos el layout del item
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_resena, parent, false);
        }

        // Obtener la reseña correspondiente
        Resena resena = resenas.get(position);

        // Configurar las vistas del item
        TextView textViewTitulo = convertView.findViewById(R.id.text_view_titulo);
        TextView textViewReseña = convertView.findViewById(R.id.text_view_resena);
        RatingBar ratingBar = convertView.findViewById(R.id.rating_bar);
        ImageView imageViewCancion = convertView.findViewById(R.id.image_view_cancion);

        textViewTitulo.setText(resena.getTituloCancion());
        textViewReseña.setText(resena.getReseña());
        ratingBar.setRating(resena.getCalificacion());
        imageViewCancion.setImageResource(resena.getImagenCancion());

        return convertView;
    }
}
