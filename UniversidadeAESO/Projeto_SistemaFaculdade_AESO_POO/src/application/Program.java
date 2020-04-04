package application;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.exception.DomainException;

import model.service.Mensagens;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws DomainException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Mensagens msg = new Mensagens();
		
		System.out.println("Bem vindo a versão Alfa do WhiteBoard!");
		System.out.println("");
		System.out.println(msg.mensagem(0));
		int escolha = sc.nextInt();
		
		try {
			if (escolha == 0) {
				System.out.println("");
				
			} else if (escolha == 1) {
				System.out.println("");
				
			} else if (escolha == 2) {
				System.out.println("");
				
			}  else
				throw new DomainException("Número inválido!");
			
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage() + " Escolha entre as opções 0,1,2.");
		}
		
		
		sc.close();
	}
	
	

}
