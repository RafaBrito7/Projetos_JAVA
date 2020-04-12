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
		Turma turma = new Turma();
		List<Professor> listaProfessores = new ArrayList<>();
		List<Disciplina> listaDisciplinas = new ArrayList<>();

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println("");

		//Saída de Dados do Menu e Entrada, através do método da Class RepositorioLeituraMenu
		
		int escolhaMenu = menuRepo.lerMenuPrincipal();

		// <OPEN> LAÇO PRINCIPAL Leitura e Cadastro de todos os SubDados para Criação de uma Turma 
		
		while (escolhaMenu != 9) {
			
			//<OPEN> LAÇOS SECUNDÁRIOS
			
			if (escolhaMenu == 0) {
				
				//<OPEN> Laço Criação Aluno
				do {
					turma.adicionarAluno(new RepositorioLeituraAluno().lerDados());
					System.out.println("Aluno adicionado!");
					escolhaMenu = menuRepo.lerMenuAluno();

				} while (escolhaMenu != 9);
				//<CLOSE/> Laço Criação Aluno
				
				System.out.println("Número de Alunos adicionados = " + turma.getAluno().size());

			} else if (escolhaMenu == 1) {
				
				//<OPEN> Laço Criação Professor
				do {
					listaProfessores.add(new RepositorioLeituraProfessor().lerDados());
					System.out.println("Professor adicionado!");
					escolhaMenu = menuRepo.lerMenuProfessor();

				} while (escolhaMenu != 9);
				//<CLOSE/> Laço Criação Professor
				
				System.out.println("Número de Professores adicionados = " + listaProfessores.size());

			} else if (escolhaMenu == 2) {
				
				//<OPEN> Laço Criação Disciplina
				do {
					listaDisciplinas.add(new RepositorioLeituraDisciplina().lerDados());
					System.out.println("Disciplina adicionada!");
					escolhaMenu = menuRepo.lerMenuDisciplina();

				} while (escolhaMenu != 9);
				//<CLOSE/> Laço Criação Disciplina
				
				System.out.println("Número de Disciplinas adicionadas = " + listaDisciplinas.size());
			}
			//<CLOSE/> LAÇO SECUNDÁRIO

			escolhaMenu = menuRepo.lerMenuSecundario();
		}
		//<CLOSE/> LAÇO PRINCIPAL

		sc.close();
	}

}
