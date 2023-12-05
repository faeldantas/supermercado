import view.*;

import controller.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Chamei o estoque controller que possui a lista principal, os produtos pré-prontos e a tela inicial
        EstoqueController controller = new EstoqueController();
        controller.carregarProdutos();
        LoginView view = new LoginView("", "", controller);
        view.exibirLogin();
    }
}