package view;

import java.util.*;
import controller.*;

public class RemoverProdutoEstoqueView {
    private Scanner scanner;
    
    public RemoverProdutoEstoqueView(EstoqueController controller) {
        this.scanner = new Scanner(System.in);
    }
    
    // Validação da remoção
    public void validarRemocao(boolean removido) {
        if (removido) {
            exibirMensagemProdutoRemovido();
        } else {
            exibirMensagemProdutoNaoEncontrado();
        }
    }

    // Leitura código de barras
    public int lerCodigoBarra() {
        System.out.print("Digite o código de barras do produto: ");
        int codigoBarrasRemover = scanner.nextInt();
        scanner.nextLine();
        return codigoBarrasRemover;
    }

    // Leitura quantidade de produtos
    public int lerQuantidadeProduto() {
        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProdutoRemover = scanner.nextInt();
        scanner.nextLine();
        return quantidadeProdutoRemover;
    }

    // Mensagem produto removido do estoque
    private void exibirMensagemProdutoRemovido() {
        System.out.println("Produto removido do estoque com sucesso!");
    }

    // Mensagem produto não encontrado
    private void exibirMensagemProdutoNaoEncontrado() {
        System.out.println("Produto não encontrado no estoque.");
    }
}
