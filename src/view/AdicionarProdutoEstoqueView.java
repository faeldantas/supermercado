package view;

import model.*;
import java.util.*;

public class AdicionarProdutoEstoqueView {
    private Scanner scanner;

    public AdicionarProdutoEstoqueView() {
        this.scanner = new Scanner(System.in);
    }
        
    // Leitura adicionar produto
    public Produto adicionarProdutoEstoque() {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Digite o código de barras: ");
        int codigoBarras = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado
        
        return new Produto(nomeProduto, codigoBarras, valor, quantidadeProduto);
    }

    // Mensagem de adição
    public void confirmarAdicao() {
        System.out.println("Produto adicionado ao estoque com sucesso!");
    }
}