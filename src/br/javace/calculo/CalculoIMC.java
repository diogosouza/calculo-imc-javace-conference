package br.javace.calculo;

import roboguice.inject.InjectResource;

public class CalculoIMC {

	@InjectResource(R.string.resultado) private String resultado;
	
	public double calculaIMC(double peso, double altura) {
		return peso/(altura * altura);
	}
	
	public String analisaIMC(double imc) {
		String retorno = null;
		if (imc > 30) {
			retorno = "Obesidade";
		} else if (imc > 25) {
			retorno = "Acima do peso";
		} else if (imc > 18.5) {
			retorno = "Peso normal";
		} else {
			retorno = "Abaixo do normal";
		}
		
		return resultado + " " + retorno;
	}

}
