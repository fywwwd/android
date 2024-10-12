package com.example.android_lab3;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button; // Импортируем Button
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast; // Импортируем Toast

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView sandwichImage; // Изображение сэндвича
    private TextView sandwichText; // Текст для сэндвича

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Настройка отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация виджетов
        editText = findViewById(R.id.editText);
        sandwichImage = findViewById(R.id.imageView_sandwich);
        sandwichText = findViewById(R.id.textView_sandwich);

        // Инициализация кнопки и установка слушателя
        Button cucumberButton = findViewById(R.id.button_cucumber);
        cucumberButton.setOnClickListener(v -> {
            // Показываем уведомление
            Toast.makeText(MainActivity.this, "К сожалению, огурцы закончились", Toast.LENGTH_SHORT).show();
        });

        // Обработчик событий для editText
        editText.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                String input = editText.getText().toString().trim();
                if ("да".equalsIgnoreCase(input)) {
                    // Установить изображение и изменить его размеры
                    sandwichImage.setVisibility(View.VISIBLE);
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                            (int) (getResources().getDrawable(R.drawable.butterbread).getIntrinsicWidth() / 4),
                            (int) (getResources().getDrawable(R.drawable.butterbread).getIntrinsicHeight() / 4)
                    );
                    params.addRule(RelativeLayout.CENTER_IN_PARENT);
                    sandwichImage.setLayoutParams(params);
                    sandwichImage.setImageResource(R.drawable.butterbread);
                }
                return true; // Пакетируем обработку события
            }
            return false;
        });
    }
}
