import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LeitorDeCSV {
    public static int contarLinhas(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Long qntLinhasLong = reader.lines().count();
        int qntLinhas = qntLinhasLong.intValue();

        reader.close();
        return qntLinhas;
    }

    public static String[][] lerCSV(String path, int qntParametros) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String[][] matrizCardapio = new String[contarLinhas(path)][qntParametros];

        String line = reader.readLine();
        int i = 0;
        while(line != null) {
            matrizCardapio[i] = line.split(",");
            line = reader.readLine();
            i++;
        }

        reader.close();
        return matrizCardapio;
    }
}