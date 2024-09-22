package conta;

import banco.Agencia;
import banco.Cliente;

public class ContaDigital extends Conta implements ContaBasica {

	public ContaDigital(Agencia agencia, long numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== CONTA DIGITAL ===");
		super.imprimirExtrato();;	
	}

}
