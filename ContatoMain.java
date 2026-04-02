package ListaContato;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContatoMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Contato> listaContato = new ArrayList<Contato>();
		
		mostrarMenu(sc, listaContato);
	}
	
	public static void mostrarMenu(Scanner sc, ArrayList<Contato> listaContato) {
		int opcao = -1;
		do {
			System.out.println("\n--- MENU ---");
			System.out.println("Digite 1 para adicionar contato.");
			System.out.println("Digite 2 para remover contato.");
			System.out.println("Digite 3 para ver a lista de contatos.");
			System.out.println("Digite 0 para sair");
			
			try {
				opcao = sc.nextInt();
				sc.nextLine();
				if(opcao < 0 || opcao > 3) {
					System.out.println("Erro. Digite uma opção entre 0 e 3.");
				} 
			} catch(InputMismatchException e) {
				System.out.println("Digite um número entre 0 e 3.");
				sc.nextLine();
			}
			
			switch(opcao) {
			case(1):
				adicionarContato(sc, listaContato);
				break;
			case(2):
				removerContato(sc,listaContato);
				break;
			case(3):
				listarContatos(listaContato);
				break;
			}
		}while(opcao != 0);
	}
	
	public static void adicionarContato(Scanner sc, ArrayList<Contato> listaContato) {
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		
		Telefone tel = new Telefone();
		System.out.println("DDD: ");
		tel.setDdd(sc.nextLine());
		System.out.println("Número: ");
		tel.setNum(sc.nextLine());
		
		System.out.println("Email: ");
		String email = sc.nextLine();
		
		Contato c = new Contato();
		c.setNome(nome);
		c.setTel(tel);
		c.setEmail(email);
		
		listaContato.add(c);
	}
	
	public static void listarContatos(ArrayList<Contato> listaContato) {
		if(listaContato.isEmpty()) {
			System.out.println("A lista está vazia");
			return;
		}
		for(int i = 0; i < listaContato.size(); i++) {
			System.out.println((i + 1) + " - " + listaContato.get(i));
		}
	}
	
	public static void removerContato(Scanner sc, ArrayList<Contato> listaContato) {
		if(listaContato.isEmpty()) {
			System.out.println("A lista está vazia");
			return;
		}
		
		int pos = -1;
		System.out.println("Digite a posição do contato a ser removido: ");
		
		try {
			pos = sc.nextInt();
			if((pos <= 0) || (pos > listaContato.size())) {
				System.out.println("Posição inválida. Digite uma posição existente.");
				sc.nextLine();
			} else {
				listaContato.remove(pos -1);
				System.out.println("Contato removido com sucesso!");
			}
			
		} catch(InputMismatchException e) {
			System.out.println("Erro! Digite o número da posição do contato a ser removido.");
			sc.nextLine();
		}
	}
}
