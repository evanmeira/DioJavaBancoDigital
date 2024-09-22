package banco;

import java.time.LocalDate;

public class Gerente extends Funcionario {

	public Gerente(String nome, String cpf, LocalDate dataNascimento, double salario) {
		super(nome, cpf, dataNascimento, salario);
	}
	
	public void admitirFuncionario(Funcionario funcionario) {
		
	}
	
	public boolean validarDadosAtendimento(Atendimento atendimento) {
		return true;
	}

	
}
