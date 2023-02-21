import java.util.Scanner;

public class vetorOpcoes {
    Main loop = new Main();
    public int [] vetorInteiro = new int[10];
    Scanner scan = new Scanner(System.in);
    public void vetorOpcoes(){
       String listaPrintada =
                "------------------------------\n" +
                "|           Vetor            |\n" +
                "------------------------------\n" +
                "|   1 -  Inserir dado        |\n"+
                "|   2 -  Alterar dado        |\n"+
                "|   3 -  Pesquisar dado      |\n"+
                "|   4 -  Mostrar dados       |\n"+
                "|   5 -  Voltar              |\n"+
                "------------------------------\n"+
                "Selecione a opcao desejada: ";

       System.out.println(listaPrintada);

       Scanner leitorOpcao = new Scanner(System.in);

       int opcaoSelecionada = 0;

       while(opcaoSelecionada < 5){
           opcaoSelecionada = leitorOpcao.nextInt();

           if(opcaoSelecionada == 0){
               vetorOpcoes();
           }
           if(opcaoSelecionada == 1){
               inserirDado();
               vetorOpcoes();
           }
           if(opcaoSelecionada == 2){
               alterarDado();
               vetorOpcoes();
           }
           if(opcaoSelecionada == 3){
               pesquisarDado();
               vetorOpcoes();
           }
           if(opcaoSelecionada == 4){
               mostrarDados();
               vetorOpcoes();
           }
           if(opcaoSelecionada == 5){
               Main.loop();
           }
       }
    }

    public void inserirDado(){

        System.out.println("Escolha um número inteiro para adicionar");
        int inteiroVetor = scan.nextInt(); //o inteiro que vai ser adicionado

        System.out.println("Escolha um índice de 0 a 9 para inserir seu inteiro");
        int indiceVetor = scan.nextInt(); //o índice do vetor ao qual o inteiro vai ser adicionado

        if(indiceVetor > 10 || indiceVetor < 0) {
            System.out.println("Escolha um índice de 0 a 9!");
            inserirDado();

        }else{
            vetorInteiro[indiceVetor] = inteiroVetor;
        }

    }

    public void mostrarDados(){
        System.out.printf("%s %10s \n", "Índice", "Valores");
        for(int i = 0; i < vetorInteiro.length; i++){
            System.out.printf(" %3d %10d \n", i, vetorInteiro[ i ]);}
    }

    public void pesquisarDado(){
        System.out.println("Qual valor você deseja verificar se está presente no vetor?:");
        int vetorPesquisado = scan.nextInt();

        for(int i = 0; i < vetorInteiro.length; i++){
            if(vetorPesquisado == vetorInteiro[i]){
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice " + i);
                break;
            }
            if(vetorPesquisado != vetorInteiro[i] && i == 9){
                System.out.println("O valor pesquisado " + vetorPesquisado + " está presente no índice -1");
            }
        }
    }

    public void alterarDado(){

        System.out.println("Escolha um índice para alterar o valor contido nele");
        int indiceVetor2 = scan.nextInt();

        System.out.println("Escolha o novo valor a ser contido no índice");
        int inteiroVetor2 = scan.nextInt();


        if(indiceVetor2 > 10 || indiceVetor2 < 0) {
            System.out.println("Escolha um índice de 0 a 9!");
            inserirDado();

        }else{
            vetorInteiro[indiceVetor2] = inteiroVetor2;
        }

    }

}
