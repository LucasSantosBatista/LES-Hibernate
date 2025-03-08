package fronteira;


import java.util.List;
import java.util.Scanner;

import controller.FilmeController;
import model.Filme;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nomeFilme;
		Filme f1 = new Filme ( );
		FilmeController fControl = new FilmeController();
		int escolha;

		do {
			System.out.println("\n\nBem Vindo(a) ao Banco de Dados do Cinema");
			System.out.println("Digite um valor para escolher a op��o: ");
			System.out.println("\n//////////////// Filme //////////////////\n");
			System.out.println("1 - Inserir Filme");
			System.out.println("2 - Pequisar um Filme");
			System.out.println("3 - Listar Todos");
			System.out.println("4 - Atualizar um Filme");
			System.out.println("5 - Apagar um Filme");
			System.out.println("\n//////////////// Ator //////////////////\n");
			System.out.println("6 - Inserir Ator");
			System.out.println("7 - Pequisar um Ator");
			System.out.println("8 - Apagar um Ator");
			System.out.println("9 - Atualizar um Ator");
			System.out.println("\n//////////////// Participa��es //////////////////\n");
			System.out.println("10 - Participa��o Ator no Filme");
			System.out.println("11 - Sair");
			System.out.print("\n");

			System.out.print("Escolha uma op��o: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:// utilize o Scanner para captar dados
				System.out.println("Inserir Filme");
				f1.setId(0);
				f1.setTitulo("Cidade de Deus");
				f1.setNomeDiretor("Ze Trindade");
				fControl.inserirFilme(f1);		
				break;
				
			case 2:
				System.out.println("Pesquisar um filme = ");
				nomeFilme = scanner.next();
				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Nome: " + filme.getTitulo() + " Id= " + filme.getId()+ " Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("N�o encontrou o Filme");
				scanner.nextLine();
				break;
				
			case 3:
				System.out.println("Listando Todos os Filmes");
				filmes = fControl.pesquisarTodos();	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Id= " + filme.getId() + " Nome: " + filme.getTitulo() + ", Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("N�o encontrou o Filme");
				break;
				
			case 4:
				System.out.println("Escolha um filme para atualizar ");
				long id = scanner.nextLong();
				f1.setId(id);
				f1.setTitulo("Terminator");
				f1.setNomeDiretor("James Cammeron");
				fControl.atualizar(f1);
				break;
			case 5:
				System.out.println("Escolha um filme para apagar ");
				 id = scanner.nextLong();
				fControl.apagar(id);
				break;	
			case 6:
				System.out.println("Inserir ator ");
//				long id = scanner.nextLong();
//				fControl.apagar(id);
				break;
			case 7:
				System.out.println("Pesquisar ator ");
				
				break;
			case 8:
				System.out.println("Escolha um ator para apagar ");
				
				break;
			case 9:
				System.out.println("Escolha um ator para atualizar ");
				
				break;
			case 10:
				System.out.println("Participa��o do ator no filme ");
				
				break;
				
				
			case 11:
				System.out.println("Saindo do menu.");
				break;
			default:
				System.out.println("Op��o inv�lida"
						+ ". Tente novamente.");
			}
		} while (escolha != 11);

		scanner.close();
	}
}


