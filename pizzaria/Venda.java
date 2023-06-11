import java.util.ArrayList;
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

        System.out.print("\nInforme o número da pizza que deseja selecionar: "+App.RESET);
        int numPizza = scan.nextInt();

        if(numPizza==6){
            System.out.print("\nDiga qual pizza deseja ver os detalhes: ");
            int pizzaSelecionada = scan.nextInt();
            pizza.mostrarCardapio(pizzaSelecionada);
            return selecionarPizza();
        }

        else{
        pizza = Pizza.cardapio.get(numPizza-1);
        System.out.printf("\n%sA pizza selecionada foi: %d - %s  Preço: %.2f R$%s", App.GREEN,
            numPizza, Pizza.cardapio.get(numPizza - 1).nome, Pizza.cardapio.get(numPizza - 1).preco, App.RESET);

        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.printf("\n%sAguarde um momento até a pizza ficar pronta, enquanto isso fique a vontade :)\n\n%s", App.GREEN, App.RESET);
        preco_total += Pizza.cardapio.get(numPizza - 1).preco;
        return pizza;
    }
}

    public Bebida selecionarBebida() {
        Bebida bebida = new Bebida();
        Bebida.mostrarCardapio();

        System.out.print("\nInforme o número da bebida que deseja selecionar: "+App.RESET);
        int numBebida = scan.nextInt();
        bebida= Bebida.cardapio.get(numBebida-1);

        System.out.printf("\n%sA bebida selecionada foi: %d - %s  Preço: %.2f R$%s", App.GREEN,
            numBebida, Bebida.cardapio.get(numBebida - 1).nome, Bebida.cardapio.get(numBebida - 1).preco, App.RESET);
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.printf("\n%sPedido concluído. Seu refrigerante foi selecionado. :)\n\n%s", App.GREEN, App.RESET);

        preco_total += Bebida.cardapio.get(numBebida - 1).preco;
        return bebida;
    }

    public Sobremesa selecionarSobremesa() {
        Sobremesa sobremesa = new Sobremesa();
        Sobremesa.mostrarCardapio();
        System.out.print("\nInforme o número da sobremesa que deseja selecionar: "+App.RESET);
        int numSobremesa = scan.nextInt();
        sobremesa = Sobremesa.cardapio.get(numSobremesa-1);
        System.out.printf("%sA sobremesa selecionada foi: %d - %s  Preço: %.2f R$%s", App.GREEN,
            numSobremesa, Sobremesa.cardapio.get(numSobremesa - 1).nome, Sobremesa.cardapio.get(numSobremesa - 1).preco, App.RESET);

        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.printf("\n%sPedido concluído. Sua sobremesa foi adicionada. :)%s\n\n", App.GREEN, App.RESET);

        preco_total += Sobremesa.cardapio.get(numSobremesa - 1).preco;
        return sobremesa;

    }

    public void resumoPedido(ArrayList<String> pizzas, ArrayList<String> bebidas, ArrayList<String> sobremesas) {
        System.out.printf(App.BLUE + """
                Resumo do pedido:\n
                %s
                %s
                %s\n
                Total: %.2f\n
                """, 
                pizzas.isEmpty() ? "" : pizzas,
                bebidas.isEmpty() ? "" : bebidas,
                sobremesas.isEmpty() ? "" : sobremesas,
                preco_total);

    }

    public void nota_pagamento(ArrayList<Pizza> pizza, ArrayList<Bebida> bebida,
            ArrayList<Sobremesa> sobremesa) {
        int index = pagamento.formaPagamento(preco_total);
        pagamento.gerarNotaFiscal(preco_total, pagamento.formasPagamento[index], pizza, bebida, sobremesa);
    }

}
