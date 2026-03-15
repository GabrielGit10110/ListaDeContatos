package projeto.contato;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe principal responsável por toda a parte visual do programa.
 *
 * @author Olima
 */
public class ContatoView {
	private static List<Contato> contatos = new LinkedList<>();

	public static Contato buscar(Scanner input) {
		System.out.println("Digite o nome a ser encontrado: ");
		String nome = input.nextLine();
		for (Contato c : contatos) {
			if (c.getNome().equals(nome)) {
				System.out.println("Contato "+
						"encontrado!");
				return c;

			}

		}

		System.out.println("Contato nao encontrado...");
		return null;

	}

	private static Contato buscar(String nome) {
		for (Contato c : contatos) {
			if (c.getNome().equals(nome)) {
				System.out.println("Contato "+
						"encontrado!");
				return c;

			}

		}

		System.out.println("Contato nao encontrado...");
		return null;

	}


	/** 
	 * Cria um novo contato e o adiciona a lista de contatos
	 *
	 * @param input Usado para permitir digitação de dados.
	 *
	 */
	public static void criar(Scanner input) {
		Contato contato = new Contato();
		String msg = "Digite o ";

		System.out.println(msg+"nome: ");
		String nome = input.nextLine();
		contato.setNome(nome);

		System.out.println(msg+"email: ");
		String email = input.nextLine();
		contato.setEmail(email);

		System.out.println(msg+"fone: ");
		String fone = input.nextLine();
		contato.setFone(fone);

		System.out.println("Digite a data de nascimento"+
				"(dd/MM/yyyy): ");
		String data = input.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("dd/MM/yyyy");
		LocalDate dataNascimento = LocalDate
			.parse(data, formatter);
		contato.setDataNascimento(dataNascimento);

		contatos.add(contato);
	}

	/** 
	 * Remove um contato da lista de contatos
	 *
	 * @param input Usado para permitir digitação de dados.
	 *
	 */
	public static void remover(Scanner input) {
		System.out.println("Digite o nome do contato a ser "+
				"removido: ");
		String nome = input.nextLine();

		Iterator<Contato> iterator = contatos.iterator();
		boolean removido = false;

		while(iterator.hasNext()) {
			Contato c = iterator.next();
			if (c.getNome().equals(nome)) {
				iterator.remove();
				removido = true;
			}

		}

		if (removido) {
			System.out.println("Removido...");

		} else {
			System.out.println("Nao encontrado...");

		}
	}

	
	/**
	 * Lista todos os contatos da lista de contatos
	 *
	 */
	public static void listar() {
		StringBuilder lista = new StringBuilder("Contatos: \n");

		for (Contato c : contatos) {
			lista.append("Nome: ")
				.append(c.getNome())
				.append("\n");
			lista.append("Email: ")
				.append(c.getEmail())
				.append("\n");
			lista.append("N° Telefone: ")
				.append(c.getFone())
				.append("\n");
			lista.append("Data de Nascimento: ")
				.append(c.getDataNascimento())
				.append("\n").append("\n");

		}

		String exibir = lista.toString();
		System.out.println(exibir);
	}

	private static void selectEditOptions(char opt, Contato contato,
			Scanner input) {



		System.out.println("Digite a data de nascimento"+
				"(dd/MM/yyyy): ");

		switch(opt) {
			case 'N':
				System.out.println("Digite o novo "+
						"nome: ");
				String nome = input.nextLine();
				contato.setNome(nome);
				break;

			case 'E':
				System.out.println("Digite o novo "+
						"email: ");
				String email = input.nextLine();
				contato.setEmail(email);
				break;

			case 'T':
				System.out.println("Digite o novo "+
						"numero de telefone: ");
				String fone = input.nextLine();
				contato.setFone(fone);

				break;

			case 'D':
				System.out.println("Digite a nova "+
						"data (dd/MM/yyyy): ");
				String data = input.nextLine();
				DateTimeFormatter formatter = 
					DateTimeFormatter
					.ofPattern("dd/MM/yyyy");
				LocalDate dataNascimento = 
					LocalDate.parse(data,
						formatter);
				contato.setDataNascimento(
					dataNascimento);
				break;

			case 'S':
				System.out.println("Terminando "+
						"edicao...");
				break;

			default:
				System.out.println("Opcao invalida...");
		}

	}
 
	/**
	 * Edita um contato da lista de contatos.
	 *
	 * @param input Usado para permitir digitação de dados.
	 *
	 */
	public static void editar(Scanner input) {
		System.out.println("Digite o nome do contato a ser "+
				"editado: ");
		String nome = input.nextLine();
		Contato contato = buscar(nome);
		String menuEdicao = """
			== EDITAR: 	   ##
			(N)ome.		   ##
			(E)mail.	   ##
			(T)elefone.	   ##
			(D)ata nascimento. ##
			(S)air. 	   ##
			""";
		String opcaoSelecionada = "";
		char opt = '\u0000';

		do {
			System.out.println(menuEdicao);
			opcaoSelecionada = input.nextLine();
			opt = opcaoSelecionada.toUpperCase().charAt(0);

			selectEditOptions(opt, contato, input);
		} while(opt != 'S');

	}
	

	/**
	 * Seleciona as opções do menu.
	 *
	 * @param opt A opção digitada.
	 * @param input Usado em outros métodos.
	 *
	 */
	private static void selectOptions(char opt, Scanner input) {
		switch (opt) {
			case 'B':
				buscar(input);
				break;

			case 'C':
				criar(input);
				break;

			case 'E':
				editar(input);
				break;

			case 'L': 
				listar();
				break;

			case 'R':
				remover(input);
				break;

			case 'S':
				System.out.println("Finalizando...");
				break;
			default:
				System.out.println("Opcao invalida: "+
						opt);
		}

	}


	public static void menu() {
		String options = """
			== MENU CONTATOS:   ##
			(B)uscar  contato.  ##
			(C)riar   contato.  ##
			(E)ditar  contato.  ##
			(L)istar  contatos. ##
			(R)emover contato.  ##
			(S)air.             ##
			""";
		char opt = '\u0000';
		String selectedOption = "";
		Scanner input = new Scanner(System.in);

		do {
			System.out.println(options);
			selectedOption = input.nextLine();
			opt = selectedOption.toUpperCase().charAt(0);

			selectOptions(opt, input);

		} while (opt != 'S');

		input.close();

	}


	public static void main(String[] args) {
	    menu();

	}
}
