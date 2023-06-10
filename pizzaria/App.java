import java.util.Scanner;
import java.util.ArrayList;

public class App {
    //cores:
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    static int opcao;
    static Scanner leitor = new Scanner(System.in);
    static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    static ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
    static ArrayList<Sobremesa> sobremesas = new ArrayList<Sobremesa>();
    static Venda venda = new Venda();

    public static void main(String[] args) throws Exception {
        do {
            menu();
        } while (opcao != 0 && opcao != 2);
       
    }

   public static void menu() {
        int produto;
        System.out.println("""
                Olá, o que deseja?

                [1] Realizar um pedido
                [2]Finalizar pedido
                [0] Sair
                """);
        opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {
            case 1:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("""
                        O que deseja pedir?

                        [1] Pizzas
                        [2] Bebidas
                        [3] Sobremesas
                        [0] Desistir
                        """);
                produto = Integer.parseInt(leitor.nextLine());
                switch (produto) {
                    case 1:
                        pizzas.add(venda.selecionarPizza());
                        break;
                    case 2:
                        bebidas.add(venda.selecionarBebida());
                        break;
                    case 3:
                        sobremesas.add(venda.selecionarSobremesa());
                        break;
                    default:
                        System.out.println(RED + "Certo. Irei cancelar esse pedido." + RESET);

                }
                break;
            case 2:
                if(pizzas.size() == 0 && bebidas.size() == 0 && sobremesas.size() == 0) {
                    System.out.println(RED + "Você não pediu nada, saindo do sistema...");
                }else {
                    venda.nota_pagamento(pizzas,bebidas,sobremesas);
                }
        }
    }
}
