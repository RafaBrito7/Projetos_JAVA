package model.entities;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private int periodo;

	public Aluno(String nome, int id, Date dataNascimento, String nomeUsuario, String senha, int periodo) {
		super(nome, id, dataNascimento, nomeUsuario, senha);
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	
}
