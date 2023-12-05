package model;

import java.util.List;

public class Venda {
    private List<Produto> itensVendidos;
    private double total;

    public Venda(List<Produto> itensVendidos, double total) {
        this.itensVendidos = itensVendidos;
        this.total = total;
    }

    // Getters and Setters

    public List<Produto> getProdutos() {
        return itensVendidos;
    }

    public double getTotal() {
        return total;
    }
}
