package controller;

import java.util.*;
import view.*;
import model.*;
import observer.Observable;
import observer.Observer;


public class EstoqueController implements Observable{
    private ArrayList<Produto> estoque;
    private List<Observer> observers = new ArrayList<>();
    private ExibirRelatorioVendasView viewRelatorio;
    private ArrayList<Venda> vendasRealizadas;
    private CarregarProdutosView viewCarregarProdutos;
    private String produto;

    public EstoqueController() {
        this.estoque = new ArrayList<>();
        this.vendasRealizadas = new ArrayList<>();
        this.viewRelatorio = new ExibirRelatorioVendasView();
        this.viewCarregarProdutos = new CarregarProdutosView();
    }

    // Adiciona o produto no estoque
    public void adicionarProdutoEstoque(Produto produto) {
        estoque.add(produto);
    }

    // Pega o estoque
    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    // Remove o produto
    public boolean removerProdutoEstoque(int codigoBarras, int quantidadeRemover) {
        for (Produto produto : estoque){
            if (produto.getCodigoBarras() == codigoBarras && produto.getQuantidadeProduto() >= quantidadeRemover) {
                int novaQuantidade = produto.getQuantidadeProduto() - quantidadeRemover;
                produto.setQuantidadeProduto(novaQuantidade);//Removido
                if(novaQuantidade <= 5){
                    this.produto = produto.getNome();
                    notifyObservers(this.produto);
                }
                return true;
            }

        }
        return false;
    }

    // Exibe o relatório
    public void exibirRelatorioVendas() {
        viewRelatorio.titulo();
        if (vendasRealizadas.isEmpty()) {
            viewRelatorio.vazio();
        } else {
            for (Venda venda : vendasRealizadas) {
                List<Produto> produtos = venda.getProdutos();
                double total = venda.getTotal();
                viewRelatorio.titulo2();
                for (Produto produto : produtos) {
                    Produto produtoVendido = new Produto(produto.getNome(), produto.getCodigoBarras(), produto.getValor(),
                            produto.getQuantidadeProduto());
                    viewRelatorio.itens(produtoVendido);
                }
                viewRelatorio.venda(total);
            }
        }
    }

    // Registra a venda
    public void registrarVenda(Venda venda) {
        vendasRealizadas.add(venda);
    }

    // Cria os produtos
    public void criarProdutos(List<Produto> produtos) {
        for (Produto produto : produtos) {
            adicionarProdutoEstoque(produto);
        }
    }

    // Carrega os produtos
    public void carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();

        Produto arroz = new Produto("Arroz", 1001, 10, 10);
        Produto feijao = new Produto("Feijão", 1002, 15, 10);
        Produto macarrao = new Produto("Macarrão", 1003, 20, 10);
        Produto farinha = new Produto("Farinha", 1004, 10, 10);
        Produto nutella = new Produto("Nutella", 1005, 30, 10);

        produtos.add(arroz);
        produtos.add(feijao);
        produtos.add(macarrao);
        produtos.add(farinha);
        produtos.add(nutella);

        criarProdutos(produtos);
        viewCarregarProdutos.carregarProdutos();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(String produto) {
        for (Observer observer : observers) {
            observer.update(produto);
        }
    }

}
