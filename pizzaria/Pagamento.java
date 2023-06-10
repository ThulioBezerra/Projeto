import java.util.Scanner;
import java.util.ArrayList;
public class Pagamento {

    public String[] formasPagamento = {"PIX","Dinheiro","Cartão de Débito","Cartão de Crédito"}; 
    static Scanner scan = new Scanner(System.in);
    static int parc;
    
    public void gerarNotaFiscal(double total,String formaPagamento,ArrayList<Pizza> pizzas,ArrayList <Bebida> bebidas,ArrayList <Sobremesa> sobremesas){
        String parcelas="";
        if(formaPagamento=="Cartão de Crédito"){
            parcelas = "\nTotal de Parcelas: "+parc+"\nValor de cada parcela: "+total/parc+"\n";
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.printf(App.GREEN + """
            \n\n==========--NOTA FISCAL--==========\n\n
                Pizzaria: Pappa Pizza's\n
                Pedido \n
                %s
                %s
                %s
                Total: %.2f\n
                %s
                Forma de pagamento: %s\n
                Obrigado pela preferência!!!
            \n\n=========--VOLTE SEMPRE--==========\n\n
                """ + App.RESET,
                pizzas.toString().replaceAll("[\\[\\],]", ""),
                bebidas.toString().replaceAll("[\\[\\],]", ""),
                sobremesas.toString().replaceAll("[\\[\\],]", ""),
                total,parcelas,formaPagamento);
    }

    public void pagPix(){
        System.out.printf("\n\nPagamento pelo pix\n\nPIX da pizzaria: 4002-8922\n");
        System.out.print("Enviou Comprovante?[1]SIM\t[2]NÃO\nSelecione: ");
        
        int comprovante =scan.nextInt();
        if(comprovante==1){
            System.out.println(App.GREEN + "\nObrigado pela preferência!!!" + App.RESET);
        }
        else if(comprovante==2){
            System.out.println(App.RED + "Desculpe não recebemos o comprovante\n\n" + App.RESET);
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
            System.out.println(App.RED + "Algo errado com a senha.\nTente novamente." + App.RESET);
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
            System.out.println(App.RED + "\nAlgo errado com a senha.\nTente novamente.\n" + App.RESET);
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
                System.out.println(App.RED + "Houve um erro no seu pagamento, por favor volte ao inicio.\n\n" + App.RESET);
                formaPagamento(total);
        }
        return op-1;
    }

   
    

}