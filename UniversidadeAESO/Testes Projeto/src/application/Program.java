package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Aluno;
import model.entities.Professor;
import model.entities.Turma;
import model.entities.repositorio.RepositorioLeituraMenu;
import model.entities.repositorio.RepositorioLogin;
import model.exception.DomainException;

/*
 *  @author RafaelBrito
 */

public class Program { // NOPMD by rafaB on 09/04/2020 21:28

	public static void main(String[] args) throws DomainException, ParseException { // NOPMD by rafaB on 09/04/2020

		Scanner sc = new Scanner(System.in);
		RepositorioLeituraMenu menuRepo = new RepositorioLeituraMenu();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		menuRepo.tutorialEntrada(); // Saida de dados com um tutorial de como funciona o programa
		System.out.println("");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------");
		int escolhaMenu;

		// INICIO DA SEGUNDA FASE DO SISTEMA LOGAR
		escolhaMenu = menuRepo.lerMenuLogin();
		RepositorioLogin login = new RepositorioLogin();

		Professor professor = new Professor("Renato", 15, sdf.parse("11/05/2010"), "prof", "123", "Professor Estrutura");
		Turma turma = new Turma();
		
		turma.adicionarAluno(new Aluno("Lucas", 10, sdf.parse("22/01/1980"), "lucas", "123", 1));
		turma.adicionarAluno(new Aluno("José", 8, sdf.parse("25/10/1990"), "jose", "123", 1));
		turma.adicionarAluno(new Aluno("Maria", 9, sdf.parse("20/07/1980"), "maria", "123", 1));
		

		switch (escolhaMenu) {
		case 0: {
			boolean validacao = login.validacaoAluno(turma.getAluno());

			while (validacao == false) {
				System.out.println(validacao == true ? "" : "------------------------------------------");
				System.out.println("Usuário inválido! Insira novamente: ");
				validacao = login.validacaoAluno(turma.getAluno());
			}
			
			menuRepo.lerMenuSecundario(escolhaMenu);
			
			break;
		}

		case 1: {
			boolean validacao = login.validacaoProfessor(professor);

			while (validacao == false) {
				System.out.println(validacao == true ? "" : "------------------------------------------");
				validacao = login.validacaoProfessor(professor);
			} 
			
			menuRepo.lerMenuSecundario(escolhaMenu);

			break;
		}

		case 9: {
			System.out.println("Obrigado por utilizar nosso Sistema!");
			break;
		}
		default:
			throw new IllegalArgumentException("Valor Incorreto! Não existe a opção: " + escolhaMenu);
		}

		sc.close();
		
		System.out.println("Obrigado por utilizar nosso Sistema!");
	}

}
