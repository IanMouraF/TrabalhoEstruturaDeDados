import java.util.Scanner;

public class listaOpcoes {
    
    Scanner scan = new Scanner(System.in);

    public void inserir(){
        System.out.println("Escolha um número inteiro para adicionar");
        int n = scan.nextInt();
        No lista = new No(n);
        System.out.println(lista);
    }

    public static void main(String[] args) {
        listaOpcoes l = new listaOpcoes();
        l.inserir();
    }

}
