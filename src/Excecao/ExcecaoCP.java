package Excecao;

public class ExcecaoCP extends Exception{
	public String ncontaDigitado()
	{
		return "Conta inválida. A conta poupança deve conter 4 dígitos.";
	}

}
