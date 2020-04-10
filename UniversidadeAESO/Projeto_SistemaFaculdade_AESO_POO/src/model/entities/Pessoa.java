package model.entities;

import java.util.Date;
import java.util.Scanner;

public abstract class Pessoa {
	Scanner sc = new Scanner(System.in);
	
	private String nome;
	private Integer id;
	private Date dataNascimento;
	private String nomeUsuario;
	private String senha;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, Integer id, Date dataNascimento, String nomeUsuario, String senha) {
		this.nome = nome;
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract String toString();
	

}
