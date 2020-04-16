package model.entities;

public class RendimentoEscolar {
	private Turma turma;
	private Aluno aluno;
	private Float nota1;
	private Float nota2;
	private Float nota3;
	private String trabalhos[] = new String [3];
	private Float trabalhosNotas[] = new Float[3];
	private String projeto;
	private Float projetoNota;
	
	public RendimentoEscolar(Turma turma, Aluno aluno, Float nota1, Float nota2, Float nota3, String[] trabalhos,
			Float[] trabalhosNotas, String projeto, Float projetoNota) {
		this.turma = turma;
		this.aluno = aluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.trabalhos = trabalhos;
		this.trabalhosNotas = trabalhosNotas;
		this.projeto = projeto;
		this.projetoNota = projetoNota;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Float getNota1() {
		return nota1;
	}

	public void setNota1(Float nota1) {
		this.nota1 = nota1;
	}

	public Float getNota2() {
		return nota2;
	}

	public void setNota2(Float nota2) {
		this.nota2 = nota2;
	}

	public Float getNota3() {
		return nota3;
	}

	public void setNota3(Float nota3) {
		this.nota3 = nota3;
	}

	public String[] getTrabalhos() {
		return trabalhos;
	}

	public void setTrabalhos(String[] trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Float[] getTrabalhosNotas() {
		return trabalhosNotas;
	}

	public void setTrabalhosNotas(Float[] trabalhosNotas) {
		this.trabalhosNotas = trabalhosNotas;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public Float getProjetoNota() {
		return projetoNota;
	}

	public void setProjetoNota(Float projetoNota) {
		this.projetoNota = projetoNota;
	}
	
	

	

}
