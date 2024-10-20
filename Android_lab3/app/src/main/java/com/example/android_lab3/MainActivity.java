package com.example.android_lab3;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView sandwichImage;
    private TextView sandwichText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editText);
        sandwichImage = findViewById(R.id.imageView_sandwich);
        sandwichText = findViewById(R.id.textView_sandwich);

        Button cucumberButton = findViewById(R.id.button_cucumber);
        cucumberButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "К сожалению, огурцы закончились", Toast.LENGTH_SHORT).show();
        });

        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                String input = editText.getText().toString().trim();
                if ("да".equalsIgnoreCase(input)) {
                    sandwichImage.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                            (int) (getResources().getDrawable(R.drawable.butterbread).getIntrinsicWidth() / 4),
                            (int) (getResources().getDrawable(R.drawable.butterbread).getIntrinsicHeight() / 4)
                    );
                    params.addRule(RelativeLayout.CENTER_IN_PARENT);
                    sandwichImage.setLayoutParams(params);
                    sandwichImage.setImageResource(R.drawable.butterbread);
                }
                return true;
            }
            return false;
        });
    }
}
