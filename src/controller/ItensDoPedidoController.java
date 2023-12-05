package controller;

import model.*;
import view.*;

import java.util.*;

public class ItensDoPedidoController {
    private ArrayList<Produto> itensPedido;
    private EstoqueController controller;
    private AdicionarProdutoCaixaView viewAdd;
    private ExibirItensPedidoView viewExibir;
    private FinalizarCompraView viewFinalizar;
    private List<Venda> vendasRealizadas;

    public ItensDoPedidoController(EstoqueController controller) {
        this.itensPedido = new ArrayList<>();
        this.controller = controller;
        this.viewAdd = new AdicionarProdutoCaixaView();
        this.viewExibir = new ExibirItensPedidoView();
        this.viewFinalizar = new FinalizarCompraView();
        this.vendasRealizadas = new ArrayList<>();
    }

    // Adiciona os produtos
    public void adicionarProduto(Produto produto) {
        itensPedido.add(produto);
    }

    // Adiciona os produtos ao caixa
    public void adicionarProdutoCaixa(int codigoBarras, int quantidade) {
        ArrayList<Produto> estoque = controller.getEstoque();
        Produto produto = null;
        for (Produto p : estoque) {
            if (p.getCodigoBarras() == codigoBarras) {
                produto = p;
                break;
            }
        }
        if (produto != null) {
            if (quantidade <= produto.getQuantidadeProduto()) {
                produto.setQuantidadeProduto(produto.getQuantidadeProduto() - quantidade);
                Produto produtoCaixa = new Produto(produto.getNome(), produto.getCodigoBarras(), produto.getValor(), quantidade);
                adicionarProduto(produtoCaixa);
                exibirProdutos();
                viewAdd.exibirMensagemProdutoAdicionado();
                return;
            } else {
                viewAdd.exibirMensagemProdutoIndisponivel();

            }
        } else {
            viewAdd.exibirMensagemProdutoNaoEncontrado();
        }
        
    }

    // Pega os produtos
    public ArrayList<Produto> getItensPedido() {
        return itensPedido;
    }

    // Calcula o total do caixa
    public double calcularTotalCaixa() {
        double valorTotal = 0;

        for (Produto produto : itensPedido){
            valorTotal += produto.getValor() * produto.getQuantidadeProduto();
        }
        exibirProdutos();
        return valorTotal;
    }

    // Exibir produtos
    public void exibirProdutos() {
        if (itensPedido.isEmpty()) {
            viewExibir.caixaVazio();
        } else {
            viewExibir.inicioItens();
            for (Produto produto : itensPedido) {
                viewExibir.exibirProduto(produto);
            }
        }
    }

    // Finalizar a compra
    public void finalizarCompra() {
        double totalVenda = calcularTotalCaixa();
        viewFinalizar.finalizarCompra(totalVenda);
        int opcaoPagamento;
        do {
            opcaoPagamento = viewFinalizar.escolhaPagamento();
            switch (opcaoPagamento) {
                case 1:
                    viewFinalizar.realizarPagamentoPix();
                    break;
                case 2:
                    viewFinalizar.realizarPagamentoCartaoCredito();
                    break;
                case 3:
                    viewFinalizar.realizarPagamentoDinheiro(totalVenda);
                    break;
                default:
                    viewFinalizar.opcaoInvalida();
            }
        } while (opcaoPagamento != 1 && opcaoPagamento != 2 && opcaoPagamento != 3);
        registrarVenda(totalVenda);
        controller.registrarVenda(new Venda(new ArrayList<>(itensPedido), totalVenda));
        limparCaixa();
        viewFinalizar.compraFinalizada();
        exibirProdutos();
    }

    // Registrar a venda
    public void registrarVenda(double totalVenda) {
        Venda venda = new Venda(new ArrayList<>(itensPedido), totalVenda);
        vendasRealizadas.add(venda);
    }

    // Limpar caixa
    public void limparCaixa() {
        itensPedido.clear();
    }

    // Setter
    public void setEstoqueController(EstoqueController controller) {
        this.controller = controller;
    }
}