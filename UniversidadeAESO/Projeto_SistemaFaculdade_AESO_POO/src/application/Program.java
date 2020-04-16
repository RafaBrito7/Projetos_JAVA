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

		// Criação dos atributos que serão usados no main
		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		RepositorioLeituraTurma repositorioTurma = new RepositorioLeituraTurma();
		// List<Professor> listaProfessores = new ArrayList<>(); (PRÓXIMA UNIDADE
		// IMPLEMENTAR LISTA)
		// List<Disciplina> listaDisciplinas = new ArrayList<>(); (PRÓXIMA UNIDADE
		// IMPLEMENTAR LISTA)
		Professor professor = null;
		Disciplina disciplina = null;

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

					System.out.println(
							"Aluno adicionado!(" + turma.getAluno().size() + " de " + turma.getCapacidadeTurma() + ")");
					escolhaMenu = menuRepo.lerMenuAluno();
				}
				// <CLOSE/> Laço Criação Aluno
				if (turma.getAluno().size() == (int) turma.getCapacidadeTurma()) {
					System.out.println("Capacidade Máxima atingida!");

				}
				// Avisa ao usuário que está a 1 unidade de chegar ao máximo da capacidade da
				// turma
				else {
					System.out.println(
							"[AVISO: Você só poderá adicionar + 1 Aluno, de acordo com a capacidade máxima da turma!]");
					System.out.println("");
					turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
					System.out.println(
							"Aluno adicionado! - " + turma.getAluno().size() + " de " + turma.getCapacidadeTurma());
				}
				break;
			}

			case 1: {
				// <OPEN> Criação Professor
				professor = new RepositorioLeituraProfessor().lerDados();
				System.out.println("Professor adicionado!");

				escolhaMenu = menuRepo.lerMenuProfessor();
				// <CLOSE/> Criação Professor

				// System.out.println("Número de Professores adicionados = " +
				// listaProfessores.size()); (PRÓXIMA UNIDADE IMPLEMENTAR LISTA DE PROFESSORES)
				break;
			}

			case 2: {
				// <OPEN> Criação Disciplina
				disciplina = new RepositorioLeituraDisciplina().lerDados();
				System.out.println("Disciplina adicionada!");
				escolhaMenu = menuRepo.lerMenuDisciplina();

				// <CLOSE/> Criação Disciplina

				// System.out.println("Número de Disciplinas adicionadas = " +
				// listaDisciplinas.size()); (PRÓXIMA UNIDADE IMPLEMENTAR LISTA DE DISCIPLINAS)
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

		System.out.println("[RESUMO] ");
		System.out.println(turma.toString());
		System.out.print(turma.mostrarListaAluno());

		Turma turma2 = new Turma(disciplina, professor);

		System.out.print(turma2.toString2());

		// FIM DA PRIMEIRA FASE DO SISTEMA (OBTENÇÃO DE DADOS DE 1 TURMA COM 1 PROFESSOR
		// COM 1 DISCIPLINA E COM X ALUNOS)
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		// INICIO DA SEGUNDA FASE DO SISTEMA LOGAR
		// FUNCIONANDO ATÉ A PARTE DE LOGIN
		
		escolhaMenu = menuRepo.lerMenuLogin(); // MÉTODO PARA CHAMAR O MENU DE LOGIN
		RepositorioLogin login = new RepositorioLogin();

		// ESCOLHA DO USER BASEADO NO MENU LOGIN
		switch (escolhaMenu) {
		case 0: {
			//MÉTODO DE VALIDAÇÃO DA LISTA DE ALUNOS
			boolean validacao = login.validacaoAluno(turma.getAluno());

			//LAÇO PARA BREKAR ERROS DE LOGIN COM USERNAME FALSO
			while (validacao == false) {
				System.out.println(validacao == true ? "" : "-------------------ERRO----------------------");
				System.out.println("Insira novamente: ");
				validacao = login.validacaoAluno(turma.getAluno());
			}
			// MENU SECUNDÁRIO QUE VAI FALTAR TERMINAR / CHAMARÁ AS OPÇÕES QUE O ALUNO TERÁ DENTRO DO SISTEMA
			menuRepo.lerMenuSecundario(escolhaMenu);
			break;
		}

		case 1: {
			//MÉTODO DE VALIDAÇÃO DE 1 PROFESSOR / FUTURAMENTE IMPLEMENTAR LISTA DE PROFESSORES
			boolean validacao = login.validacaoProfessor(professor);

			//LAÇO PARA BREKAR ERROS DE LOGIN COM USERNAME FALSO
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
			
			throw new IllegalArgumentException("Valor Incorreto! Não existe a opção: " + escolhaMenu);
		}
		
		
		// CONTINUA... 
		//versão alfa 1.0 do WhiteBoard, finalizada em 15/04/2020 ás 21:45
		sc.close();
	}

}
