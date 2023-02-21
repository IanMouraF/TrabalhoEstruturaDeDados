import java.util.Scanner;

public class Main {
    static int x = 0;
    static Scanner scan = new Scanner(System.in);
    static boolean y = true;
    public static int Menu() {
        System.out.println(
                "-------------------\n" +
                "|   1 -  Vetor    |\n" +
                "|   2 -  Lista    |\n" +
                "-------------------\n" +
                "Selecione a opcao desejada: ");

                x = scan.nextInt();
                return x;
    }


    public static void loop(){
        vetorOpcoes vo = new vetorOpcoes();
        listaOpcoes lo = new listaOpcoes();

        while (y){
            Menu();
    
            if (x == 1 || x == 2){
                if (x == 1) {
                    vetorOpcoes.criarVetor();
                    vo.vetorOpcoes();
                }if (x == 2) {
                    lo.listaOpcoes();
                }
            y = false;
            }else{
                System.out.println("Escolha uma opção válida");
            }
        }
    }

    public static void main(String[] args) {

    loop();    
       
    }
}