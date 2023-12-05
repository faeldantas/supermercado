package view;

import java.util.*;
import controller.*;
import observer.Observer;

public class MenuFuncionarioView implements Observer{
    private MenuFuncionarioController controller;
    private Scanner scanner;
    public boolean isTelaHabilitada = false;

    public MenuFuncionarioView(EstoqueController controller) {
        this.scanner = new Scanner(System.in);
        this.controller = new MenuFuncionarioController(controller);
    }

    // Uso da controller
    public MenuFuncionarioController getController() {
        return this.controller;
    }
    
    // Exibição do menu funcionario
    public void exibirMenuFuncionario() {
        do {
            System.out.println("\n----- Menu do Funcionário -----");
            System.out.println("1. Exibir produtos disponíveis");
            System.out.println("2. Adicionar produto ao caixa");
            System.out.println("3. Calcular total do caixa");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            controller.escolha(opcao);

            if (opcao == 5) {
                break;
            }
        } while (true);
    }

    public void update(String produto) {
        System.out.println("Funcionário, o produto " + produto + " está acabando no estoque!");
    }
}