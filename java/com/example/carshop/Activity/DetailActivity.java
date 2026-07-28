package com.example.carshop.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.carshop.Domain.CarDomain;
import com.example.carshop.R;
import com.example.carshop.databinding.ActivityDetailBinding;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    CarDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVarible();
    }

    private void setVarible() {
        binding.backBtn.setOnClickListener(v -> finish());

        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.totalCapacityTxt.setText(object.getTotalCapacity());
        binding.highestspeedTxt.setText(object.getHighestSpeed());
        binding.engineOutputTxt.setText(object.getEngineOutput());
        binding.priceTxt.setText("$"+ NumberFormat.getNumberInstance(Locale.US).format(object.getPrice()));
        binding.ratingTxt.setText(String.valueOf(object.getRating()));

        Glide.with(DetailActivity.this)
                .load(object.getPicUrl())
                .into(binding.pic);
    }

    private void getIntentExtra() {
object = (CarDomain) getIntent().getSerializableExtra("object");
    }
}