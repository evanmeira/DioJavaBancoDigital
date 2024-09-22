package conta;

import banco.Agencia;
import banco.Cliente;

public class ContaPoupanca extends Conta implements ContaCompleta {

	public ContaPoupanca(Agencia agencia, long numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	@Override
	public void sacar(double valor) {
		if(valor > this.saldo) {
			System.out.println("Não há saldo suficiente!");		
		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}
		
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== CONTA POUPANÇA ===");
		super.imprimirExtrato();;	
	}

	@Override
	public Cartao gerarCartao() {
		// TODO Auto-generated method stub
		return null;
	}

}
