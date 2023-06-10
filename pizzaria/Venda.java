import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Venda {
    static Scanner scan = new Scanner(System.in);
    static double preco_total = 0;
    static Pagamento pagamento;

    public Venda() {
        pagamento = new Pagamento();
    }

    public Pizza selecionarPizza() {
        Pizza pizza = new Pizza();
        Pizza.mostrarCardapio();

        System.out.print("\nInforme o número da pizza que deseja selecionar: ");
        int numPizza = scan.nextInt();
        pizza = Pizza.cardapio.get(numPizza-1);
        System.out.printf("\nA pizza selecionada foi: %d - %s  Preço: %.2f R$",
                numPizza, Pizza.cardapio.get(numPizza - 1).nome, Pizza.cardapio.get(numPizza - 1).preco);

        System.out.printf("\nAguarde um momento até a pizza ficar pronta, enquanto isso fique a vontade :)\n\n");
        preco_total += Pizza.cardapio.get(numPizza - 1).preco;
        return pizza;
    }

    public Bebida selecionarBebida() {
        Bebida bebida = new Bebida();
        Bebida.mostrarCardapio();

        System.out.print("\nInforme o número da bebida que deseja selecionar: ");
        int numBebida = scan.nextInt();
        bebida= Bebida.cardapio.get(numBebida-1);

        System.out.printf("\nA bebida selecionada foi: %d - %s  Preço: %.2f R$",
                numBebida, Bebida.cardapio.get(numBebida - 1).nome, Bebida.cardapio.get(numBebida - 1).preco);

        System.out.printf("\nPedido concluído. Seu refrigerante foi selecionado. :)\n\n");

        preco_total += Bebida.cardapio.get(numBebida - 1).preco;
        return bebida;
    }

    public Sobremesa selecionarSobremesa() {
        Sobremesa sobremesa = new Sobremesa();
        Sobremesa.mostrarCardapio();
        System.out.print("\nInforme o número da sobremesa que deseja selecionar: ");
        int numSobremesa = scan.nextInt();
        sobremesa = Sobremesa.cardapio.get(numSobremesa-1);
        System.out.printf("A sobremesa selecionada foi: %d - %s  Preço: %.2f R$",
                numSobremesa, Sobremesa.cardapio.get(numSobremesa - 1).nome, Sobremesa.cardapio.get(numSobremesa - 1).preco);

        System.out.printf("\nPedido concluído. Sua sobremesa foi adicionada. :)\n\n");

        return sobremesa;

    }

    public void resumoPedido(ArrayList<String> pizzas, ArrayList<String> bebidas, ArrayList<String> sobremesas) {
        System.out.printf("""
                Resumo do pedido:\n
                %s
                %s
                %s\n
                Total: %.2f\n
                """, !pizzas.isEmpty() ? Arrays.asList(pizzas) : "", !bebidas.isEmpty() ? Arrays.asList(bebidas) : "",
                !sobremesas.isEmpty() ? Arrays.asList(sobremesas) : "", preco_total);

    }

    public void nota_pagamento(ArrayList<Pizza> pizza, ArrayList<Bebida> bebida,
            ArrayList<Sobremesa> sobremesa) {
        int index = pagamento.formaPagamento(preco_total);
        pagamento.gerarNotaFiscal(preco_total, pagamento.formasPagamento[index], pizza, bebida, sobremesa);
    }

}
