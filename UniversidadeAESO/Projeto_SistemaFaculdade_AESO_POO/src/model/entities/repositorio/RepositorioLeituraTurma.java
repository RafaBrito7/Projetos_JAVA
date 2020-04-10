package model.entities.repositorio;

import java.util.List;

import model.entities.Aluno;

public class RepositorioLeituraTurma {

	public void ListagemAlunos(List<Aluno> alunos) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < alunos.size(); i++) {
			sb.append(i + "- " + alunos.toString());
		}
	}
}
