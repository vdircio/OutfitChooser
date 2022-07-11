package com.example.outfitchooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView hatImage, topImage, bottomImage, shoesImage;
    Button hatPrev, hatNext, topPrev, topNext, bottomPrev, bottomNext, shoesPrev, shoesNext;
    int hatIndex, topIndex, bottomIndex, shoesIndex = 0;
    public int [] hatArray = {R.drawable.cap, R.drawable.buckethat, R.drawable.truckerhat};
    private int [] topArray = {R.drawable.tanktop, R.drawable.flannel};
    private int [] bottomArray = {R.drawable.jeans, R.drawable.joggers};
    private int [] shoesArray = {R.drawable.convers, R.drawable.loafers};

    private Spinner spinner;

    private BottomSheetBehavior bottomSheetBehavior;

    Button addHatButton, addTopButton, addBottomButton, addShoesButton;
    TextView hatText, topText, bottomText, shoesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hatImage = findViewById(R.id.hatImageView);
        hatPrev = findViewById(R.id.backButtonHat);
        hatNext = findViewById(R.id.nextButtonHat);
        topImage = findViewById(R.id.topImageView);
        topPrev = findViewById(R.id.backButtonTop);
        topNext = findViewById(R.id.nextButtonTop);
        bottomImage = findViewById(R.id.bottomImageView);
        bottomPrev = findViewById(R.id.backButtonBottom);
        bottomNext = findViewById(R.id.nextButtonBottom);
        shoesImage = findViewById(R.id.shoesImageView);
        shoesPrev = findViewById(R.id.backButtonShoes);
        shoesNext = findViewById(R.id.nextButtonShoes);
        spinner = findViewById(R.id.dropdownmenu);

        addHatButton = findViewById(R.id.addHat);
        addTopButton = findViewById(R.id.addTop);
        addBottomButton = findViewById(R.id.addBottom);
        addShoesButton = findViewById(R.id.addShoes);
        hatText = findViewById(R.id.addHatText);
        topText = findViewById(R.id.addTopText);
        bottomText = findViewById(R.id.addBottomText);
        shoesText = findViewById(R.id.addBottomText);



        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        hatPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatImage.setImageResource(hatArray[hatIndex % 3]);
                hatIndex--;
            }
        });
        hatNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hatImage.setImageResource(hatArray[hatIndex % 3]);
                hatIndex++;
            }
        });

        topPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topImage.setImageResource(topArray[topIndex % 3]);
                topIndex--;
            }
        });
        topNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topImage.setImageResource(topArray[topIndex % 3]);
                topIndex++;
            }
        });

        bottomPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomImage.setImageResource(bottomArray[bottomIndex % 3]);
                bottomIndex--;
            }
        });
        bottomNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomImage.setImageResource(bottomArray[bottomIndex % 3]);
                bottomIndex++;
            }
        });

        shoesPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesImage.setImageResource(shoesArray[shoesIndex % 3]);
                shoesIndex--;
            }
        });
        shoesNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoesImage.setImageResource(shoesArray[shoesIndex % 3]);
                shoesIndex++;
            }
        });

        LinearLayout linearLayout = findViewById(R.id.new_images);
        bottomSheetBehavior = bottomSheetBehavior.from(linearLayout);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("Random")) {
            hatIndex = ThreadLocalRandom.current().nextInt(0, 3);
            hatImage.setImageResource(hatArray[hatIndex]);
            topIndex = ThreadLocalRandom.current().nextInt(0, 2);
            topImage.setImageResource(topArray[topIndex]);
            bottomIndex = ThreadLocalRandom.current().nextInt(0, 2);
            bottomImage.setImageResource(bottomArray[bottomIndex]);
            shoesIndex = ThreadLocalRandom.current().nextInt(0, 2);
            shoesImage.setImageResource(shoesArray[shoesIndex]);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
