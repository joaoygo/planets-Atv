package com.example.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsPlanetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_planets);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String planetName = extras.getString("planeta_nome");
            String planetDescription = extras.getString("planeta_descricao");
            int planetImage = extras.getInt("planeta_imagem");

            // Agora você pode exibir esses dados na interface do usuário da DetailsPlanetsActivity
            TextView nameTextView = findViewById(R.id.textViewTitleDetails);
            TextView descriptionTextView = findViewById(R.id.textViewDescriptionDetails);
            ImageView imageView = findViewById(R.id.imageViewDetails);

            nameTextView.setText(planetName);
            descriptionTextView.setText(planetDescription);
            imageView.setImageResource(planetImage);
        }
    }
}