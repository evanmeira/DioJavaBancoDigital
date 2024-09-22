package conta;

import banco.Agencia;
import banco.Cliente;

public class ContaCorrente extends Conta implements ContaCompleta {
	
	private double limiteEspecial;
	private double saldoLimiteEspecial;

	public ContaCorrente(Agencia agencia, long numero, Cliente cliente) {
		super(agencia, numero, cliente);
		this.limiteEspecial = 500;
		this.saldoLimiteEspecial = 500;
	}

	@Override
	public void sacar(double valor) {
		if(valor > this.saldo) {
			if(valor > (this.saldo + this.saldoLimiteEspecial)) {
				System.out.println("Não há saldo suficiente!");
			} else {
				valor -= this.saldo;
				this.saldo = 0;
				this.saldoLimiteEspecial -= valor;
				System.out.println("Saque realizado com saldo do limite especial.");
			}			
		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso");
		}		
	}

	@Override
	public void depositar(double valor) {
		double limiteEspecialDevido = this.saldoLimiteEspecial - this.limiteEspecial;
		if(limiteEspecialDevido > 0) {
			if(valor > limiteEspecialDevido) {
				this.saldoLimiteEspecial = this.limiteEspecial;
				valor -= limiteEspecialDevido;
			} else {
				this.saldoLimiteEspecial -= valor;
				valor = 0;
			}
		}
		
		super.depositar(valor);
	}

	@Override
	public Cartao gerarCartao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== CONTA CORRENTE ===");
		super.imprimirExtrato();;
		System.out.println("Limite especial usado: R$" + (limiteEspecial - saldoLimiteEspecial));		
	}

}
