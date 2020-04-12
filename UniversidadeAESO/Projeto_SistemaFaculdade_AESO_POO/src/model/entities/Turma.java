package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private Integer id;
	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> aluno = new ArrayList<>();
	private Integer capacidadeTurma;
	
	public Turma(Integer id, Disciplina disciplina, Professor professor, Integer capacidadeTurma) {
		this.id = id;
		this.disciplina = disciplina;
		this.professor = professor;
		this.capacidadeTurma = capacidadeTurma;
	}
	
	public Turma() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
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
	
	public void adicionarAluno(Aluno aluno) {
		this.aluno.add(aluno);
	}
	
	public String toString() {
		return "---------------[Turma A]---------------" + "\n\n"
				+ "ID: " + getId() + " - Disciplina: " + getDisciplina().getNome() + "(id: " + getDisciplina().getId()
				+ ")\n" + "Professor: " + getProfessor().getNome() + "(id: " + getProfessor().getId() + ").\n" 
				+ "Capacidade da Turma: " + getCapacidadeTurma() + "\nListagem de Alunos: "
				;
	}
	
}
