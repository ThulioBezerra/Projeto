import java.util.Scanner;

public class Venda {
    static Scanner scan = new Scanner(System.in);
    static final String pix = "4002-8922"; // Bom dia e CIA - número :)
    static String[] formas_pagamento = { "PIX", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" };

    public static Pizza selecionarPizza() {
        System.out.println("Informe o número da pizza que deseja selecionar: ");
        Pizza.mostrarCardapio();
        int numPizza = scan.nextInt();
        System.out.printf("A pizza selecionada foi: %d - %s", numPizza, Pizza.cardapio[numPizza - 1].nome);
        System.out.printf("Aguarde um momento até a pizza ficar pronta, enquanto isso fique a vontade :)");
        return Pizza.cardapio[numPizza - 1];
    }

    public static Bebida selecionarBebida() {
        System.out.println("Informe o número da bebida que deseja selecionar: ");
        Bebida.mostrarCardapio();
        int numBebida = scan.nextInt();
        System.out.printf("A pizza selecionada foi: %d - %s", numBebida, Pizza.cardapio[numBebida - 1].nome);
        System.out.printf("Pedido concluído. Seu refrigerante foi selecionado. :)");
        return Bebida.cardapio[numBebida - 1];
    }

    public static Sobremesa selecionarSobremesa() {
        System.out.println("Informe o número da sobremesa que deseja selecionar: ");
        Sobremesa.mostrarCardapio();
        int numSobremesa = scan.nextInt();
        System.out.printf("A pizza selecionada foi: %d - %s", numSobremesa, Pizza.cardapio[numSobremesa - 1].nome);
        System.out.printf("Pedido concluído. Sua sobremesa foi adicionada. :)");
        return Sobremesa.cardapio[numSobremesa - 1];
    }

    public static void resumoPedido(Pizza[] pizzas, Bebida[] bebidas, Sobremesa[] sobremesas) {
        System.out.printf("""
                Resumo do pedido:
                %s
                %s
                %s
                """, pizzas != null ? "" : "", bebidas != null ? "" : "", sobremesas != null ? "" : "");

    }

    public static void notaFiscal(int pagamento, Pizza pizzaSelecionada) {
        System.out.printf("Nota Fiscal!\nPizzaria: "
                + "\n\nCliente: implementar\nCPF:\nForma de pagamento: %s\nPizza: %s",
                formas_pagamento[pagamento], pizzaSelecionada.preco);
    }

    public static void pagamentoPIX() {
        System.out.printf("PIX da pizzaria: %s", pix);
    }

    public static void pagamentodinheiro() {
        System.out.println("Informe seu cpf: ");
        String cpf = scan.next();
    }

    public static void pagamento() {// opções pix, dinheiro, cartão débito ou crédito
        System.out.printf("Informe a forma de pagamento:\n");
        System.out.println("1- PIX\t2- Dinheiro\nCartão no crédito\tCartão no Débito\nSelecione: ");
        int op = scan.nextInt();
        switch (op) {
            case 1:

        }

    }
}
