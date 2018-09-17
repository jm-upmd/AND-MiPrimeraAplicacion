package com.example.jose.miprimeraaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Atributos de clase
    TextView mCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creación de referencias a los views

        mCalculo = findViewById(R.id.txvValorCalculo);
        Button botonDuplicar = findViewById(R.id.btMultiplica);
        Button botonDividir = findViewById(R.id.btDivide);
        Button botonLimpiar = findViewById(R.id.btLimpiar);

        // Implementación de listerners para recoger eventos sobre los
        // views anteriores

        botonDuplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duplicar();
            }
        });

        botonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dividir();
            }
        });

        botonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetear();
            }
        });
    }

    private void dividir() {
        int valor;
        try {
            valor = Integer.parseInt(mCalculo.getText().toString());
            // Si valor es 1 lo deja tal cual
            valor = valor == 1 ? valor : valor/2;
            mCalculo.setText(String.valueOf(valor));
        } catch (NumberFormatException e){
            Log.e("MiAplicacion", "Error al convertir el valor en un entero",e);
        }
    }

    void duplicar(){
        int valor;
        try {
            valor = Integer.parseInt(mCalculo.getText().toString());
            valor *= 2;
            mCalculo.setText(String.valueOf(valor));
        } catch (NumberFormatException e){
            Log.e("MiAplicacion", "Error al convertir el valor en un entero",e);
        }

    }

    void resetear(){
        mCalculo.setText("1");
    }
}
