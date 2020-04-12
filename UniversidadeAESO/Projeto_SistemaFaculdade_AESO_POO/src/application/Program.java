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
		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		Turma turma = new Turma();
		List<Professor> listaProfessores = new ArrayList<>();

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println("");

		int escolhaMenu = menuRepo.lerMenuPrincipal();
		if (escolhaMenu == 0) {
			do {
				turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
				System.out.println("Aluno adicionado!");
				escolhaMenu = menuRepo.lerMenuAluno();

			} while (escolhaMenu != 9);

			System.out.println("Número de Alunos adicionados = " + turma.getAluno().size());

		} else if (escolhaMenu == 1) {
			do {
				listaProfessores.add(new RepositorioLeituraProfessor().lerDados());
				System.out.println("Professor adicionado!");
				escolhaMenu = menuRepo.lerMenuProfessor();

			} while (escolhaMenu != 9);

			System.out.println("Número de Professores adicionados = " + listaProfessores.size());
			
		} else if (escolhaMenu == 2) {
			
		}

		/*
		 * final Aluno alunoTest = new RepositorioLeituraAluno().lerDados();
		 * System.out.println(alunoTest.toString()); System.out.println("");
		 * 
		 * final Professor professorTest = new RepositorioLeituraProfessor().lerDados();
		 * System.out.println(professorTest.toString()); System.out.println("");
		 * 
		 * final Disciplina disciplinaTest = new
		 * RepositorioLeituraDisciplina().lerDados();
		 * System.out.println(disciplinaTest.toString());
		 */

		sc.close();
	}

}
