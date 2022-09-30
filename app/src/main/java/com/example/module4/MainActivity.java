package com.example.module4;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.module4.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        ExtendedFloatingActionButton copyButton = findViewById(R.id.floatingActionButton);
        copyButton.setOnClickListener( event -> {
            EditText userInput = findViewById(R.id.textToCopy);
            TextView displayText = findViewById(R.id.textView);
            TextInputLayout layout = findViewById(R.id.input);

            if ( userInput.getText().toString().trim().equals("") ) {
                displayText.setText(getString(R.string.copiedText));
                layout.setHint(getString(R.string.textToCopy));
            } else {
                layout.setHint("You typed: " + userInput.getText());
                displayText.setText(userInput.getText());
            }
        });

    }
}