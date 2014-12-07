package Cliente;
import Excecao.*;


public class ContaCorrente extends Conta{
    
	private String nconta;
	
	public ContaCorrente(){}
    
    public String getNconta() {
        return nconta;
    }
    
	public void setNconta(String nconta) throws ExcecaoCC{
    if(nconta.length() == 6)
    {
    	this.nconta = nconta;
    }
    else
    {
    	throw new ExcecaoCC();
    }
}
}