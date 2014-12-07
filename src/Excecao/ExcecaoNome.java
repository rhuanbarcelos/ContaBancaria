package Excecao;
public class ExcecaoNome extends Exception{
   public String nomeDigitado()
   {
       return "Nome inválido. Possui caracteres especiais ou números.";
   }
}