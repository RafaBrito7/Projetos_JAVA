package model.entities;

import java.util.Date;

public class Professor extends Pessoa{
	private String cargo;

	public Professor(String nome, int id, Date dataNascimento, String nomeUsuario, String senha, String cargo) {
		super(nome, id, dataNascimento, nomeUsuario, senha);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String toString() {
		return "ID: " + getId() + ",Nome: " + getNome() + ",Nascido em "
				+ getDataNascimento() + ", com o Cargo de " + getCargo() + "."
				+ "\nInformações de login: \nuser: " + getNomeUsuario() + " / senha: " + getSenha();
	}
}
