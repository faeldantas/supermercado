package view;

import java.util.*;

import controller.*;

public class LoginView {
    private Scanner scanner;
    private MenuGerenteView viewGerente;
    private MenuFuncionarioView viewFuncionario;
    private String usuario;
    private String senha;
    private ItensDoPedidoController exibirPedido;
    private EstoqueController estoqueController;

    public LoginView(String usuario, String senha, EstoqueController controller) {
        this.estoqueController = controller;
        this.scanner = new Scanner(System.in);
        this.viewGerente = new MenuGerenteView(controller);
        this.viewFuncionario = new MenuFuncionarioView(controller);
        this.usuario = usuario;
        this.senha = senha;
        this.exibirPedido = new ItensDoPedidoController(controller);
        //Adicionando Observers
        estoqueController.registerObserver(viewFuncionario);
        estoqueController.registerObserver(viewGerente);
    }

    // Exibição dos logins pré-prontos
    public void exibirLogin() {
        System.out.println("----- Login -----");
        do{
            System.out.print("Digite o seu usuário (gerente/funcionario): ");
            this.usuario = scanner.nextLine();
            if (this.usuario.equalsIgnoreCase("gerente")) {
                System.out.print("Digite a senha do gerente: ");
                this.senha = scanner.nextLine();

                if (this.senha.equals("senha-gerente")) {
                    System.out.println("Login do gerente bem-sucedido!");
                    viewGerente.exibirMenuGerente();
                } else {
                    System.out.println("Senha incorreta. Acesso negado.");
                }
            } else if (this.usuario.equalsIgnoreCase("funcionario")) {
                System.out.print("Digite a senha do funcionário: ");
                this.senha = scanner.nextLine();

                if (this.senha.equals("senha-funcionario")) {
                    System.out.println("Login do funcionário bem-sucedido!");
                    System.out.println();
                    exibirPedido.exibirProdutos();
                    viewFuncionario.exibirMenuFuncionario();
                } else {
                    System.out.println("Senha incorreta. Acesso negado.");
                }
            } else {
                System.out.println("Usuário inválido.");
            }
            System.out.print("Deseja sair do sistema? (S/N): ");
            String deslogar = scanner.nextLine();

            if (deslogar.equalsIgnoreCase("s")) {
                break;
            }
        } while (true);

        System.out.println("Saindo...");
    }
}
