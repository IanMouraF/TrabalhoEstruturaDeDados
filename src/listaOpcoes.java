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

    public void listaOpcoes() {
        String listaPrintada =
                "------------------------------\n" +
                        "|           Lista            |\n" +
                        "------------------------------\n" +
                        "|   1 -  Inserir dado        |\n" +
                        "|   2 -  Alterar dado        |\n" +
                        "|   3 -  Excluir dado        |\n" +
                        "|   4 -  Pesquisar dados     |\n" +
                        "|   5 -  Mostrar dados       |\n" +
                        "|   6 -  Voltar              |\n" +
                        "------------------------------\n" +
                        "Selecione a opcao desejada: ";

        System.out.println(listaPrintada);

        Scanner leitorOpcao = new Scanner(System.in);

        int opcaoSelecionada = 0;

        while (opcaoSelecionada < 5) {
            opcaoSelecionada = leitorOpcao.nextInt();

            if (opcaoSelecionada == 0) {
                listaOpcoes();
            }
            if (opcaoSelecionada == 1) {
                inserir();
                listaOpcoes();
            }
            if (opcaoSelecionada == 2) {
                alterar();
                listaOpcoes();
            }
            if (opcaoSelecionada == 3) {
                excluir();
                listaOpcoes();
            }
            if (opcaoSelecionada == 4) {
                pesquisar();
                listaOpcoes();
            }
            if (opcaoSelecionada == 5) {
                mostrar();
                listaOpcoes();
            }
            if (opcaoSelecionada == 6) {
                Main.loop();
            }
        }
    }

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
    //3
    public void excluir(){
        System.out.println("Qual posição deseja selecionar para excluir o número?");
        int posicao = scan.nextInt();
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida.");
        }
        if (posicao == 1) {
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
        } else if (posicao == tamanho) {
            fim = fim.anterior;
            fim.proximo = null;
        } else {
            int contador = 1;
            No atual = inicio;
            while (atual != null && contador < posicao) {
                atual = atual.proximo;
                contador++;
            }
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        }
        tamanho--;
    }
    //4
    public void pesquisar(){
        System.out.println("Qual valor deseja pesquisar?");
        int valor = scan.nextInt();
        int posicao = 1;
        boolean presente = false;
        No atual = inicio;
        while (atual != null) {
            if (atual.dado == valor) {
                System.out.println("Valor encontrado na posição " + posicao + " da lista.");
                presente = true;
            }
            atual = atual.proximo;
            posicao++;
        }
        if (presente == false){
            System.out.println("Valor não encontrado na lista.");
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
    
}
