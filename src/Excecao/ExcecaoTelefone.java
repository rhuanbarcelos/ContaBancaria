package Excecao;

public class ExcecaoTelefone extends Exception{
    public String telefoneDigitado()
    {
        return "Telefone inv�lido. Possui letras ou caracteres especiais.";
    }
    
}