package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno extends Pessoa{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer periodo;
	
	public Aluno() {
	}

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
	
	public String toString() {
		return "ID: " + getId() + ", NOME: " + getNome() + ", NASCIMENTO "
				+ sdf.format(getDataNascimento()) + ", PERÍODO " + getPeriodo() + "."
				+ "\n \nInformações de login: \nuser: " + getNomeUsuario() + " / senha: " + getSenha();
	}
	
}
