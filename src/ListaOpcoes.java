import java.util.Scanner;

public class ListaOpcoes {

    private static class No {
        int dado;
        No proximo;
        No anterior;
    }

    No inicio;
    No fim;
    int tamanho;

    static int semLimite = 2147483647;

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
                        "------------------------------\n";

        System.out.println(listaPrintada);

        Scanner leitorOpcao = new Scanner(System.in);

        int opcaoSelecionada = 0;


        opcaoSelecionada = Main.numeroInteiro("Selecione a opcao desejada: ", 6);

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


    //1
    public void inserir() {
        No novoNo = new No();
        novoNo.dado = Main.numeroInteiro("Digite o valor a ser inserido:", semLimite);
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
        int posicao = Main.numeroInteiro("Qual posição deseja selecionar?", semLimite);
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida.");
        }
        int novoValor = Main.numeroInteiro("Qual o novo valor dessa posição?", semLimite);
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
    public void excluir() {
        System.out.println();
        int posicao = Main.numeroInteiro("Qual posição deseja selecionar para excluir o número?", semLimite);
        if (posicao < 1 || posicao > tamanho) {
            System.out.println("Posição inválida.");
        } else {
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
    }

    //4
    public void pesquisar() {
        int valor = Main.numeroInteiro("Qual valor deseja pesquisar?", semLimite);
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
        if (!presente) {
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
