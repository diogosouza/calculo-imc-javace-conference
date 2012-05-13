package br.javace.calculo;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.inject.Inject;

@ContentView(R.layout.main)
public class CalculoIMCActivity extends RoboActivity {
	@InjectView(R.id.edtPeso) private EditText edtPeso;
	@InjectView(R.id.edtAltura) private EditText edtAltura;
	@InjectView(R.id.txtResultado) private TextView txtResultado;
	@InjectView(R.id.txtInfoDados) private TextView txtInfoDados;
	@InjectView(R.id.btnCalcular) private Button btnCalcular;
	@Inject private CalculoIMC calculoIMC;
	
	@InjectResource(R.string.info_dados) private String infoDados;
	
	@InjectExtra("nome") private String extraNome;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        txtInfoDados.setText(extraNome + ", " + infoDados);
        
        btnCalcular.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				double peso = Double.parseDouble(edtPeso.getText().toString());
				double altura = Double.parseDouble(edtAltura.getText().toString());
				txtResultado.setText(calculoIMC.analisaIMC(calculoIMC.calculaIMC(peso, altura)));
			}
		});
    }
}