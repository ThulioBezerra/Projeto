public class Produto {
    protected int id;
    protected double preco;
    protected String nome;

    public Produto() {

    }

    public Produto(int id_p, double preco_p, String nome_p) {
        this.id = id_p;
        this.preco = preco_p;
        this.nome = nome_p;
    }

    public static void mostrarCardapio(Produto[] cardapio) {
        int count = 1;
        System.out.println("----- CARDAPIO -----");
        for (Produto produto : cardapio) {
            System.out.printf("%d - %s  |", count, produto.nome);
            count++;
        }
    }
}
