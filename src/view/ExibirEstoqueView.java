package view;

import java.util.*;

import model.*;

public class ExibirEstoqueView {

    public ExibirEstoqueView() {
    }

    // Exibir estoque
    public void exibirEstoque(List<Produto> estoque) {
        System.out.println("\n----- Estoque do Supermercado -----");
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Estoque:");
            for (Produto produto : estoque) {
                System.out.println(produto.toString());
            }
        }
    }
}
