import java.util.Scanner;

public class listaOpcoes {
    
    private static class No {
        int dado;
        No proximo;
        No anterior;
    }

    No inicio;
    No fim;
    int tamanho;
    
    Scanner scan = new Scanner(System.in);
    
    public void inserir() {
        No novoNo = new No();
        System.out.println("Digite o valor a ser inserido:");
        novoNo.dado = scan.nextInt();
        novoNo.proximo = null;
        novoNo.anterior = fim;
        if (fim != null) {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        if (tamanho == 0) {
            inicio = fim;
        }
        tamanho++;
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        listaOpcoes lista = new listaOpcoes();
        for (int i = 0; i < 5; i++) {
            lista.inserir();
        }
        lista.exibir();
    }
    
}
