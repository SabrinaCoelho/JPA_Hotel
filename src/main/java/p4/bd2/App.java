package p4.bd2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();


		Scanner scanner = new Scanner(System.in);
		boolean sair = false;

		while (!sair) {
			System.out.println("==| Menu |==");
			System.out.println("1. Criar");
			System.out.println("2. Pesquisar");
			System.out.println("3. Deletar");
			System.out.println("4. Exibir cadastros");
			System.out.println("5. Sair");
			System.out.print("> ");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				// Criar
				System.out.println("Escolha uma op��o:");
				System.out.println("1. Quarto");
				System.out.println("2. Titular");
				System.out.println("3. Hotel");
				System.out.print("Op��o: ");
				int criarOpcao = scanner.nextInt();
				scanner.nextLine();

				switch (criarOpcao) {
					case 1:
						// L�gica para criar um novo quarto
						System.out.println("===== Criar Quarto =====");
				        System.out.print("N�mero: ");
				        int numero = scanner.nextInt();
				        
				        Quarto quarto = em.find(Quarto.class, numero);
				        if(quarto != null){
							System.out.println("Quarto j� cadastrado.");
							System.out.println(quarto.toString());
							break;
						}
	
				        System.out.print("Andar: ");
				        int andar = scanner.nextInt();
				        scanner.nextLine(); // Limpa o buffer do scanner
	
				        System.out.print("Pr�dio: ");
				        String predio = scanner.nextLine();
	
				        System.out.print("Pre�o: ");
				        float preco = scanner.nextFloat();
				        scanner.nextLine(); // Limpa o buffer do scanner
	
				        System.out.print("Cama: ");
				        String cama = scanner.nextLine();
	
				        System.out.print("Tipo: ");
				        String tipo = scanner.nextLine();
	
				        System.out.print("Capacidade: ");
				        int capacidade = scanner.nextInt();
				        scanner.nextLine(); // Limpa o buffer do scanner
	
				        System.out.print("Disponibilidade (true/false): ");
				        boolean disponibilidade = scanner.nextBoolean();
	
				        // Cria��o do objeto Quarto
				        
				        quarto = new Quarto(numero, andar, predio, preco, cama, tipo, capacidade, disponibilidade);
				        em.getTransaction().begin();
				        em.persist(quarto);
				        em.getTransaction().commit();
				        // Exibe as informa��es do quarto criado
				        System.out.println("\nQuarto criado com sucesso:");
				        System.out.println(quarto);
	
						break;
					case 2:
						// L�gica para criar um novo titular
						System.out.println("===== Criar Titular =====");
				        System.out.print("CPF: ");
				        String cpf = scanner.nextLine();
				        
				        Titular titular = em.find(Titular.class, cpf);
				        if(titular != null){
							System.out.println("Titular j� cadastrado.");
							System.out.println(titular.toString());
							break;
						}
	
				        System.out.print("Nome: ");
				        String nome = scanner.nextLine();
	
				        System.out.print("Email: ");
				        String email = scanner.nextLine();
	
				        System.out.print("Endere�o: ");
				        String endereco = scanner.nextLine();
	
				        System.out.print("Telefone: ");
				        String telefone = scanner.nextLine();
	
				        // Cria��o do objeto Titular
				        titular = new Titular(cpf, nome, email, endereco, telefone);
				        em.getTransaction().begin();
				        em.persist(titular);
				        em.getTransaction().commit();
				        // Exibe as informa��es do titular criado
				        System.out.println("\nTitular criado com sucesso:");
				        System.out.println(titular);
						break;
					case 3:
						// L�gica para criar um novo hotel
						System.out.println("===== Criar Hotel =====");
				        System.out.print("CNPJ: ");
				        String cnpj = scanner.nextLine();
				        
				        Hotel hotel = em.find(Hotel.class, cnpj);
						if(hotel != null){
							System.out.println("Hotel j� cadastrado.");
							System.out.println(hotel.toString());
							break;
						}
						
				        System.out.print("N�mero de Pr�dios: ");
				        int predios = scanner.nextInt();
				        scanner.nextLine(); // Limpa o buffer do scanner
	
				        System.out.print("Telefone: ");
				        String telefoneAux = scanner.nextLine();
	
				        // Cria��o do objeto Hotel
				        hotel = new Hotel(cnpj, predios, telefoneAux);
				        em.getTransaction().begin();
				        em.persist(hotel);
				        em.getTransaction().commit();
				        // Exibe as informa��es do hotel criado
				        System.out.println("\nHotel criado com sucesso:");
				        System.out.println(hotel);
	
						break;
					default:
						System.out.println("Op��o inv�lida. Tente novamente.");
						break;
				}
				break;
			case 2:
				// Pesquisar
				System.out.println("Escolha uma op��o:");
				System.out.println("1. Quarto");
				System.out.println("2. Titular");
				System.out.println("3. Hotel");
				System.out.print("Op��o: ");
				int pesquisarOpcao = scanner.nextInt();
				scanner.nextLine();

				switch (pesquisarOpcao) {
					case 1:
						// L�gica para pesquisar um quarto
						/*
						System.out.println("N�mero do pr�dio:");
						String numPredio = scanner.next();
						System.out.println("N�mero do andar:");
						String numAndar = scanner.next();
						System.out.println("N�mero do quarto:");
						int numQuarto = scanner.nextInt();
						scanner.nextLine();
						numQuarto = Quarto.verificacaoNumQuarto(numQuarto);
						String numQuartoStr = Integer.toString(numQuarto);
						String aux = numPredio + numAndar + numQuarto;
						*/
						int idQuarto = verificaNumQuarto(scanner);
						Quarto quarto = em.find(Quarto.class, idQuarto);
						
						/**/
						/*
						System.out.println("N�mero do quarto:");
				        int numQuarto = scanner.nextInt();
				        scanner.nextLine();
						Quarto quarto = em.find(Quarto.class, numQuarto);
						*/
						if(quarto != null){
							System.out.println(quarto.toString());
						}else {
							System.out.println("Quarto n�o encontrado.");
						}
						break;
					case 2:
						// L�gica para pesquisar um titular
						System.out.println("CPF do titular:");
				        String cpfTitular = scanner.nextLine();
						Titular titular = em.find(Titular.class, cpfTitular);
						if(titular != null){
							System.out.println(titular.toString());
						}else {
							System.out.println("Titular n�o encontrado.");
						}
						break;
					case 3:
						// L�gica para pesquisar um hotel
						System.out.println("CNPJ do hotel:");
				        String cnpjHotel = scanner.nextLine();
						Hotel hotel = em.find(Hotel.class, cnpjHotel);
						if(hotel != null){
							System.out.println(hotel.toString());
						}else {
							System.out.println("Hotel n�o encontrado.");
						}
						
						break;
					default:
						System.out.println("Op��o inv�lida. Tente novamente.");
						break;
				}
				break;
			case 3:
				// Deletar
				System.out.println("Escolha uma op��o:");
				System.out.println("1. Quarto");
				System.out.println("2. Titular");
				System.out.println("3. Hotel");
				System.out.print("Op��o: ");
				int deletarOpcao = scanner.nextInt();
				scanner.nextLine();

				switch (deletarOpcao) {
					case 1:
						// L�gica para deletar um quarto
						/*
						System.out.println("N�mero do quarto:");
				        int numQuarto = scanner.nextInt();
				        scanner.nextLine();
				        */
						int idQuarto = verificaNumQuarto(scanner);
						Quarto quarto = em.find(Quarto.class, idQuarto);
						
						if(quarto != null){
							em.getTransaction().begin();
							em.remove(quarto);
							em.getTransaction().commit();
							System.out.println("Quarto deletado com sucesso.");
						}else {
							System.out.println("Quarto n�o encontrado.");
						}
						
						break;
					case 2:
						// L�gica para deletar um titular
						System.out.println("CPF do titular:");
				        String cpfTitular = scanner.nextLine();
						Titular titular = em.find(Titular.class, cpfTitular);
						if(titular != null){
							em.getTransaction().begin();
							em.remove(titular);
							em.getTransaction().commit();
							System.out.println("Titular deletado com sucesso.");
						}else {
							System.out.println("Titular n�o encontrado.");
						}
						
						break;
					case 3:
						// L�gica para deletar um hotel
						System.out.println("CNPJ do hotel:");
				        String cnpjHotel = scanner.nextLine();
						Hotel hotel = em.find(Hotel.class, cnpjHotel);
						if(hotel != null){
							em.getTransaction().begin();
							em.remove(hotel);
							em.getTransaction().commit();
							System.out.println("Hotel deletado com sucesso.");
						}else {
							System.out.println("Hotel n�o encontrado.");
						}
						
						break;
					default:
						System.out.println("Op��o inv�lida. Tente novamente.");
						break;
				}
				break;
			case 4:
				// L�gica para exibir todos os itens cadastrados
				System.out.println("----------------------------- HOTEIS --------------------------------");
				List<Hotel> hoteis = em.createQuery("FROM " + Hotel.class.getName()).getResultList();
				if(hoteis.size() == 0) {
					System.out.println("N�o h� hoteis cadastrados.");
				}else {
					for(var i = 0; i < hoteis.size(); i++) {
						System.out.println(hoteis.get(i).toString());
					}
				}
				
				System.out.println("---------------------------- TITULARES ------------------------------");
				List<Titular> titulares = em.createQuery("FROM " + Titular.class.getName()).getResultList();
				if(titulares.size() == 0) {
					System.out.println("N�o h� titulares cadastrados.");
				}else {
					for(var i = 0; i < titulares.size(); i++) {
						System.out.println(titulares.get(i).toString());
					}
				}
				
				System.out.println("------------------------------ QUARTOS ------------------------------");
				List<Quarto> quarto = em.createQuery("FROM " + Quarto.class.getName()).getResultList();
				
				if(quarto.size() == 0) {
					System.out.println("N�o h� quartos cadastrados.");
				}else {
					for(var i = 0; i < quarto.size(); i++) {
						System.out.println(quarto.get(i).toString());
					}
				}
				
				System.out.println("----------------------------------------------------------------------");
				break;
			case 5:
				sair = true;
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Op��o inv�lida. Tente novamente.");
				break;
			}

			System.out.println();
		}

		scanner.close();
	}
	public static int verificaNumQuarto(Scanner scanner) {
		System.out.println("N�mero do pr�dio:");
		String numPredio = scanner.next();
		System.out.println("N�mero do andar:");
		String numAndar = scanner.next();
		System.out.println("N�mero do quarto:");
		int numQuarto = scanner.nextInt();
		scanner.nextLine();
		numQuarto = Quarto.verificacaoNumQuarto(numQuarto);
		String numQuartoStr = Integer.toString(numQuarto);
		String aux = numPredio + numAndar + numQuarto;
		int idQuarto = Integer.parseInt(aux);
		return idQuarto;
	}

}
