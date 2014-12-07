package Cliente;
import Excecao.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private String ie;
	
	public PessoaJuridica(){}

	public String getCnpj() {
		return cnpj;
	}
	
	
	public boolean setCnpj(String cnpj) throws ExcecaoCNPJ {
		int soma = 0, dig;  
	       String cnpj_calc = cnpj.substring(0,12);  
	  boolean ret = false;
	       if ( cnpj.length() != 14 )  
	         return false;  
	  
	       char[] chr_cnpj = cnpj.toCharArray(); 
	      
	       
	       /* Primeira parte */  
	       for( int i = 0; i < 4; i++ ) 
	       {
	         if ( chr_cnpj(i)-48 >=0 && chr_cnpj(i)-48 <=9 )  
	           soma += (chr_cnpj(i) - 48 ) * (6 - (i + 1)) ;  
	       }
	       for( int i = 0; i < 8; i++ )  
	       {
	         if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )  
	           soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;  
	       }
	       dig = 11 - (soma % 11);  
	  
	       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
	                      "0" : Integer.toString(dig);  
	  
	       /* Segunda parte */  
	       soma = 0;  
	       for ( int i = 0; i < 5; i++ )  
	       {
	         if ( chr_cnpj(i)-48 >=0 && chr_cnpj(i)-48 <=9 )  
	           soma += (chr_cnpj(i) - 48 ) * (7 - (i + 1)) ;  
	       }
	       for ( int i = 0; i < 8; i++ )  
	       {
	         if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )  
	           soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;  
	       }
	       dig = 11 - (soma % 11);  
	       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
	                      "0" : Integer.toString(dig);  
		      if( ret == true){
					this.cnpj = cnpj;
			}
				else{
					throw new ExcecaoCNPJ();
				}	
	       return cnpj.equals(cnpj_calc);  
}

	private int chr_cnpj(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getIe() {
		return ie;
	}
	
	// deve conter 8 digitos e ser somente numeros
	public void setIe(String ie) throws ExcecaoIE {
		if(ie.isEmpty())
    	{
			throw new ExcecaoIE();
    	}
    	else
    	{
    		if(ie.length()!=8)
    		{
    			throw new ExcecaoIE();
    		}
    		else
    		{
    			Pattern pattern2 = Pattern.compile("[a-z,#,*,@,%,$,!,(,),+,?,=]");  
    			Matcher matcher = pattern2.matcher(ie);  
    			if(matcher.find()){  
    				throw new ExcecaoIE();
    			}
    			else
    			{	
    				this.ie = ie;
    			}
    		}
	}
	}
}// Fecha o programa.