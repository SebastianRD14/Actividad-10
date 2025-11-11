package com.srd14.actividad10.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srd14.actividad10.R;
import com.srd14.actividad10.models.Photo;

import java.util.ArrayList;
import java.util.List;

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> {
    // Variables
    private List<Photo> photoList;
    private Context context;

    // Crear ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        ImageView thumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnailImage);
        }
    }
    // Listener de los thumbnails
    private OnThumbnailClickListener listener;


    // Interfaz para el listener
    public interface OnThumbnailClickListener {
        void onThumbnailClick(int position);
    }

    // Constructor
    public ThumbnailAdapter(Context context, List<Photo> photos, OnThumbnailClickListener listener) {
        this.context = context;
        this.photoList = (photos != null) ? photos : new ArrayList<>();
        this.listener = listener;
    }

    // Crear ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        return new ViewHolder(view);
    }


    // Asignar datos al ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = photoList.get(position);
        holder.thumbnail.setImageResource(photo.getImageId());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onThumbnailClick(position);
            }
        });
    }

    // Obtener el tamaño de la lista
    @Override
    public int getItemCount() {
        return photoList.size();
    }

}

