public class Sobremesa extends Produto {
    public Sobremesa() {
    }

    public Sobremesa(int id_p, double preco_p, String nome_p) {
        super(id_p, preco_p, nome_p);
    }

    static Sobremesa[] cardapio = {
            new Sobremesa(300, 20, "Bolo Chocolate"),

            new Sobremesa(301, 2.50, "Sorvete"),

            new Sobremesa(302, 25, "Pettieu Gattou"),

            new Sobremesa(303, 7, "Chocolate Branco"),

            new Sobremesa(304, 7, "Chocolate"),
    };

    public static void mostrarCardapio() {
        int count = 1;
        System.out.println("----- CARDAPIO -----");
        for (Sobremesa sobremesa : cardapio) {
            if (count % 2 == 0) {
                System.out.printf("%d - %s  - %.2f \n", count, sobremesa.nome, sobremesa.preco);
                count++;
            } else {
                System.out.printf("%d - %s  - %.2f  | ", count, sobremesa.nome, sobremesa.preco);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
