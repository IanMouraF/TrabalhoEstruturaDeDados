import java.util.Scanner;


public class VetorOpcoes {

    static int semLimite = 2147483647;

    static Scanner scan = new Scanner(System.in);

    static int[] vetorInteiro;

    public static int[] criarVetor() {
        int indiceScan = Main.numeroInteiro("Quantos espaços (índices) você deseja para o vetor? (contando com 0)", semLimite);
        int[] novoVetor = new int[indiceScan];
        vetorInteiro = novoVetor;
        return novoVetor;
    }


    public void vetorOpcoes() {

        String listaPrintada =
                "------------------------------\n" +
                        "|           Vetor            |\n" +
                        "------------------------------\n" +
                        "|   1 -  Inserir dado        |\n" +
                        "|   2 -  Alterar dado        |\n" +
                        "|   3 -  Pesquisar dado      |\n" +
                        "|   4 -  Mostrar dados       |\n" +
                        "|   5 -  Voltar              |\n" +
                        "------------------------------";


        System.out.println(listaPrintada);

        Scanner leitorOpcao = new Scanner(System.in);

        int opcaoSelecionada = 0;


        opcaoSelecionada = Main.numeroInteiro("Selecione a opcao desejada: ", 5);

        if (opcaoSelecionada == 0) {
            vetorOpcoes();
        }
        if (opcaoSelecionada == 1) {
            inserirDado();
            vetorOpcoes();
        }
        if (opcaoSelecionada == 2) {
            alterarDado();
            vetorOpcoes();
        }
        if (opcaoSelecionada == 3) {
            pesquisarDado();
            vetorOpcoes();
        }
        if (opcaoSelecionada == 4) {
            mostrarDados();
            vetorOpcoes();
        }
        if (opcaoSelecionada == 5) {
            Main.loop();
        }
    }


    public void inserirDado() {

        int tamanhoVetor = vetorInteiro.length - 1;

        int inteiroVetor = Main.numeroInteiro("Escolha um número inteiro para adicionar", semLimite); // o inteiro que vai ser adicionado

        int indiceVetor = Main.numeroInteiro("Escolha um índice de 0 a " + tamanhoVetor + " para inserir seu inteiro", semLimite); // o índice do vetor ao qual o inteiro vai ser adicionado

        try {
            if (vetorInteiro[indiceVetor] != 0) {
                System.out.println("Esse índice já tem um valor, use o alterar dado se quiser mudá-lo");
                vetorOpcoes();
            } else {
                vetorInteiro[indiceVetor] = inteiroVetor;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Escolha um índice de 0 a " + tamanhoVetor + "!");
            inserirDado();
        }


    }

    public void mostrarDados() {
        System.out.printf("%s %10s \n", "Índice", "Valores");
        for (int i = 0; i < vetorInteiro.length; i++) {
            System.out.printf(" %3d %10d \n", i, vetorInteiro[i]);
        }
    }

    public void pesquisarDado() {

        int tamanhoVetor = vetorInteiro.length - 1;

        int vetorPesquisado = Main.numeroInteiro("Qual valor você deseja verificar se está presente no vetor?:", semLimite);

        int indiceTeste = 0;

        for (int i = 0; i < vetorInteiro.length; i++) {
            if (vetorPesquisado == vetorInteiro[i]) {
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice " + i);
                indiceTeste = 1;
            }
            if (indiceTeste == 0 && i == tamanhoVetor) {
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice -1"); //foi requisitado no trabalho colocar "-1" para índice inexistente
            }
        }
    }

    public void alterarDado() {

        int tamanhoVetor = vetorInteiro.length - 1;

        int indiceVetor2 = Main.numeroInteiro("Escolha um índice para alterar o valor contido nele", semLimite);

        if (indiceVetor2 > tamanhoVetor || indiceVetor2 < 0) {
            System.out.println("Escolha um índice de 0 a " + tamanhoVetor + "!");
            alterarDado();

        } else {

            if (vetorInteiro[indiceVetor2] == 0) {
                System.out.println("Esse índice ainda não tem um valor a ser alterado, utilize Inserir Dado");
            } else {

                int inteiroVetor2 = Main.numeroInteiro("Escolha o novo valor a ser contido no índice", semLimite);
                vetorInteiro[indiceVetor2] = inteiroVetor2;
            }
        }

    }

}
