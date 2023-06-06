public class Bebida extends Produto {
    private int ml;

    public Bebida(int id_p, double preco_p, String nome_p, int ml) {
        super(id_p, preco_p, nome_p);
        this.ml = ml;
    }

    static Bebida[] cardapio = {
            new Bebida(200, 4, "Guaraná Antártica", 400),
            new Bebida(201, 3.50, "Chá de hortelã", 250),
            new Bebida(202, 4, "Guaraná Dyeight", 500),
            new Bebida(203, 5, "Suco de Maracujá", 400),
            new Bebida(204, 12, "Monster", 450),
    };

    public static void mostrarCardapio() {

        int count = 1;
        System.out.println("----- CARDAPIO -----");
        for (Bebida bebida : cardapio) {
            if (count % 2 == 0) {
                System.out.printf("%d - %s  - %.2f \n", count, bebida.nome, bebida.preco);
                count++;
            } else {
                System.out.printf("%d - %s  - %.2f  | ", count, bebida.nome, bebida.preco);
                count++;
            }
        }
    }
}
