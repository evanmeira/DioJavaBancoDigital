package banco;

import java.time.LocalDate;

import classes.Endereco;
import classes.Pessoa;

public class Cliente extends Pessoa{

	private Pessoa mae;
	private Pessoa pai;
	private Endereco endereco;
	
	public Cliente(String nome, String cpf, LocalDate dataNascimento, Pessoa mae, Pessoa pai, Endereco endereco) {
		super(nome, cpf, dataNascimento);
		this.mae = mae;
		this.pai = pai;
		this.endereco = endereco;
	}

	public Pessoa getMae() {
		return mae;
	}

	public Pessoa getPai() {
		return pai;
	}

	public Endereco getEndereco() {
		return endereco;
	}

}
