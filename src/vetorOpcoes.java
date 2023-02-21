import java.util.Scanner;

public class vetorOpcoes {


    static Scanner scan = new Scanner(System.in);

    static int[] vetorInteiro;

    public static int[] criarVetor() {
        System.out.println("Quantos espaços (índices) você deseja para o vetor? (contando com 0)");
        int indiceScan = scan.nextInt();
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
                        "------------------------------\n" +
                        "Selecione a opcao desejada: ";


        System.out.println(listaPrintada);

        Scanner leitorOpcao = new Scanner(System.in);

        int opcaoSelecionada = 0;

        while (opcaoSelecionada < 5) {
            opcaoSelecionada = leitorOpcao.nextInt();

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
    }

    public void inserirDado() {

        int tamanhoVetor = vetorInteiro.length - 1;

        System.out.println("Escolha um número inteiro para adicionar");
        int inteiroVetor = scan.nextInt(); //o inteiro que vai ser adicionado

        System.out.println("Escolha um índice de 0 a " + tamanhoVetor + " para inserir seu inteiro");
        int indiceVetor = scan.nextInt(); //o índice do vetor ao qual o inteiro vai ser adicionado


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

        System.out.println("Qual valor você deseja verificar se está presente no vetor?:");
        int vetorPesquisado = scan.nextInt();

        for (int i = 0; i < vetorInteiro.length; i++) {
            if (vetorPesquisado == vetorInteiro[i]) {
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice " + i);
            }
            if (vetorPesquisado != vetorInteiro[i] && i == tamanhoVetor) {
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice -1"); //foi requisitado no trabalho colocar "-1" para índice inexistente
            }
        }
    }

    public void alterarDado() {

        int tamanhoVetor = vetorInteiro.length - 1;

        System.out.println("Escolha um índice para alterar o valor contido nele");
        int indiceVetor2 = scan.nextInt();

        if (indiceVetor2 == 0) {
            System.out.println("Esse índice ainda não tem um valor a ser alterado, utilize Inserir Dado");
        } else {

            if (indiceVetor2 > tamanhoVetor || indiceVetor2 < 0) {
                System.out.println("Escolha um índice de 0 a " + tamanhoVetor + "!");
                alterarDado();

            } else {
                System.out.println("Escolha o novo valor a ser contido no índice");
                int inteiroVetor2 = scan.nextInt();
                vetorInteiro[indiceVetor2] = inteiroVetor2;
            }
        }

    }

}
