package com.example.jose.miprimeraaplicacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mCalculo;
    Button mBotonDuplicar;
    Button mBotonDividir;
    Button mbotonLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Carga el recurso layout con todos los componentes del interface de la activity.
        setContentView(R.layout.layout_main);

        // Creación de referencias a los views

        mCalculo = findViewById(R.id.txvValorCalculo);
        mBotonDuplicar = findViewById(R.id.btMultiplica);
        mBotonDividir = findViewById(R.id.btDivide);
        mbotonLimpiar = findViewById(R.id.btLimpiar);

        // Implementación de listerners para recoger eventos sobre los
        // views anteriores

        mBotonDuplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duplicar();
            }
        });
        mBotonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dividir();
            }
        });
        mbotonLimpiar.setOnClickListener(new View.OnClickListener() {
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

            if (valor  == 1) return; // No hacemos nada si el contador es 1.


            // Actualiza contador con su valor dividico entre 2.

            mCalculo.setText(String.valueOf(valor/=2));

            // Deshabilita botón si después de dividir el contador es 1.
            mBotonDividir.setEnabled(valor > 1);

            // Puede que el botón multiplicar estuviera deshabilitado.
            // Me aseguro de habilitarlo nuevamente
            if(!mBotonDuplicar.isEnabled())
                mBotonDuplicar.setEnabled(true);

        } catch (NumberFormatException e) {
            Log.e("MiAplicacion", "Error al convertir el valor en un entero", e);
        }
    }

    void duplicar() {
        int valor;
        try {
            valor = Integer.parseInt(mCalculo.getText().toString());

            // Actualiza contador con su valor duplicado

            mCalculo.setText(String.valueOf(valor*=2));

            // Si el próximo duplicado del contador excediera el rango del tipo int,
            // entonces deshabilita el boton duplicar.
            // Ojo: lo multiplicamos con un 2 de tipo long por si se pasa de rango de int
            // la expresión valor*2L devuelva el valor en un long.

            mBotonDuplicar.setEnabled(valor*2L <= Integer.MAX_VALUE);

            // Si el botón dividir estaba deshabilidato lo habilita.

            if(!mBotonDividir.isEnabled())
                mBotonDividir.setEnabled(true);

        } catch (NumberFormatException e) {
            Log.e("MiAplicacion", "Error al convertir el valor en un entero", e);
        }
    }

    void resetear() {
        mCalculo.setText("1");
        mBotonDuplicar.setEnabled(true);
        mBotonDividir.setEnabled(false);
    }
}
