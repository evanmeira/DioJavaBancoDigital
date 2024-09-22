package conta;

import banco.Cliente;

public class Cartao {
	
	private Cliente cliente;
	private int senha;
	
	public Cartao(Cliente cliente, int senha) {
		super();
		this.cliente = cliente;
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public boolean validarSenha(int senha) {
		return this.senha == senha;
	}

}
