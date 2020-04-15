package model.entities.repositorio;

import model.entities.Turma;

public class RepositorioLeituraTurma implements InterfaceLeitura {
	
	public Turma lerDadosInicial() {
		System.out.println("[Cadastro Nova Turma]");
		System.out.print("Informe o ID: ");
		int id = sc.nextInt();
		System.out.print("Informa a Capacidade Máxima da turma: ");
		int capacidadeTurma = sc.nextInt();
		
		return new Turma(id, capacidadeTurma);
	}

}
