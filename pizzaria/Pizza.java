
public class Pizza extends Produto {
    protected String borda = "borda comum";
    protected String queijo = "sem queijo";
    protected String carne = "sem carne";
    protected String molho = "sem molho";
    protected String[] extras = {}; // extras da pizza: calabresa, tempero e etc.
    static Pizza[] cardapio = {
            new Pizza(100, 24.50, "Mussarela", "catupiry", "mussarela", "sem carne", "sem molho",
                    new String[] { "oregano", "azeitona" }),
            new Pizza(101, 27, "Calabresa", "catupiry", "mussarela", "calabresa", "sem molho",
                    new String[] { "cebola", "tomate" }),
            new Pizza(102, 30, "Marguerita", "catupiry", "mussarela", "carne", "barbecue", new String[] { "cebola" }),
            new Pizza(103, 27, "Frango e catupiry", "catupiry", "catupiry", "frango", "", new String[] { "cebola" }),
            new Pizza(104, 27, "Presunto", "catupiry", "mussarela", "presunto", "", new String[] { }),
    };

    public Pizza() {
    }

    public Pizza(int id_p, double preco_p, String nome_p, String borda, String queijo, String carne, String molho,
            String[] extras) {
        super(id_p, preco_p, nome_p);
        this.borda = borda;
        this.queijo = queijo;
        this.carne = carne;
        this.molho = molho;
        this.extras = extras;
    }

    // ja formatei
    public static void mostrarCardapio() {
        int count = 1;
        System.out.println("\n----- CARDAPIO -----\n");
        for (Pizza pizza : cardapio) {
            if (count % 2 == 0) {
                System.out.printf("%d - %s  - %.2f \n", count, pizza.nome, pizza.preco);
                count++;
            } else {
                System.out.printf("%d - %s  - %.2f  | ", count, pizza.nome, pizza.preco);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
