package com.example.android_lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView[] bookSpines = new ImageView[6];
    private ImageView[] bookFronts = new ImageView[6];
    private View[] bookFrontPlaceholders = new View[6];
    private boolean[] isBookVisible = new boolean[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 6; i++) {
            int spineId = getResources().getIdentifier("shelf" + (i + 1), "id", getPackageName());
            ConstraintLayout shelfLayout = findViewById(spineId);

            bookSpines[i] = shelfLayout.findViewById(R.id.bookSpine);
            bookFronts[i] = shelfLayout.findViewById(R.id.bookFront);
            bookFrontPlaceholders[i] = shelfLayout.findViewById(R.id.bookFrontInvisible);
            isBookVisible[i] = true;

            Button toggleButton = shelfLayout.findViewById(R.id.toggleButton);
            final int index = i;
            toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleBookVisibility(index);
                }
            });
        }
    }

    private void toggleBookVisibility(int index) {
        if (isBookVisible[index]) {
            bookSpines[index].setVisibility(View.GONE);
            bookFronts[index].setVisibility(View.GONE);
            bookFrontPlaceholders[index].setVisibility(View.VISIBLE);
        } else {
            bookSpines[index].setVisibility(View.VISIBLE);
            bookFronts[index].setVisibility(View.VISIBLE);
            bookFrontPlaceholders[index].setVisibility(View.GONE);
        }
        isBookVisible[index] = !isBookVisible[index];
    }
}
