package model.entities.repositorio;

import java.util.List;
import java.util.Scanner;

import model.entities.Aluno;
import model.entities.Professor;

public class RepositorioLogin {
	Scanner sc = new Scanner(System.in);

	public boolean validacaoProfessor(Professor professor) {
		System.out.println("[Login Professor]");
		System.out.print("- Insira o nome de usuário: ");
		String nomeUser = sc.nextLine();
		System.out.print("- Insira a senha: ");
		String senhaUser = sc.nextLine();

		if (professor.getNomeUsuario().equals(nomeUser) && professor.getSenha().equals(senhaUser)) {
			System.out.println("Login realizado com Sucesso!");
			System.out.println("Bem Vindo Professor " + professor.getNome() + "!");
			return true;

		} else if (!professor.getNomeUsuario().equals(nomeUser)) {
			System.out.println("[ERRO] - Nome de Usuário inexistente");
			return false;

		} else if (!professor.getSenha().equals(senhaUser)) {
			System.out.println("[ERRO] - Senha Inválida!");
			return false;

		} else
			return false;

	}

	public boolean validacaoAluno(List<Aluno> aluno) {
		System.out.println("[Login Aluno]");
		System.out.print("- Insira o nome de usuário: ");
		String nomeUser = sc.nextLine();
		System.out.print("- Insira a senha: ");
		String senhaUser = sc.nextLine();
		boolean resultado = false;

		for (Aluno aluno2 : aluno) {
			if (aluno2.getNomeUsuario().equals(nomeUser) && aluno2.getSenha().equals(senhaUser)) {
				System.out.println("Login realizado com Sucesso!");
				System.out.println("------Bem Vindo Aluno(ª) " + aluno2.getNome() + "!------");
				resultado = true;
				
			} else if (aluno2.getNomeUsuario().equals(nomeUser)) {
				if (!aluno2.getSenha().equals(senhaUser)) {
					System.out.println("[ERRO] - Senha Inválida!");
					resultado = false;
				}
			} 
		}
		return resultado;
		
	}
}
