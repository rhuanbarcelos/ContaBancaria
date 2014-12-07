package Excecao;

public class ExcecaoCC extends Exception{
	public String ncontaDigitado()
	{
		return "Conta inválida. A conta corrente deve conter 6 dígitos.";
	}

}
