package view;
import java.util.*;
import controller.*;
import observer.Observer;

public class MenuGerenteView implements Observer{
    private MenuGerenteController controller;
    private Scanner scanner;
    
    public MenuGerenteView(EstoqueController controller) {
        this.controller = new MenuGerenteController(controller);
        this.scanner = new Scanner(System.in);
    }

    // Uso da controller
    public MenuGerenteController getController() {
        return this.controller;
    }

    // Exibição do menu gerente
    public void exibirMenuGerente() {
        do {
            System.out.println("\n----- Menu do Gerente -----");
            System.out.println("1. Adicionar produto ao estoque");
            System.out.println("2. Remover produto do estoque");
            System.out.println("3. Exibir estoque");
            System.out.println("4. Exibir relatório de vendas");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            controller.escolha(opcao);

            if (opcao == 5 ) {
                break;
            }
        } while (true);
    }

    public void update(String produto) {
        System.out.println("Gerente, o produto " + produto + " está acabando no estoque!");
    }
}

