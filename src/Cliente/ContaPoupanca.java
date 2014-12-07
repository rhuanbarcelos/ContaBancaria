package Cliente;
import Excecao.*;


public class ContaPoupanca extends Conta{
    
	
	private String nconta;

	public ContaPoupanca(){}
    
    public String getNconta() {
        return nconta;
    }
    
	public void setNconta(String nconta) throws ExcecaoCP{
    if(nconta.length() == 4)
    {
    	this.nconta = nconta;
    }
    else
    {
    	throw new ExcecaoCP();
    }
} 
}
