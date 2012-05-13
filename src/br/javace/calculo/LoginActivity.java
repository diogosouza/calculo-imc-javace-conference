package br.javace.calculo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	private static final String SENHA = "admin";
	
	private EditText edtLogin;
	private EditText edtSenha;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        Button login = (Button) findViewById(R.id.logar);
        login.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (SENHA.equals(edtSenha.getText().toString())) {
					Intent intent = new Intent(getApplicationContext(), CalculoIMCActivity.class);
					intent.putExtra("nome", edtLogin.getText().toString());
					startActivity(intent);
				} else {
					Toast.makeText(LoginActivity.this, getString(R.string.senha_invalida), Toast.LENGTH_LONG).show();
				}
			}
		});
    }

}