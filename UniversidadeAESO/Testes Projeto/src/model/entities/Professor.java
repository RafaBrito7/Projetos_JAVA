package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Professor extends Pessoa{
	private String cargo;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
				+ sdf.format(getDataNascimento()) + ", com o Cargo de " + getCargo() + "."
				+ "\n----> Informações de login: \n----> user: " + getNomeUsuario() + " / senha: " + getSenha();
	}
}
