package model;

public class Produto {
    private String nome;
    private int codigoBarras;
    private double valor;
    private int quantidadeProduto;

    public Produto(String nome, int codigoBarras, double valor, int quantidadeProduto) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.valor = valor;
        this.quantidadeProduto = quantidadeProduto;
    }

    // Getters and Setters

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoBarras() {
        return this.codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeProduto() {
        return this.quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return "CodBarras: " + codigoBarras + " - Nome: " + nome + " - Valor: R$" + valor + " - Quantidade: " + quantidadeProduto;
    }
}
