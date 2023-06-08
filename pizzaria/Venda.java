import java.util.Scanner;

public class Venda {
    static Scanner scan = new Scanner(System.in);
    static final String pix = "4002-8922"; // Bom dia e CIA - número :)
    static double x=0;
    static Pagamento pagamento;

    public static String selecionarPizza() {
        Pizza.mostrarCardapio(); 
        System.out.print("\nInforme o número da pizza que deseja selecionar: ");
        int numPizza = scan.nextInt();
       
        System.out.printf("\nA pizza selecionada foi: %d - %s  Preço: %.2f R$",
        numPizza, Pizza.cardapio[numPizza - 1].nome,Pizza.cardapio[numPizza-1].preco);
       
        System.out.printf("\nAguarde um momento até a pizza ficar pronta, enquanto isso fique a vontade :)\n\n");
        x+=Pizza.cardapio[numPizza-1].preco;
        return "Pizza: "+Pizza.cardapio[numPizza-1].nome+".........."
        +Pizza.cardapio[numPizza-1].preco+" R$";
    }

    public static String selecionarBebida() {
        Bebida.mostrarCardapio(); 
        System.out.print("\nInforme o número da bebida que deseja selecionar: ");
        int numBebida = scan.nextInt();
      
        System.out.printf("\nA bebida selecionada foi: %d - %s  Preço: %.2f R$",
        numBebida, Bebida.cardapio[numBebida - 1].nome,Bebida.cardapio[numBebida-1].preco);      
      
        System.out.printf("\nPedido concluído. Seu refrigerante foi selecionado. :)\n\n");
        x+=Bebida.cardapio[numBebida-1].preco;
        return "Bebida: "+Bebida.cardapio[numBebida-1].nome+".........."
        +Bebida.cardapio[numBebida-1].preco+" R$";
    }

    public static String selecionarSobremesa() {
        Sobremesa.mostrarCardapio();
        System.out.print("\nInforme o número da sobremesa que deseja selecionar: ");
        int numSobremesa = scan.nextInt();
       
        System.out.printf("A sobremesa selecionada foi: %d - %s  Preço: %.2f R$",
        numSobremesa, Sobremesa.cardapio[numSobremesa - 1].nome,Sobremesa.cardapio[numSobremesa - 1].preco);
       
        System.out.printf("\nPedido concluído. Sua sobremesa foi adicionada. :)\n\n");
        x+=Sobremesa.cardapio[numSobremesa-1].preco;
        return "Sobremesa: "+Sobremesa.cardapio[numSobremesa-1].nome+".........."
        +Sobremesa.cardapio[numSobremesa-1].preco+" R$";
    }

    public static void resumoPedido(String pizzas, String bebidas, String sobremesas) {
        System.out.printf("""
                Resumo do pedido:\n
                %s
                %s
                %s\n
                Total: %.2f\n
                """, pizzas != null ?  pizzas  : "", bebidas != null ? bebidas : "",
                 sobremesas != null ? sobremesas : "",x);

    }

    

    public static void nota_pagamento(String pizza,String bebida,String sobremesa) {
       int y = pagamento.formaPagamento(x);
       pagamento.gerarNotaFiscal( x, pagamento.formasPagamento[y],pizza,bebida,sobremesa);
    }

    
}
