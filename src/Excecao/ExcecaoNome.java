package Excecao;
public class ExcecaoNome extends Exception{
   public String nomeDigitado()
   {
       return "Nome inv�lido. Possui caracteres especiais ou n�meros.";
   }
}