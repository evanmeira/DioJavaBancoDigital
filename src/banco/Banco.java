package banco;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import classes.Endereco;

public class Banco {
	
	private static int SENQUENCIAL_AGENCIA = 0;
	
	private String nome;
	private Set<Agencia> agencias;
	
	public Banco(String nome) {
		this.nome = nome;
		this.agencias = new HashSet<Agencia>();
		System.out.println("Banco criado com sucesso");
	}
	
	public Agencia criarAgencia(Endereco endereco) {		
		Agencia agencia = new Agencia(this, ++SENQUENCIAL_AGENCIA, endereco);
		this.agencias.add(agencia);
		System.out.println("Nova agência criada com sucesso");
		return agencia;
	}

	public String getNome() {
		return nome;
	}

	public Set<Agencia> getAgencias() {
		return agencias;
	}
	
	@Override
	public String toString() {
		return "Banco [nome=" + nome + ",\nagencias=" + agencias + "]";
	}	

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Banco other = (Banco) obj;
		return Objects.equals(nome, other.nome);
	}

}
