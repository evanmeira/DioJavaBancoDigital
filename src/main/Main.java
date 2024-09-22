package main;

import java.time.LocalDate;
import java.time.Month;

import banco.Agencia;
import banco.Atendimento;
import banco.Banco;
import classes.Endereco;
import conta.Conta;
import conta.ContaCorrente;

public class Main {

	public static void main(String[] args) {
		Banco uait = new Banco("Uait");
		Agencia agencia = uait.criarAgencia(
				new Endereco("Rua Principal", "89", "Nova Santana", "Santana", "AP", "68925-000"));
		
		agencia.contratarGerente("Klinjey", "999.888.777-66", LocalDate.of(1989, Month.APRIL, 27));
		
		Atendimento atendimentoMartin = agencia.iniciarAtendimento(agencia.getGerente());
		atendimentoMartin.cadastrarDadosCliente("Martin", "666.888.777-00", LocalDate.of(2000, Month.MARCH, 13));
		atendimentoMartin.cadastrarMaeCliente("Marcela Moran", "999.666.333-00", LocalDate.of(1960, Month.FEBRUARY, 20));
		atendimentoMartin.cadastrarPaiCliente("Daniel Oda", "111.333.666-87", LocalDate.of(2000, Month.DECEMBER, 3));
		atendimentoMartin.cadastrarEnderecoCliente("Rua Crimeia", "25", "Novo Mundo", "Santana", "AP", "68925-000");
		atendimentoMartin.selecionarTipoConta(Conta.TipoConta.CONTA_DIGITAL);
		Conta contaMartin = atendimentoMartin.gerarConta();
		atendimentoMartin.finalizarAtendimento();		
		
		contaMartin.depositar(1000);
		contaMartin.imprimirExtrato();		
		
		Atendimento atendimentoKutscher = agencia.iniciarAtendimento(agencia.getGerente());
		atendimentoKutscher.cadastrarDadosCliente("Kutscher", "666.888.777-00", LocalDate.of(2000, Month.MARCH, 13));
		atendimentoKutscher.cadastrarMaeCliente("Link Goleman", "999.666.333-00", LocalDate.of(1960, Month.FEBRUARY, 20));
		atendimentoKutscher.cadastrarPaiCliente("Rossandro Patrice", "111.333.666-87", LocalDate.of(2000, Month.DECEMBER, 3));
		atendimentoKutscher.cadastrarEnderecoCliente("Rua Crimeia", "25", "Novo Mundo", "Santana", "AP", "68925-000");
		atendimentoKutscher.selecionarTipoConta(Conta.TipoConta.CONTA_CORRENTE);
		Conta contaKutscher = atendimentoKutscher.gerarConta();
		atendimentoKutscher.finalizarAtendimento();
		
		contaKutscher.imprimirExtrato();
		
		contaMartin.transferir(500, contaKutscher);
		contaMartin.imprimirExtrato();
		
		((ContaCorrente) contaKutscher).sacar(250);
		contaKutscher.imprimirExtrato();
		
		((ContaCorrente) contaKutscher).sacar(500);
		contaKutscher.imprimirExtrato();
	}

}
