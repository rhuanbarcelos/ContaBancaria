package Excecao;

public class ExcecaoTelefone extends Exception{
    public String telefoneDigitado()
    {
        return "Telefone inválido. Possui letras ou caracteres especiais.";
    }
    
}