package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private Integer id;
	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> aluno = new ArrayList<>();
	private Integer capacidadeTurma;

	public Turma(Disciplina disciplina, Professor professor) {
		this.disciplina = disciplina;
		this.professor = professor;
	}

	public Turma(Integer id, Integer capacidadeTurma) {
		this.id = id;
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
		return "---------------[Turma 1]---------------" + "\n\n" + "ID: " + getId() + ", Capacidade da Turma: "
				+ getCapacidadeTurma() + "\nListagem de Alunos: ";
	}

	public String mostrarListaAluno() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Aluno listaAlunos : aluno) {
			sb.append(++i + "- " + listaAlunos.toString() + "\n\n");
		}
		return sb.toString();
	}
	
	public String toString2 () {
		return "Disciplina: "
				+ disciplina.getNome() + "(id:" + disciplina.getId() + ")\n" + "Professor: "
				+ professor.getNome() + "(id:" + professor.getId() + ").\n";
	}

}
