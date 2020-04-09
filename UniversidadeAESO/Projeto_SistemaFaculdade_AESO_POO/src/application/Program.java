package application;

import java.text.ParseException;
import java.util.Scanner;

import model.entities.Aluno;
import model.entities.Professor;
import model.entities.repositorio.RepositorioLeituraAluno;
import model.entities.repositorio.RepositorioLeituraProfessor;
import model.exception.DomainException;

public class Program {
	public static void main(String[] args) throws DomainException, ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println("");
		
		Aluno alunoTest = new RepositorioLeituraAluno().lerDadosAluno();
		System.out.println(alunoTest.toString());

		Professor professorTest = new RepositorioLeituraProfessor().lerDadosProfessor();
		System.out.println(professorTest.toString());
		sc.close();
	}

}
