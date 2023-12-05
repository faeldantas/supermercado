package view;

import java.util.Scanner;

public class FinalizarCompraView {
    private Scanner scanner;
    
    public FinalizarCompraView() {
        this.scanner = new Scanner(System.in);
    }

    // Mensagem total venda
    public void finalizarCompra(double totalVenda) {
        System.out.println("Total da compra: R$" + totalVenda);
    }

    // Mensagem escolha pagamento
    public int escolhaPagamento() {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Dinheiro");

        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    // Mensagem realizar pagamento pix
    public void realizarPagamentoPix() {
        System.out.println("Pagamento via Pix realizado com sucesso!");
    }

    // Mensagem realizar pagamento cartao de crédito
    public void realizarPagamentoCartaoCredito() {
        System.out.println("Pagamento via Cartão de Crédito realizado com sucesso!");
    }

    // Mensagem realizar pagamento dinheiro e lógica de troco
    public void realizarPagamentoDinheiro(double totalVenda) {
        double valorPago;
        do {
            System.out.print("Digite o valor em dinheiro: R$");
            valorPago = scanner.nextDouble();

            if (valorPago < totalVenda) {
                System.out.println("Valor insuficiente. Digite um valor igual ou maior que o total da compra.");
            }
        } while (valorPago < totalVenda);

        double troco = valorPago - totalVenda;
        System.out.println("Pagamento em dinheiro realizado. Troco: R$" + troco);
    }

    // Mensagem de opção inválida
    public void opcaoInvalida() {
        System.out.println("Opção inválida. Escolha uma opção válida.");
    }

    // Mensagem de compra finalizada
    public void compraFinalizada() {
        System.out.println("Compra finalizada. Obrigado!");
    }
}
