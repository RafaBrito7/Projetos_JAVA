package application;

import java.text.ParseException;
import java.util.Scanner;

import model.entities.*;
import model.entities.repositorio.*;
import model.exception.DomainException;

/*
 *  @author Rafael Brito
 */

public class Program {  // NOPMD by rafab on 09/04/2020 21:28
	
	public static void main(String[] args) throws DomainException, ParseException {  // NOPMD by rafab on 09/04/2020 21:26
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println("");
		
		final Aluno alunoTest = new RepositorioLeituraAluno().lerDados();
		System.out.println(alunoTest.toString());
		System.out.println("");
		
		final Professor professorTest = new RepositorioLeituraProfessor().lerDados();
		System.out.println(professorTest.toString());
		System.out.println("");
		
		final Disciplina disciplinaTest = new RepositorioLeituraDisciplina().lerDados();
		System.out.println(disciplinaTest.toString());
		
		sc.close();
	}

}
