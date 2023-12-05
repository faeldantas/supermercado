package view;

import java.util.*;

public class AdicionarProdutoCaixaView {
    private Scanner scanner;

    public AdicionarProdutoCaixaView() {
        this.scanner = new Scanner(System.in);
    }

    // Leitura de código de barras
    public int lerCodigoBarras() {
        System.out.print("Digite o código de barras do produto: ");
        int codigoBarras = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        return codigoBarras;
    }

    // Leitura quantidade do produto
    public int lerQuantidadeProtudo() {
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        return quantidade;
    }

    // Mensagem produto adicionado
    public void exibirMensagemProdutoAdicionado() {
        System.out.println("Produto adicionado ao caixa.");
    }

    // Mensagem produto não encontado
    public void exibirMensagemProdutoNaoEncontrado() {
        System.out.println("Produto não encontrado no estoque.");
    }

    // Mensagem produto indisponível
    public void exibirMensagemProdutoIndisponivel() {
        System.out.println("Quantidade desejada indisponível no estoque.");
    }
}