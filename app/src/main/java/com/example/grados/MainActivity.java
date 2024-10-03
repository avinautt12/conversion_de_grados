package com.example.grados;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGrados;
    private RadioGroup radioGroupGradosDe, radioGroupGradosA;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGrados = findViewById(R.id.editTextGrados);
        radioGroupGradosDe = findViewById(R.id.radioGroupGradosDe);
        radioGroupGradosA = findViewById(R.id.radioGroupGradosA);
        textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonConvertir = findViewById(R.id.buttonConvertir);

        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirGrados();
            }
        });
    }

    private void convertirGrados() {
        String input = editTextGrados.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Por favor, introduce un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        double grados = Double.parseDouble(input);

        int radioButtonDeId = radioGroupGradosDe.getCheckedRadioButtonId();
        int radioButtonAId = radioGroupGradosA.getCheckedRadioButtonId();

        if (radioButtonDeId == -1 || radioButtonAId == -1) {
            Toast.makeText(this, "Selecciona los tipos de conversión", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButtonDe = findViewById(radioButtonDeId);
        RadioButton radioButtonA = findViewById(radioButtonAId);

        String tipoDe = radioButtonDe.getText().toString();
        String tipoA = radioButtonA.getText().toString();

        double resultado = realizarConversion(grados, tipoDe, tipoA);

        textViewResultado.setText("Resultado: " + resultado);
    }

    private double realizarConversion(double grados, String tipoDe, String tipoA) {

        double gradosCelsius = 0;
        switch (tipoDe) {
            case "Celsius":
                gradosCelsius = grados;
                break;
            case "Fahrenheit":
                gradosCelsius = farenheit.toCelsius((int) grados);
                break;
            case "Kelvin":
                gradosCelsius = kelvin.toCelsius((int) grados);
                break;
        }

        switch (tipoA) {
            case "Celsius":
                return gradosCelsius;
            case "Fahrenheit":
                return celsius.toFahrenheit((int) gradosCelsius);
            case "Kelvin":
                return celsius.toKelvin((int) gradosCelsius);
        }
        return 0;
    }

}