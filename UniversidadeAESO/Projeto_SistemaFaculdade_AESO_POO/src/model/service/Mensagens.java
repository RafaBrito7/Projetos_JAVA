package model.service;

import java.util.Date;
import java.util.Scanner;

public class Mensagens {
	static Scanner sc = new Scanner(System.in);
	
	public Mensagens(String nome, Integer id, Date dataNascimento, String nomeUsuario, String senha) {
		
	}
	
	public String mensagem(int entrada) {
		if (entrada == 0) {
			return "Escolha qual ação deseja fazer:\n" +
					"Digite [0] Cadastrar Aluno\n" +
					"Digite [1] Cadastrar Professor\n" +
					"Digite [2] Cadastrar Disciplina\n";
			
		} else if(entrada == 1) {
			new Mensagens(nome, id, dataNascimento, nomeUsuario, senha);
			private String nome;
			private Integer id;
			private Date dataNascimento;
			private String nomeUsuario;
			private String senha;
			
			return sb.toString();
		}
		
		
		else
			return null;
		
	}

}
