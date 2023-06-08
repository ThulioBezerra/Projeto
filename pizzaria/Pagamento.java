import java.util.Scanner;
public class Pagamento {

    public static String[] formasPagamento = {"PIX","Dinheiro","Cartão de Débito","Cartão de Crédito"}; 
    static Scanner scan = new Scanner(System.in);
    static int forma;
    static int parc;
    static String parcelas;
    

    public static void gerarNotaFiscal(double total,String formaPagamento,String pizza,String bebida,String sobremesa){
        if(formaPagamento=="Cartão de Crédito"){
            parcelas = "\nTotal de Parcelas: "+parc+"\nValor de cada parcela: "+total/parc+"\n";
        }
        else{
            parcelas="";
        }
        
        System.out.printf("""
            \n\n==========--NOTA FISCAL--==========\n\n
                Pizzaria: nome a definir\n
                Pedido \n
                %s\n
                %s\n
                %s\n
                Total: %.2f\n
                %s
                Forma de pagamento: %s\n
                Obrigado pela preferência!!!
            \n\n=========--VOLTE SEMPRE--==========\n\n
                """,pizza,bebida,sobremesa,total,parcelas,formaPagamento);
    }

    public static void pagPix(double total){
        System.out.printf("\n\nTotal: %.2f\n\nPagamento pelo pix\n\nPIX da pizzaria: 109-109\n",total);
        System.out.print("Enviou Comprovante?[1]SIM\t[2]NÃO\nSelecione: ");
        int comp =scan.nextInt();
        if(comp==1){
            System.out.println("\nObrigado pela preferência!!!");
        }
        else if(comp==2){
            System.out.println("Desculpe não recebemos o comprovante\n\n");
            pagPix(total);
        }
        else{
            pagPix(total);
        }
        forma=0;
    }

    public static void pagDin(){
        System.out.println("Se dirija ao caixa!");
        forma=1;
    }

    public static void pagCarDeb() {

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
        forma=2;
    }

    public static void pagCarCred(){
        System.out.print("Insira seu cpf: ");
        scan.nextLine();
        String cpf = scan.nextLine();
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
        forma=3;
    }
    public static int recursivaCarCred(){
        System.out.print("Selecione em quantas vezes vai parcelar de 1 a 6 vezes: ");
        parc = scan.nextInt();
        if(parc<1||parc>6){
            return recursivaCarCred();
        }
        return parc;
    }

    public static int formaPagamento(double total){

        System.out.print("Escolha a maneira ade pagamento:"
        +"\n1- PIX\n2- Dinheiro\n3- Cartão de Débito\n4- Cartão de Crédito\nSelecione: ");
        int op = scan.nextInt();
        switch(op){
            case 1:
                pagPix(total);
              //  gerarNotaFiscal("Julio", total, formasPagamento[forma]);
                break;
            case 2:
                pagDin();
              //  gerarNotaFiscal("Julio", total, formasPagamento[forma]);
                break;
            case 3:
                pagCarDeb();
               // gerarNotaFiscal("Julio", total, formasPagamento[forma]);
                break;
            case 4:
                pagCarCred();
               // gerarNotaFiscal("Julio", total, formasPagamento[forma]);
                break;
            default:
                System.out.println("Houve um erro no seu pagamento, por favor volte ao inicio.\n\n");
                formaPagamento(total);
        }
        return op-1;
    }

   
    

}