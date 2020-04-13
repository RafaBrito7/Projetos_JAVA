package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.*;
import model.entities.repositorio.*;
import model.exception.DomainException;

/*
 *  @author RafaelBrito
 */

public class Program { // NOPMD by rafaB on 09/04/2020 21:28

	public static void main(String[] args) throws DomainException, ParseException { // NOPMD by rafaB on 09/04/2020

		// Criação dos atributos que serão usados no main
		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		RepositorioLeituraTurma repositorioTurma = new RepositorioLeituraTurma();
		List<Professor> listaProfessores = new ArrayList<>();
		List<Disciplina> listaDisciplinas = new ArrayList<>();

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		menuRepo.tutorialEntrada(); // Saida de dados com um tutorial de como funciona o programa
		System.out.println("");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		Turma turma = repositorioTurma.lerDadosInicial(); // Entrada de dados com add de dados de uma turma

		// Saída de Dados do Menu e Entrada, através do método da Class
		// RepositorioLeituraMenu
		int escolhaMenu = menuRepo.lerMenuPrincipal();

		// <OPEN> LAÇO PRINCIPAL Leitura e Cadastro de todos os SubDados para Criação de
		// uma Turma
		while (escolhaMenu != 9) {

			// <OPEN> LAÇOS SECUNDÁRIOS
			switch (escolhaMenu) {

			case 0: {
				// <OPEN> Laço Criação Aluno
					while ((turma.getAluno().size() + 1) < (int) turma.getCapacidadeTurma()) {
						turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
						
						System.out.println("Aluno adicionado!(" + turma.getAluno().size() + " de "
								+ turma.getCapacidadeTurma() + ")");
						escolhaMenu = menuRepo.lerMenuAluno();
					}
				// <CLOSE/> Laço Criação Aluno
					if (turma.getAluno().size() == (int) turma.getCapacidadeTurma()) {
						System.out.println("Capacidade Máxima atingida!");
						
					} 
					// Avisa ao usuário que está a 1 unidade de chegar ao máximo da capacidade da turma
					else {
						System.out.println("AVISO: 'Você só poderá adicionar + 1 Aluno, de acordo com a capacidade máxima da turma!'");
						turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
						System.out.println(
								"Aluno adicionado! - " + turma.getAluno().size() + " de " + turma.getCapacidadeTurma());
					}
				break;
			}

			case 1: {
				// <OPEN> Laço Criação Professor
				do {
					listaProfessores.add(new RepositorioLeituraProfessor().lerDados());
					System.out.println("Professor adicionado!");
					escolhaMenu = menuRepo.lerMenuProfessor();

				} while (escolhaMenu != 9);
				// <CLOSE/> Laço Criação Professor

				System.out.println("Número de Professores adicionados = " + listaProfessores.size());
				break;
			}

			case 2: {
				// <OPEN> Laço Criação Disciplina
				do {
					listaDisciplinas.add(new RepositorioLeituraDisciplina().lerDados());
					System.out.println("Disciplina adicionada!");
					escolhaMenu = menuRepo.lerMenuDisciplina();

				} while (escolhaMenu != 9);
				// <CLOSE/> Laço Criação Disciplina

				System.out.println("Número de Disciplinas adicionadas = " + listaDisciplinas.size());
				break;
			}

			case 9: {
				// Comando de sair do Laço Secundário
				break;
			}

			default:
				throw new IllegalArgumentException("Valor Incorreto! Não existe a opção: " + escolhaMenu);

			} // <CLOSE/> LAÇO SECUNDÁRIO / Listas

			escolhaMenu = menuRepo.lerMenuPrincipal();

		} // <CLOSE/> LAÇO PRINCIPAL / MenuPrincipal
		
		turma = new Turma(listaDisciplinas, listaProfessores);
		
		System.out.println("Resumo: ");
		System.out.println(turma.toString());
		System.out.println(turma.mostrarListaAluno());

		sc.close();
	}

}
