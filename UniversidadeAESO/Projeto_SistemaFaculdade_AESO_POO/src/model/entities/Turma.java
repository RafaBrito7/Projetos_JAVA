package model.entities;

import java.util.List;

public class Turma {
	private Integer id;
	//private List<Disciplina> disciplina;
	//private List<Professor> professor;
	private List<Aluno> aluno;
	private Integer capacidadeTurma;
	
	public Turma(Integer id,Integer capacidadeTurma) {
		this.id = id;
		this.capacidadeTurma = capacidadeTurma;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	public Integer getCapacidadeTurma() {
		return capacidadeTurma;
	}

	public void setCapacidadeTurma(Integer capacidadeTurma) {
		this.capacidadeTurma = capacidadeTurma;
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}

	
	
}
