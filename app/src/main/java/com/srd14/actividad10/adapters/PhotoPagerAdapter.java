package com.srd14.actividad10.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.srd14.actividad10.R;
import com.srd14.actividad10.models.Photo;

import java.util.List;

public class PhotoPagerAdapter extends RecyclerView.Adapter<PhotoPagerAdapter.ViewHolder> {
    private List<Photo> photos;
    private Context context;


    // Constructor
    public PhotoPagerAdapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }

    @NonNull
    @Override
    // Crear ViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo_card, parent, false);
        return new ViewHolder(view);

    }

    // Asignar datos al ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = photos.get(position);
        holder.imageView.setImageResource(photo.getImageId());
        holder.titleText.setText(photo.getTitle());
        holder.descText.setText(photo.getDescription());
        holder.dateText.setText(photo.getDate());
    }

    // Obtener el tamaño de la lista
    @Override
    public int getItemCount() {
        return photos.size();
    }


    // Configurar ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, descText, dateText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.Titulo);
            descText = itemView.findViewById(R.id.Descripcion);
            dateText = itemView.findViewById(R.id.fecha);
        }
    }

}
