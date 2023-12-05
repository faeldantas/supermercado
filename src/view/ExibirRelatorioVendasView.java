package view;

import model.*;

public class ExibirRelatorioVendasView {
    
    public ExibirRelatorioVendasView() {

    }

    // Mensagem itens vazios
    public void vazio() {
        System.out.println("Nenhum registro de vendas encontrado.");
    }

    // Mensagem título 1
    public void titulo() {
        System.out.println("\n----- Relatório de Vendas -----");
    }

    // Mensagem título 2
    public void titulo2() {
        System.out.println("Produtos Vendidos:");
    }

    // Mensagem itens vendidos
    public void itens(Produto produto) {
        System.out.println("CodBarras: " + produto.getCodigoBarras() + " - Nome: " + produto.getNome() + " - Valor: R$" + produto.getValor() + " - Quantidade: " + produto.getQuantidadeProduto());
    }

    // Mensagem total de vendas
    public void venda(double total) {
        System.out.println("Total da Venda: R$" + total);
        System.out.println("--------------------");
    }
        
    
}
