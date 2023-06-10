import java.util.ArrayList;
import java.io.IOException;

public class Bebida extends Produto {
    private int ml;
    public static ArrayList<Bebida> cardapio = lerCardapio();

    public Bebida(int id_p, double preco_p, String nome_p, int ml) {
        super(id_p, preco_p, nome_p);
        this.ml = ml;
    }

    public Bebida() {
    }

    private static ArrayList<Bebida> lerCardapio(){
        try{
            String[][] matrizDados = LeitorDeCSV.lerCSV("pizzaria/lib/cardapioBebida.csv", 4);
            ArrayList<Bebida> cardapio = new ArrayList<Bebida>();
    
            for(int i = 0; i<matrizDados.length; i++){
                cardapio.add(new Bebida(
                    Integer.parseInt(matrizDados[i][0]),
                    Double.parseDouble(matrizDados[i][1]),
                    matrizDados[i][2],
                    Integer.parseInt(matrizDados[i][3])
                ));
            }
    
            return cardapio;
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static void mostrarCardapio() {

        int count = 1;
        System.out.println("----- CARDAPIO -----");
        for (Bebida bebida : cardapio) {
            if (count % 2 == 0) {
                System.out.printf("%d - %s %dml - %.2f \n", count, bebida.nome, bebida.ml, bebida.preco);
                count++;
            } else {
                System.out.printf("%d - %s %dml - %.2f  | ", count, bebida.nome, bebida.ml, bebida.preco);
                count++;
            }
        }
    }

    @Override
    public String toString() {
        return this.id + "  " + this.nome + "  " + this.ml + "ML ......................." + this.preco + "\n   ";
    }
}
