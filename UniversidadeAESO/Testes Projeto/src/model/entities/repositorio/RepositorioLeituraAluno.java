package model.entities.repositorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Aluno;

//Classe para Leitura de todos os Dados do Aluno
public class RepositorioLeituraAluno implements InterfaceLeitura {
	public Aluno lerDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("[CADASTRO ALUNO]");
		sc.nextLine();
		System.out.print("Informe o nome: ");
		String nome = sc.nextLine();
		System.out.print("Informe a data de nascimento(dd/mm/yyyy): ");
		Date dataNascimento = sdf.parse(sc.next());
		System.out.print("Informe uma ID: ");
		int id = sc.nextInt();
		System.out.print("Informe o periodo: ");
		int periodo = sc.nextInt();
		System.out.print("Crie um nome de usuário: ");
		String nomeUsuario = sc.next();
		System.out.print("Informe uma senha: ");
		String senha = sc.next();
		return new Aluno(nome, id, dataNascimento, nomeUsuario, senha, periodo);
		
	}
	

}
