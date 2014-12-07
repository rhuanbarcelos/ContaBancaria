package Cliente;
import Excecao.*;

public abstract class Conta {
    
    private String nconta;
    private double saldo;

    public abstract void setNconta(String nconta) throws ExcecaoCC, ExcecaoCP; 

    public String getNconta() {
        return nconta;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo <= 0)
        {
            System.out.println("Valor inválido. Saldo da conta não pode ser negativo.");
        }
        else
        {
            this.saldo = saldo;
        }
    }
    
        public void debitar(String nconta, float valor)
    {
        saldo = saldo + valor;
    }
    
    public double creditar(double saldo2, double valor)
    {
        return saldo = saldo - valor;
    }
        
   }