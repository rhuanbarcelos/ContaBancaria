package Cliente;
import Excecao.*;

public class Endereco {
		
	 private String cidade;
	 private String estado;

	    public String getCidade() {
		return cidade;
	    }
			
	    public void setCidade(String cidade) throws ExcecaoCidade{
		if(cidade.length()<3)
	    	{   
	            throw new ExcecaoCidade();
		}     
		else
		{  
	            this.cidade = cidade;
		}  
	    }
			
		public String getEstado() {
	            return estado;
		}
			
		public void setEstado(Object estado2) throws ExcecaoEstado
        {
            if(((String) estado2).length()==2)
	    {   
            	this.estado = (String) estado2;
	    }     
            else
	    {  
	    	throw new ExcecaoEstado();
	    }  
	}
		
	}