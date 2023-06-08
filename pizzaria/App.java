public class App {
    public static void main(String[] args) throws Exception {
        //Pizza.mostrarCardapio(); //roda ai tuio, p ver se ta funfando
        String pizza = Venda.selecionarPizza();
        String bebida = Venda.selecionarBebida();
        String sobremesa = Venda.selecionarSobremesa();
        Venda.resumoPedido(pizza, bebida, sobremesa);
        Venda.nota_pagamento(pizza,bebida,sobremesa);
    }
}
