import java.util.ArrayList;
import java.io.IOException;

public class Pizza extends Produto {
    protected String borda = "borda comum";
    protected String queijo = "sem queijo";
    protected String carne = "sem carne";
    protected String molho = "sem molho";
    protected String[] extras = {}; // extras da pizza: calabresa, tempero e etc.
    static ArrayList<Pizza> cardapio = lerCardapio();

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

    private static ArrayList<Pizza> lerCardapio(){
        try{
            String[][] matrizDados = LeitorDeCSV.lerCSV("pizzaria/lib/cardapioPizza.csv", 7);
            ArrayList<Pizza> cardapio = new ArrayList<Pizza>();
    
            for(int i = 0; i<matrizDados.length; i++){
                cardapio.add(new Pizza(Integer.parseInt(matrizDados[i][0]),
                Double.parseDouble(matrizDados[i][1]), 
                matrizDados[i][2], matrizDados[i][3], matrizDados[i][4], matrizDados[i][5], matrizDados[i][6],
                matrizDados[i][7].split("/")));
            }
    
            return cardapio;
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static void mostrarCardapio() {
        int count = 1;
        System.out.println(App.RED+"\n----- CARDAPIO -----\n");
        for (Pizza pizza : cardapio) {
            if (count % 2 == 0) {
                System.out.printf("%d - %s  - %.2f \n", count, pizza.nome, pizza.preco);
                count++;
            } else {
                System.out.printf("%d - %s  - %.2f  | ", count, pizza.nome, pizza.preco);
                count++;
            }
        }
      System.out.println("6 - Ver Detalhes de uma Pizza");
    }

    public void mostrarCardapio(int pizzaSelecionada){
        System.out.printf(App.CIANO+"""
                \nPizza %s -----------------\n
                Borda: %s
                Queijo: %s
                Molho: %s
                Carne: %s
                Extras:
                """,Pizza.lerCardapio().get(pizzaSelecionada-1).nome,Pizza.lerCardapio().get(pizzaSelecionada-1).borda,
                Pizza.lerCardapio().get(pizzaSelecionada-1).queijo,Pizza.lerCardapio().get(pizzaSelecionada-1).molho,
                Pizza.lerCardapio().get(pizzaSelecionada-1).carne);    
            
                for (String extra : Pizza.lerCardapio().get(pizzaSelecionada-1).extras) {
        System.out.print(extra + " | ");
    }
    System.out.println();
            }
            

    @Override
    public String toString() {
        return super.toString();
    }


}
