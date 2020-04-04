package model.entities;

import java.util.List;

public class Turma {
	private Integer id;
	private List<Disciplina> disciplina;
	private List<Professor> professor;
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

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
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

	
	
}
