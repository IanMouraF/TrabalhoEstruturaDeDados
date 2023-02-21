import java.util.Scanner;

public class Main {

    public static void Menu() {

        System.out.println(
                "------------------------------\n" +
                "|   1 -  Vetor               |\n" +
                "|   2 -  Lista               |\n" +
                "------------------------------\n" +
                "Selecione a opcao desejada: ");

    }

    public static void VerificarNumero(x){
        if (x == 1){
            vo.vetorOpcoes();
        }if (x == 2){
            
        }else{
            
        }
        return x;
    }

    public static void main(String[] args) {
        
        vetorOpcoes vo = new vetorOpcoes();
        
        Menu();
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        
        while (x != 1 | x != 2){
        VerificarNumero(x);
        }
    }
}