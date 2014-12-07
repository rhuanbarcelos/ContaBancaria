package Cliente;
import Excecao.*;

import java.util.regex.Matcher;  
import java.util.regex.Pattern; 

public class Pessoa{
    
    private String nome;
    private String telefone;

    public Endereco end = new Endereco();
   
    // construtor
    public Pessoa(){}
    
    public String getNome() {
        return nome;
    }

    // faz a validação do Nome
    // testando se ele está em branco e se foi digitado algum numero ou algum caracter especial
    public void setNome(String nome) throws ExcecaoNome{
    	if(nome.isEmpty())
    	{   
    		throw new ExcecaoNome();
        }  
            
    	else
    	{  
            Pattern pattern = Pattern.compile("[0-9,#,*,@,%,$,!,(,),+,?,=]");  
            Matcher matcher = pattern.matcher(nome);  
            if(matcher.find())
            {  
            	throw new ExcecaoNome();
            }  
        }  
            this.nome = nome;
    }  

    public String getTelefone() {
        return telefone;
    }

    // faz a validação do Telefone
    // testando se ele está em branco ou se foi digitado algum caracter diferente de numeros
    // e se possui no mínimo 8 digitos
    public void setTelefone(String telefone) throws ExcecaoTelefone {
    	if(telefone.isEmpty())
    	{
    		throw new ExcecaoTelefone();
    	}
    	else
    	{
    		if(telefone.length()<8)
    		{
    			throw new ExcecaoTelefone();
    		}
    		else
    		{
    			Pattern pattern2 = Pattern.compile("[a-z,#,*,@,%,$,!,(,),+,?,=]");  
    			Matcher matcher = pattern2.matcher(telefone);  
    			if(matcher.find()){  
    				throw new ExcecaoTelefone();
    			}
    			else
    			{	
    				this.telefone = telefone;
    			}
    		}
    	}
    }
}
