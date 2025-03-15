package fronteira;

import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.FilmeController;
import model.Ator;
import model.Filme;

public class Main {

	public static void main(String[] args) {
		FilmeController fControl = new FilmeController();
		AtorController aControl = new AtorController();

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		String nomeFilme = "";
		String nomeAtor = "";
		String opt = "";

		Filme f1 = new Filme();
		Ator a1 = new Ator();

		int escolha;

		do {
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\n\nBanco de Dados do Cinema");
			System.out.println("Digite um valor para escolher a opção: ");
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
			System.out.println("\n//////////////// Participações //////////////////\n");
			System.out.println("10 - Participação Ator no Filme");
			System.out.println("11 - Sair\n");

			System.out.print("Escolha uma opção: ");
			escolha = sc2.nextInt();

			switch (escolha) {

			case 1: // INSERIR FILME
				System.out.println("Digite o título do filme: ");
				f1.setTitulo(sc.nextLine());

				System.out.println("Digite o diretor do filme: ");
				f1.setNomeDiretor(sc.nextLine());

				fControl.inserirFilme(f1);

				break;

			case 2: // PESQUISAR FILME
				System.out.println("Digite um título de filme para pesquisar: ");
				nomeFilme = sc.nextLine();

				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);

				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("#" + filme.getId() + " | Título: " + filme.getTitulo() + " | Diretor: "
								+ filme.getNomeDiretor());
					}
				} else {
					System.out.println("Filme(s) não encontrado(s)");
				}

				break;

			case 3: // LISTAR TODOS FILMES
				System.out.println("Lista de Filmes Disponíveis: ");

				filmes = fControl.pesquisarTodos();

				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("#" + filme.getId() + " | Título: " + filme.getTitulo() + " | Diretor: "
								+ filme.getNomeDiretor());
					}
				} else {
					System.out.println("Filme(s) não encontrado(s)");
				}

				break;

			case 4: // ATUALIZAR FILME
				System.out.println("Digite o ID do filme que deseja atualizar: ");
				f1.setId(sc.nextLong());

				System.out.println("Digite o novo título do filme: ");
				f1.setTitulo(sc.nextLine());

				System.out.println("Digite o novo diretor do filme: ");
				f1.setNomeDiretor(sc.nextLine());

				fControl.atualizar(f1);

				break;

			case 5: // REMOVER FILME
				System.out.println("Digite o ID do filme que deseja remover: ");
				fControl.apagar(sc.nextLong());

				break;

			case 6: // INSERIR ATOR(A)
				a1.setId(0);
				System.out.println("Digite o nome do ator(a): ");
				a1.setNome(sc.nextLine());

				System.out.println("Digite o país de origem do ator(a): ");
				a1.setPais(sc.nextLine());

				aControl.inserir(a1);

				break;

			case 7: // PESQUISAR ATOR(A)
				System.out.println("Digite um nome de ator(a) para pesquisar: ");
				nomeAtor = sc.nextLine();

				List<Ator> atores = aControl.pesquisarPorNome(nomeAtor);

				if (!(atores.isEmpty())) {
					for (Ator ator : atores) {
						System.out.println(
								"#" + ator.getId() + " | Nome: " + ator.getNome() + " | País: " + ator.getPais());
					}
				} else {
					System.out.println("Ator(a) não encontrado(a)");
				}

				break;

			case 8: // REMOVER ATOR
				System.out.println("Digite o ID de um(a) ator(a) que deseja remover: ");
				aControl.remover(sc.nextLong());

				break;

			case 9: // ATUALIZAR ATOR
				System.out.println("Digite o ID de um(a) ator(a) que deseja atualizar: ");
				a1.setId(sc.nextLong());

				System.out.println("Digite o novo nome do(a) autor(a): ");
				a1.setNome(sc.nextLine());

				System.out.println("Digite o novo país de origem do(a) autor(a): ");
				a1.setPais(sc.nextLine());

				aControl.atualizar(a1);

				break;

			case 10: // PARTICIPAÇÃO DO ATOR(A) EM UM FILME
				System.out.println("Participação do ator no filme ");

				break;

			case 11:
				System.out.println("ENCERRANDO APLICAÇÃO!");

				break;

			default:
				System.out.println("Opção inválida! Tente novamente!");

				
			case -1:
				System.out.println("ENCERRANDO APLICAÇÃO!");
				escolha = 11;
				break;
			}
		} while (escolha != 11);

		sc.close();
		sc2.close();
	}
}
