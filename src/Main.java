import java.util.Scanner;

public class Main {

    static int semLimite = 2147483647;
    static int x = 0;
    static Scanner scan = new Scanner(System.in);
    static boolean y = true;
    public static int Menu() {
        System.out.println(
                "-------------------\n" +
                "|   1 -  Vetor    |\n" +
                "|   2 -  Lista    |\n" +
                "-------------------");

                x = numeroInteiro("Selecione a opcao desejada: ", semLimite);
                return x;
    }


    public static void loop(){
        VetorOpcoes vo = new VetorOpcoes();
        ListaOpcoes lo = new ListaOpcoes();

        while (y){
            Menu();
    
            if (x == 1 || x == 2){
                if (x == 1) {
                    VetorOpcoes.criarVetor();
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

    public static int numeroInteiro(String textoNumero, int limite) {
        int i = -1;
        while (i < 0) {
            System.out.println(textoNumero);

            String input = scan.nextLine();

            try {
                i = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro.");
                i = -1;
            }
            if(i > limite){
                i = -1;
            }
        }

        return i;
    }

}