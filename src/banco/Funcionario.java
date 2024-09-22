package banco;

import java.time.LocalDate;

import classes.Pessoa;

public abstract class Funcionario extends Pessoa {
	
	private double salario;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salario) {
		super(nome, cpf, dataNascimento);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

}
