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

		// Cria��o dos atributos que ser�o usados no main
		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		RepositorioLeituraTurma repositorioTurma = new RepositorioLeituraTurma();
		List<Professor> listaProfessores = new ArrayList<>();
		List<Disciplina> listaDisciplinas = new ArrayList<>();

		System.out.println("Bem vindo a vers�o Alfa do WhiteBoard!");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		menuRepo.tutorialEntrada(); // Saida de dados com um tutorial de como funciona o programa
		System.out.println("");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		Turma turma = repositorioTurma.lerDadosInicial(); // Entrada de dados com add de dados de uma turma

		// Sa�da de Dados do Menu e Entrada, atrav�s do m�todo da Class
		// RepositorioLeituraMenu
		int escolhaMenu = menuRepo.lerMenuPrincipal();

		// <OPEN> LA�O PRINCIPAL Leitura e Cadastro de todos os SubDados para Cria��o de
		// uma Turma
		while (escolhaMenu != 9) {

			// <OPEN> LA�OS SECUND�RIOS
			switch (escolhaMenu) {

			case 0: {
				// <OPEN> La�o Cria��o Aluno
					while ((turma.getAluno().size() + 1) < (int) turma.getCapacidadeTurma()) {
						turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
						
						System.out.println("Aluno adicionado!(" + turma.getAluno().size() + " de "
								+ turma.getCapacidadeTurma() + ")");
						escolhaMenu = menuRepo.lerMenuAluno();
					}
				// <CLOSE/> La�o Cria��o Aluno
					if (turma.getAluno().size() == (int) turma.getCapacidadeTurma()) {
						System.out.println("Capacidade M�xima atingida!");
						
					} 
					// Avisa ao usu�rio que est� a 1 unidade de chegar ao m�ximo da capacidade da turma
					else {
						System.out.println("AVISO: 'Voc� s� poder� adicionar + 1 Aluno, de acordo com a capacidade m�xima da turma!'");
						turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
						System.out.println(
								"Aluno adicionado! - " + turma.getAluno().size() + " de " + turma.getCapacidadeTurma());
					}
				break;
			}

			case 1: {
				// <OPEN> La�o Cria��o Professor
				do {
					listaProfessores.add(new RepositorioLeituraProfessor().lerDados());
					System.out.println("Professor adicionado!");
					escolhaMenu = menuRepo.lerMenuProfessor();

				} while (escolhaMenu != 9);
				// <CLOSE/> La�o Cria��o Professor

				System.out.println("N�mero de Professores adicionados = " + listaProfessores.size());
				break;
			}

			case 2: {
				// <OPEN> La�o Cria��o Disciplina
				do {
					listaDisciplinas.add(new RepositorioLeituraDisciplina().lerDados());
					System.out.println("Disciplina adicionada!");
					escolhaMenu = menuRepo.lerMenuDisciplina();

				} while (escolhaMenu != 9);
				// <CLOSE/> La�o Cria��o Disciplina

				System.out.println("N�mero de Disciplinas adicionadas = " + listaDisciplinas.size());
				break;
			}

			case 9: {
				// Comando de sair do La�o Secund�rio
				break;
			}

			default:
				throw new IllegalArgumentException("Valor Incorreto! N�o existe a op��o: " + escolhaMenu);

			} // <CLOSE/> LA�O SECUND�RIO / Listas

			escolhaMenu = menuRepo.lerMenuPrincipal();

		} // <CLOSE/> LA�O PRINCIPAL / MenuPrincipal
		
		turma = new Turma(listaDisciplinas, listaProfessores);
		
		System.out.println("Resumo: ");
		System.out.println(turma.toString());
		System.out.println(turma.mostrarListaAluno());

		sc.close();
	}

}
