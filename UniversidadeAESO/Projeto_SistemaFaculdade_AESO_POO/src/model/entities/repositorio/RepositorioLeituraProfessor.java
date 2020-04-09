package model.entities.repositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Professor;

public class RepositorioLeituraProfessor {
	//Classe para Leitura de todos os Dados do Professor
	
	public Professor lerDadosProfessor() throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("[CADASTRO PROFESSOR]");
		System.out.print("Informe o nome: ");
		String nome = sc.nextLine();
		System.out.print("Informe a data de nascimento(dd/mm/yyyy): ");
		Date dataNascimento = sdf.parse(sc.next());
		System.out.print("Informe uma ID: ");
		int id = sc.nextInt();
		System.out.print("Informe o cargo: ");
		String cargo = sc.nextLine();
		System.out.print("Crie um nome de usuário: ");
		String nomeUsuario = sc.next();
		System.out.print("Informe uma senha: ");
		String senha = sc.next();
		sc.close();
		return new Professor(nome, id, dataNascimento, nomeUsuario, senha, cargo);
		
	}

}
