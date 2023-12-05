package controller;

import view.*;

public class MenuFuncionarioController {
    protected EstoqueController controller;
    private ExibirEstoqueView viewExibir;
    private ItensDoPedidoController itensController;
    private AdicionarProdutoCaixaView viewAdd;
    private CalcularTotalCaixaView viewCaixa;

    public MenuFuncionarioController(EstoqueController controller) {
        this.controller = controller;
        this.viewExibir = new ExibirEstoqueView();
        this.viewAdd = new AdicionarProdutoCaixaView();
        this.itensController = new ItensDoPedidoController(controller);
        this.viewCaixa = new CalcularTotalCaixaView();
    }

    // Switch para escolher a opção
    public void escolha(int opcao) {
        switch (opcao) {
            case 1:
                viewExibir.exibirEstoque(controller.getEstoque());
                break;
            case 2:
                int codigoBarras = viewAdd.lerCodigoBarras();
                int quantidade = viewAdd.lerQuantidadeProtudo();
                itensController.adicionarProdutoCaixa(codigoBarras, quantidade);
                break;
            case 3:
                double totalCaixa = itensController.calcularTotalCaixa();
                viewCaixa.imprimirValorCaixa(totalCaixa);
                break;
            case 4:
                itensController.finalizarCompra();
                break;
            case 5:
                break;
        }
    }
}
