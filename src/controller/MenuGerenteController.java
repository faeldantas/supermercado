package controller;

import view.*;

public class MenuGerenteController {
    private EstoqueController controller;
    private AdicionarProdutoEstoqueView viewAdd;
    private ExibirEstoqueView viewExibir;
    private RemoverProdutoEstoqueView viewRemover;

    public MenuGerenteController(EstoqueController controller) {
        this.controller = controller;
        this.viewAdd = new AdicionarProdutoEstoqueView();
        this.viewExibir = new ExibirEstoqueView();
        this.viewRemover = new RemoverProdutoEstoqueView(controller);
    }

    // Switch para escolher a opção
    public void escolha(int opcao) {
        switch (opcao) {
            case 1:
                controller.adicionarProdutoEstoque(viewAdd.adicionarProdutoEstoque());
                viewAdd.confirmarAdicao();
                break;
            case 2:
                int codigoBarras = viewRemover.lerCodigoBarra();
                int quantidadeProdutoRemover = viewRemover.lerQuantidadeProduto();
                viewRemover.validarRemocao(controller.removerProdutoEstoque(codigoBarras, quantidadeProdutoRemover));
                break;
            case 3:
                viewExibir.exibirEstoque(controller.getEstoque());
                break;
            case 4:
                controller.exibirRelatorioVendas();
                break;
            case 5:
                break;
        }
    }
}