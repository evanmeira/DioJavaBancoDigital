package conta;

public interface ContaBasica {

	void depositar(double valor);
	void transferir(double valor, ContaBasica conta);
	void imprimirExtrato();
	
}
