package model.entities.repositorio;

import model.entities.Disciplina;

//Classe para Leitura de todos os Dados de uma nova Disciplina
public class RepositorioLeituraDisciplina  implements InterfaceLeitura {
	public Disciplina lerDados() {
		System.out.println("[CADASTRO DE DISCIPLINA]");
		System.out.print("Número da ID: ");
		int id = sc.nextInt();
		System.out.print("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Ementa: ");
		String ementa = sc.nextLine();
		
		return new Disciplina(id, nome, ementa);
	}

}
