package model.entities;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private Integer periodo;

	public Aluno(String nome, Integer id, Date dataNascimento, String nomeUsuario, String senha, Integer periodo) {
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
