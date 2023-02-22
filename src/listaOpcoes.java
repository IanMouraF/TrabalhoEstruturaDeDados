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

    //1
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
    //2
    public void alterar() {
        System.out.println("Qual posição deseja selecionar?");
        int posicao = scan.nextInt();
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        System.out.println("Qual o novo valor dessa posição?");
        int novoValor = scan.nextInt();
        int contador = 1;
        No atual = inicio;
        while (atual != null && contador < posicao) {
            atual = atual.proximo;
            contador++;
        }
        if (atual != null) {
            atual.dado = novoValor;
        } else {
            System.out.println("Posição não encontrada na lista.");
        }
    }
    //5
    public void mostrar() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        listaOpcoes lista = new listaOpcoes();
        for (int i = 0; i < 3; i++) {
            lista.inserir();
        }
        lista.mostrar();
        lista.alterar();
        lista.mostrar();
    }
    
}
