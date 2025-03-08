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

		String nomeFilme = "";
		String nomeAtor = "";
		String opt = "";

		Filme f1 = new Filme();
		Ator a1 = new Ator();

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
			escolha = sc.nextInt();

			switch (escolha) {

			case 1: // INSERIR FILME
				System.out.println("Digite o t�tulo do filme: ");
				opt = sc.nextLine();
				f1.setTitulo(opt);

				System.out.println("Digite o diretor do filme: ");
				opt = sc.nextLine();

				fControl.inserirFilme(f1);

				break;

			case 2: // PESQUISAR FILME
				System.out.println("Digite um t�tulo de filme para pesquisar: ");
				nomeFilme = sc.nextLine();

				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);

				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("#" + filme.getId() + " | T�tulo: " + filme.getTitulo() + " | Diretor: "
								+ filme.getNomeDiretor());
					}
				} else {
					System.out.println("Filme(s) n�o encontrado(s)");
				}

				break;

			case 3: // LISTAR TODOS FILMES
				System.out.println("Lista de Filmes Dispon�veis: ");

				filmes = fControl.pesquisarTodos();

				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes) {
						System.out.println("#" + filme.getId() + " | T�tulo: " + filme.getTitulo() + " | Diretor: "
								+ filme.getNomeDiretor());
					}
				} else {
					System.out.println("Filme(s) n�o encontrado(s)");
				}

				break;

			case 4: // ATUALIZAR FILME
				System.out.println("Digite o ID do filme que deseja atualizar: ");
				long id = sc.nextLong();
				f1.setId(id);
				System.out.println("Digite o novo t�tulo do filme: ");
				opt = sc.nextLine();
				f1.setTitulo(opt);

				System.out.println("Digite o novo diretor do filme: ");
				opt = sc.nextLine();
				fControl.atualizar(f1);

				break;

			case 5: // REMOVER FILME
				System.out.println("Digite o ID do filme que deseja remover: ");
				id = sc.nextLong();
				fControl.apagar(id);

				break;

			case 6: // INSERIR ATOR(A)
				a1.setId(0);
				System.out.println("Digite o nome do ator(a): ");
				opt = sc.nextLine();
				a1.setNome(opt);

				System.out.println("Digite o pa�s de origem do ator(a): ");
				opt = sc.nextLine();
				a1.setPais(opt);

				aControl.inserir(a1);

				break;

			case 7: // PESQUISAR ATOR(A)
				System.out.println("Digite um nome de ator(a) para pesquisar: ");
				nomeAtor = sc.nextLine();

				List<Ator> atores = aControl.pesquisarPorNome(nomeAtor);

				if (!(atores.isEmpty())) {
					for (Ator ator : atores) {
						System.out.println(
								"#" + ator.getId() + " | Nome: " + ator.getNome() + " | Pa�s: " + ator.getPais());
					}
				} else {
					System.out.println("Ator(a) n�o encontrado(a)");
				}

				break;

			case 8: // REMOVER ATOR
				System.out.println("Digite o ID de um(a) ator(a) que deseja remover: ");
				id = sc.nextLong();
				aControl.remover(id);

				break;

			case 9: // ATUALIZAR ATOR
				System.out.println("Digite o ID de um(a) ator(a) que deseja atualizar: ");
				id = sc.nextLong();
				a1.setId(id);

				System.out.println("Digite o novo nome do(a) autor(a): ");
				opt = sc.nextLine();
				a1.setNome(opt);

				System.out.println("Digite o novo pa�s de origem do(a) autor(a): ");
				opt = sc.nextLine();

				aControl.atualizar(a1);

				break;

			case 10: // PARTICIPA��O DO ATOR(A) EM UM FILME
				System.out.println("Participa��o do ator no filme ");

				break;

			case 11:
				System.out.println("ENCERRANDO APLICA��O!");
				
				break;
				
			default:
				System.out.println("Op��o inv�lida! Tente novamente!");
			}
		} while (escolha != 11);

		sc.close();
	}
}
