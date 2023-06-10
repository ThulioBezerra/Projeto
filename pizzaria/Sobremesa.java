import java.util.ArrayList;
import java.io.IOException;

public class Sobremesa extends Produto {
    public static ArrayList<Sobremesa> cardapio = lerCardapio();

    public Sobremesa() {
    }

    public Sobremesa(int id_p, double preco_p, String nome_p) {
        super(id_p, preco_p, nome_p);
    }

    private static ArrayList<Sobremesa> lerCardapio(){
        try{
            String[][] matrizDados = LeitorDeCSV.lerCSV("pizzaria/lib/cardapioSobremesa.csv", 3);
            ArrayList<Sobremesa> cardapio = new ArrayList<Sobremesa>();
    
            for(int i = 0; i<matrizDados.length; i++){
                cardapio.add(new Sobremesa(
                    Integer.parseInt(matrizDados[i][0]),
                    Double.parseDouble(matrizDados[i][1]),
                    matrizDados[i][2]
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
