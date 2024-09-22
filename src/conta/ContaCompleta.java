package conta;

public interface ContaCompleta extends ContaBasica {

	void sacar(double valor);
	Cartao gerarCartao();
	
}
