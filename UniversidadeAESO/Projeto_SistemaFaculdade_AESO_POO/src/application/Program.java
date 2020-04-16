package application;

import java.text.ParseException;
import java.util.Scanner;

import model.entities.Disciplina;
import model.entities.Professor;
import model.entities.Turma;
import model.entities.repositorio.RepositorioLeituraAluno;
import model.entities.repositorio.RepositorioLeituraDisciplina;
import model.entities.repositorio.RepositorioLeituraMenu;
import model.entities.repositorio.RepositorioLeituraProfessor;
import model.entities.repositorio.RepositorioLeituraTurma;
import model.entities.repositorio.RepositorioLogin;
import model.exception.DomainException;

/*
 *  @author RafaelBrito
 */

public class Program { // NOPMD by rafaB on 09/04/2020 21:28

	@SuppressWarnings("resource")
	public static void main(String[] args) throws DomainException, ParseException { // NOPMD by rafaB on 09/04/2020

		// Cria��o dos atributos que ser�o usados no main
		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		RepositorioLeituraTurma repositorioTurma = new RepositorioLeituraTurma();
		// List<Professor> listaProfessores = new ArrayList<>(); (PR�XIMA UNIDADE
		// IMPLEMENTAR LISTA)
		// List<Disciplina> listaDisciplinas = new ArrayList<>(); (PR�XIMA UNIDADE
		// IMPLEMENTAR LISTA)
		Professor professor = null;
		Disciplina disciplina = null;

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

					System.out.println(
							"Aluno adicionado!(" + turma.getAluno().size() + " de " + turma.getCapacidadeTurma() + ")");
					escolhaMenu = menuRepo.lerMenuAluno();
				}
				// <CLOSE/> La�o Cria��o Aluno
				if (turma.getAluno().size() == (int) turma.getCapacidadeTurma()) {
					System.out.println("Capacidade M�xima atingida!");

				}
				// Avisa ao usu�rio que est� a 1 unidade de chegar ao m�ximo da capacidade da
				// turma
				else {
					System.out.println(
							"[AVISO: Voc� s� poder� adicionar + 1 Aluno, de acordo com a capacidade m�xima da turma!]");
					System.out.println("");
					turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
					System.out.println(
							"Aluno adicionado! - " + turma.getAluno().size() + " de " + turma.getCapacidadeTurma());
				}
				break;
			}

			case 1: {
				// <OPEN> Cria��o Professor
				professor = new RepositorioLeituraProfessor().lerDados();
				System.out.println("Professor adicionado!");

				escolhaMenu = menuRepo.lerMenuProfessor();
				// <CLOSE/> Cria��o Professor

				// System.out.println("N�mero de Professores adicionados = " +
				// listaProfessores.size()); (PR�XIMA UNIDADE IMPLEMENTAR LISTA DE PROFESSORES)
				break;
			}

			case 2: {
				// <OPEN> Cria��o Disciplina
				disciplina = new RepositorioLeituraDisciplina().lerDados();
				System.out.println("Disciplina adicionada!");
				escolhaMenu = menuRepo.lerMenuDisciplina();

				// <CLOSE/> Cria��o Disciplina

				// System.out.println("N�mero de Disciplinas adicionadas = " +
				// listaDisciplinas.size()); (PR�XIMA UNIDADE IMPLEMENTAR LISTA DE DISCIPLINAS)
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

		System.out.println("[RESUMO] ");
		System.out.println(turma.toString());
		System.out.print(turma.mostrarListaAluno());

		Turma turma2 = new Turma(disciplina, professor);

		System.out.print(turma2.toString2());

		// FIM DA PRIMEIRA FASE DO SISTEMA (OBTEN��O DE DADOS DE 1 TURMA COM 1 PROFESSOR
		// COM 1 DISCIPLINA E COM X ALUNOS)
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		// INICIO DA SEGUNDA FASE DO SISTEMA LOGAR
		// FUNCIONANDO AT� A PARTE DE LOGIN
		
		escolhaMenu = menuRepo.lerMenuLogin(); // M�TODO PARA CHAMAR O MENU DE LOGIN
		RepositorioLogin login = new RepositorioLogin();

		// ESCOLHA DO USER BASEADO NO MENU LOGIN
		switch (escolhaMenu) {
		case 0: {
			//M�TODO DE VALIDA��O DA LISTA DE ALUNOS
			boolean validacao = login.validacaoAluno(turma.getAluno());

			//LA�O PARA BREKAR ERROS DE LOGIN COM USERNAME FALSO
			while (validacao == false) {
				System.out.println(validacao == true ? "" : "-------------------ERRO----------------------");
				System.out.println("Insira novamente: ");
				validacao = login.validacaoAluno(turma.getAluno());
			}
			// MENU SECUND�RIO QUE VAI FALTAR TERMINAR / CHAMAR� AS OP��ES QUE O ALUNO TER� DENTRO DO SISTEMA
			menuRepo.lerMenuSecundario(escolhaMenu);
			break;
		}

		case 1: {
			//M�TODO DE VALIDA��O DE 1 PROFESSOR / FUTURAMENTE IMPLEMENTAR LISTA DE PROFESSORES
			boolean validacao = login.validacaoProfessor(professor);

			//LA�O PARA BREKAR ERROS DE LOGIN COM USERNAME FALSO
			while (validacao == false) {
				System.out.println(validacao == true ? "" : "------------------------------------------");
				validacao = login.validacaoProfessor(professor);
			} 

			break;
		}

		case 9: {
			// FECHA O PROGRAMA
			System.out.println("Obrigado por utilizar nosso Sistema!");
			break;
		}
		default:
			
			throw new IllegalArgumentException("Valor Incorreto! N�o existe a op��o: " + escolhaMenu);
		}
		
		
		// CONTINUA... 
		//vers�o alfa 1.0 do WhiteBoard, finalizada em 15/04/2020 �s 21:45
		sc.close();
	}

}
