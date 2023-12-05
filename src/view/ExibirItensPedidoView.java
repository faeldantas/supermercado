package view;

import model.*;

public class ExibirItensPedidoView {
    
    public ExibirItensPedidoView() {

    }

    // Exibir produto
    public void exibirProduto(Produto produto) {
        System.out.println("CodBarras: " + produto.getCodigoBarras() + " - Nome: " + produto.getNome() + " - Valor: R$" + produto.getValor() + " - Quantidade: " + produto.getQuantidadeProduto());
    }

    // Mensagem caixa vazio
    public void caixaVazio() {
        System.out.println("Caixa vazio.");
    }

    // Mensagem titulo
    public void inicioItens() {
        System.out.println("\n----- Itens do Pedido -----");
    }
}
