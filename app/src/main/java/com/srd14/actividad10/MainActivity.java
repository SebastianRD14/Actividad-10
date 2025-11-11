package com.srd14.actividad10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.srd14.actividad10.adapters.ThumbnailAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.srd14.actividad10.adapters.PhotoPagerAdapter;
import com.srd14.actividad10.models.Photo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    TextView indicatorText;
    Button btnPrev, btnNext, btnHome;
    PhotoPagerAdapter adapter;
    List<Photo> photoList;
    int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Vincular los ID de los elementos de la interfaz
        viewPager = findViewById(R.id.viewpager);
        RecyclerView recyclerThumbnails = findViewById(R.id.thumbnail);

        indicatorText = findViewById(R.id.indicador);
        btnPrev = findViewById(R.id.bttnVolver);
        btnNext = findViewById(R.id.bttnSiguiente);
        btnHome = findViewById(R.id.bttnHome);


        // Crear lista de fotos
        photoList = new ArrayList<>();
        photoList.add(new Photo(R.drawable.foto1, "Nueva aventura", "Goku viaja junto a bulma por la esferas del dragon","10/01/1986"));
        photoList.add(new Photo(R.drawable.foto2, "La derrota del mal", "Goku derrota al rey demonio piccolo","10/08/1988"));
        photoList.add(new Photo(R.drawable.foto3, "Espiritu inquebrantable","Goku se prepara para derrotar a Majunior hijo de piccolo","02/02/1989"));
        photoList.add(new Photo(R.drawable.foto4, "El inicio de la rivalidad", "Goku se prepara para pelear contra Vegeta el principe de los saiyans","10/11/1989"));
        photoList.add(new Photo(R.drawable.foto5, "La leyenda despierta","Goku se transforma en super saiyan pro primera vez y se enfrenta al emperador Frezzer","07/08/1991"));


        // Crear adaptador del Thumbnail
        ThumbnailAdapter thumbnailAdapter = new ThumbnailAdapter(this, photoList, position -> {
            viewPager.setCurrentItem(position, true);
        });

        recyclerThumbnails.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        recyclerThumbnails.setAdapter(thumbnailAdapter);

        // Configurar adaptador del ViewPager
        PhotoPagerAdapter adapter = new PhotoPagerAdapter(this, photoList);
        viewPager.setAdapter(adapter);


        // Actualizar indicador
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                indicatorText.setText((position + 1) + " / " + photoList.size());
            }
        });

        // Funcionalidad de los botones
        btnNext.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() < photoList.size() - 1)
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        });

        btnPrev.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() > 0)
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        });

        btnHome.setOnClickListener(v -> {
            viewPager.setCurrentItem(0);
        });
    }
}


