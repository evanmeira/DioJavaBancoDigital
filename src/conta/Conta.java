package conta;

import banco.Agencia;
import banco.Cliente;

public abstract class Conta implements ContaBasica {
	
	public static enum TipoConta {
		CONTA_CORRENTE,
		CONTA_POUPANCA,
		CONTA_DIGITAL;
	}
	
	protected Agencia agencia;
	protected long numero;
	protected Cliente cliente;
	protected double saldo;
	
	public Conta(Agencia agencia, long numero, Cliente cliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0;
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Deposito realizado com sucesso!");
	}

	@Override
	public void transferir(double valor, ContaBasica conta) {System.out.println("Valor: " + valor + ", saldo: " + this.saldo);
		if(valor < this.saldo) {
			conta.depositar(valor);
			this.saldo -= valor;
			System.out.println("Transferencia realizada com sucesso!");
		} else {
			System.out.println("Não há saldo suficiente");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("Banco: " + agencia.getBanco().getNome());
		System.out.println("Conta: " + numero);
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Saldo: R$" + saldo);
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public long getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia.getNumero() + ", numero=" + numero + ", cliente=" + cliente.getNome() + ", saldo=" + saldo + "]";
	}
	
}
