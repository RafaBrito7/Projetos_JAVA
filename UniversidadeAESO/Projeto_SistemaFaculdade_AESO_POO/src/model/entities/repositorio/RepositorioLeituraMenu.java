package model.entities.repositorio;

public class RepositorioLeituraMenu implements InterfaceLeitura {
	
	public int lerMenuPrincipal () {
		System.out.println("Escolha o que deseja fazer:");
		System.out.println("[0] - Cadastrar Alunos");
		System.out.println("[1] - Cadastrar Professores");
		System.out.println("[2] - Cadastrar Disciplinas");
		System.out.println("[3] - Cadastrar Turma");
		System.out.println("[9] - Sair");
		int escolhaMenu = sc.nextInt();
		return escolhaMenu;
	}
	
	public int lerMenuAluno () {
		System.out.println("");
		System.out.println("Escolha o que deseja fazer:");
		System.out.println("[0] - Cadastrar outro Aluno");
		System.out.println("[9] - Retornar ao Menu Principal");
		int escolhaMenu = sc.nextInt();
		return escolhaMenu;
	}
	
	public int lerMenuProfessor () {
		System.out.println("");
		System.out.println("Escolha o que deseja fazer:");
		System.out.println("[0] - Cadastrar outro Professor");
		System.out.println("[9] - Retornar ao Menu Principal");
		int escolhaMenu = sc.nextInt();
		return escolhaMenu;
	}

}
