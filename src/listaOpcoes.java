import java.util.Scanner;

public class listaOpcoes {
    
    No inicio, fim;
    int tamanho;

    Scanner scan = new Scanner(System.in);

    public void inserir(){
        No lista = new No();
        System.out.println("Número:");
        int n = scan.nextInt();
        lista.dado = n;
        lista.proximo = null;
        lista.anterior = fim;
        if(fim != null){
            fim.proximo = lista;
        }
        fim = lista;
        if(tamanho == 0){
            inicio = fim;
        }
        tamanho++;
        System.out.println(tamanho);
    }


    public static void main(String[] args) {
        
        listaOpcoes l = new listaOpcoes();
        for(int i=0; i<5; i++){
            l.inserir();
        }
           
    }


}
