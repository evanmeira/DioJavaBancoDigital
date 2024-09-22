package banco;

import java.time.LocalDate;
import java.util.Objects;

import classes.Endereco;
import classes.Pessoa;
import conta.Conta;
import conta.Conta.TipoConta;

public class Atendimento {
	
	private static long SEQUENCIAL_ATENDIMENTO = 0;
	
	private long numeroAtendimento;
	private Funcionario funcionario;
	private Agencia agencia;
	private Pessoa pessoaEmAtedimento;
	private Pessoa mae;
	private Pessoa pai;
	private Endereco endereco;
	private TipoConta tipoContaSelecionado;
	private boolean aberto;
	
	public Atendimento(Funcionario funcionario, Agencia agencia) {
		this.funcionario = funcionario;
		this.agencia = agencia;
		this.numeroAtendimento = ++SEQUENCIAL_ATENDIMENTO;
		this.aberto = true;
	}

	public void cadastrarDadosCliente(String nome, String cpf, LocalDate dataNascimento) {
		this.pessoaEmAtedimento = new Pessoa(nome, cpf, dataNascimento);
		System.out.println("Dados do cliente cadastrados com sucesso");
	}
	
	public void cadastrarMaeCliente(String nome, String cpf, LocalDate dataNascimento) {
		this.mae = new Pessoa(nome, cpf, dataNascimento);
		System.out.println("Dados da mãe do cliente cadastrados com sucesso");
	}
	
	public void cadastrarPaiCliente(String nome, String cpf, LocalDate dataNascimento) {
		this.pai = new Pessoa(nome, cpf, dataNascimento);
		System.out.println("Dados do pai do cliente cadastrados com sucesso");
	}
	
	public void cadastrarEnderecoCliente(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
		this.endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		System.out.println("Endereço do cliente cadastrado com sucesso");
	}
	
	public void finalizarAtendimento() {
		this.aberto = false;
		System.out.println("Atendimento finalizado");
	}	

	public Conta gerarConta() {
		System.out.println("Solicitada a geração de conta para a agência");
		return this.agencia.gerarConta(this);
	}
	
	public void selecionarTipoConta(TipoConta tipoConta) {
		this.tipoContaSelecionado = tipoConta;
	}
	
	public TipoConta getTipoContaSelecionado() {
		return this.tipoContaSelecionado;
	}

	public Pessoa getPessoaEmAtedimento() {
		return pessoaEmAtedimento;
	}

	public void setPessoaEmAtedimento(Pessoa pessoaEmAtedimento) {
		this.pessoaEmAtedimento = pessoaEmAtedimento;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroAtendimento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Atendimento other = (Atendimento) obj;
		return numeroAtendimento == other.numeroAtendimento;
	}

}
