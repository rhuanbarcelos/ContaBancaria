package Cliente;
import Excecao.*;

public interface OpConta {
	public void debitar(float v, String nconta);
	public void creditar(float v, String nconta);
}