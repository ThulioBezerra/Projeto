import java.util.Scanner;
import java.util.ArrayList;

public class App {
    static int opcao,produto;
    static Scanner leitor = new Scanner(System.in);
    static ArrayList<String> pizzas = new ArrayList<String>();
    static ArrayList<String> bebida = new ArrayList<String>();
    static ArrayList<String> sobremesa = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        do {
            menu();
        } while (opcao != 0 && opcao != 2);

        Venda.resumoPedido(pizzas, bebida, sobremesa);
        Pagamento.formaPagamento(Venda.x);
       
    }

    static void menu() {
        System.out.println("""
                Olá, o que deseja?

                [1] Realizar um pedido
                [2]Finalizar pedido
                [0] Sair
                """);
        opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {
            case 1:
                System.out.println("""
                        O que deseha pedir?

                        [1] Pizzas
                        [2] Bebidas
                        [3] Sobremesas
                        [0] Desistir
                        """);
                produto = Integer.parseInt(leitor.nextLine());
                switch (produto) {
                    case 1:
                        pizzas.add(Venda.selecionarPizza());
                        break;
                    case 2:
                        bebida.add(Venda.selecionarBebida());
                        break;
                    case 3:
                        sobremesa.add(Venda.selecionarSobremesa());
                        break;
                    default:
                        System.out.println("Certo. Irei cancelar esse pedido.");

                }
                break;
        }
    }
}
