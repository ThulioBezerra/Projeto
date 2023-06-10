import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Pagamento {

    public String[] formasPagamento = {"PIX","Dinheiro","Cartão de Débito","Cartão de Crédito"}; 
    static Scanner scan = new Scanner(System.in);
    static int parc;
    
    public void gerarNotaFiscal(double total,String formaPagamento,ArrayList<Pizza> pizza,ArrayList <Bebida> bebida,ArrayList <Sobremesa> sobremesa){
        String parcelas="";
        if(formaPagamento=="Cartão de Crédito"){
            parcelas = "\nTotal de Parcelas: "+parc+"\nValor de cada parcela: "+total/parc+"\n";
        }
        System.out.printf("""
            \n\n==========--NOTA FISCAL--==========\n\n
                Pizzaria: Pappa Pizza's\n
                Pedido \n
                %s\n
                %s\n
                %s\n
                Total: %.2f\n
                %s
                Forma de pagamento: %s\n
                Obrigado pela preferência!!!
            \n\n=========--VOLTE SEMPRE--==========\n\n
                """,Arrays.asList(pizza),bebida,sobremesa,total,parcelas,formaPagamento);
    }

    public void pagPix(){
        System.out.printf("\n\nPagamento pelo pix\n\nPIX da pizzaria: 4002-8922\n");
        System.out.print("Enviou Comprovante?[1]SIM\t[2]NÃO\nSelecione: ");
        
        int comprovante =scan.nextInt();
        if(comprovante==1){
            System.out.println("\nObrigado pela preferência!!!");
        }
        else if(comprovante==2){
            System.out.println("Desculpe não recebemos o comprovante\n\n");
            pagPix();
        }
        else{
            pagPix();
        }
    }

    public void pagDin(){
        System.out.println("Se dirija ao caixa!");
    }

    public void pagCarDeb() {

        System.out.println("Insira ou aproxime o cartão da máquina.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Insira a senha(4 digitos): ");
        String senha = scan.next();
        if(senha.length()!=4){
            System.out.println("Algo errado com a senha.\nTente novamente.");
            pagCarDeb();
        }
    }

    public  void pagCarCred(){
        parc = recursivaCarCred();

        System.out.println("Insira ou aproxime o cartão da máquina.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("\nInsira a senha(4 digitos): ");
        String senha = scan.next();
        if(senha.length()!=4){
            System.out.println("\nAlgo errado com a senha.\nTente novamente.\n");
            pagCarDeb();
        }
    }
    public static int recursivaCarCred(){
        System.out.print("Selecione em quantas vezes vai parcelar de 1 a 6 vezes: ");
        parc = scan.nextInt();
        if(parc<1||parc>6){
            return recursivaCarCred();
        }
        return parc;
    }

    public int formaPagamento(double total){

        System.out.print("Escolha a maneira de pagamento:"
        +"\n1- PIX\n2- Dinheiro\n3- Cartão de Débito\n4- Cartão de Crédito\nSelecione: ");
        int op = scan.nextInt();
        switch(op){
            case 1:
                pagPix();
                break;
            case 2:
                pagDin();
                break;
            case 3:
                pagCarDeb();
                break;
            case 4:
                pagCarCred();
                break;
            default:
                System.out.println("Houve um erro no seu pagamento, por favor volte ao inicio.\n\n");
                formaPagamento(total);
        }
        return op-1;
    }

   
    

}