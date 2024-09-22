package banco;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import classes.Endereco;
import classes.Pessoa;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaDigital;
import conta.ContaPoupanca;

public class Agencia {
	
	private static long SEQUENCIAL_CONTA_CORRENTE;
	private static long SEQUENCIAL_CONTA_POUPANCA;
	private static long SEQUENCIAL_CONTA_DIGITAL;

	private Banco banco;
	private int numero;
	private Endereco endereco;
	private Set<Funcionario> funcionarios;	
	private Gerente gerente;
	
	private Set<Atendimento> atendimentos;
	
	public Agencia(Banco banco, int numero, Endereco endereco) {
		this.banco = banco;
		this.numero = numero;
		this.endereco = endereco;
		this.funcionarios = new HashSet<>();
		this.atendimentos = new HashSet<>();
	}

	public Gerente contratarGerente(String nome, String cpf, LocalDate dataNascimento) {
		Gerente gerente = new Gerente(nome,cpf, dataNascimento, 2000);
		this.gerente = gerente;
		System.out.println("Novo gerente contratado");
		return gerente;
	}
	
	public Atendimento iniciarAtendimento(Funcionario funcionario) {
		Atendimento atendimento = new Atendimento(funcionario, this);
		this.atendimentos.add(atendimento);
		System.out.println("Atendimento iniciado");
		return atendimento;		
	}
	
	public Conta gerarConta(Atendimento atendimento) {
		if(this.gerente.validarDadosAtendimento(atendimento)) {
			switch(atendimento.getTipoContaSelecionado()) {
				case Conta.TipoConta.CONTA_CORRENTE: {
					System.out.println("Conta Corrente gerada com sucesso");
					return new ContaCorrente(this, ++SEQUENCIAL_CONTA_CORRENTE, gerarCliente(atendimento));
				}
				
				case Conta.TipoConta.CONTA_DIGITAL: {
					System.out.println("Conta Digital gerada com sucesso");
					return new ContaDigital(this, ++SEQUENCIAL_CONTA_DIGITAL, gerarCliente(atendimento));
				}
				
				case Conta.TipoConta.CONTA_POUPANCA: {
					System.out.println("Conta Poupança gerada com sucesso");
					return new ContaPoupanca(this, ++SEQUENCIAL_CONTA_POUPANCA, gerarCliente(atendimento));
				}
			}
		}
		
		return null;
	}
	
	private Cliente gerarCliente(Atendimento atendimento) {
		Pessoa futuroCliente = atendimento.getPessoaEmAtedimento();
		return new Cliente(
				futuroCliente.getNome(),
				futuroCliente.getCpf(),
				futuroCliente.getDataNascimento(), 
				atendimento.getMae(),
				atendimento.getPai(),
				atendimento.getEndereco());
	}
	
	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public Banco getBanco() {
		return banco;
	}

	public int getNumero() {
		return numero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Agencia [banco=" + banco.getNome() + ", numero=" + numero + ",\nendereco=" + endereco + ",\nfuncionarios="
				+ funcionarios + ",\ngerente=" + gerente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(banco, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(banco, other.banco) && numero == other.numero;
	}	
	
}
