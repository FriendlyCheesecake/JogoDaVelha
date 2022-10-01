
import java.util.Scanner;

//Tabuleiro e While de Jogadas, mas sem verificação
public class JogoDaVelha {
    static int turns =0;
static int firstPlayerPoints = 0;
static int secondPlayersPoints = 0;
    static String firstPlayerName;

    static String secondPlayerName;
;
    static boolean Winner = false;
    static boolean Draw = false;
    static Scanner input = new Scanner(System.in);
    static char[][] tabuleiro = {
            {'1', '|', '2', '|', '3'},
            {'4', '|', '5', '|', '6'},
            {'7', '|', '8', '|', '9'}};

    public static void main(String[] args) {



        startGame();
        System.out.println("Novo jogo iniciado:");
        System.out.println();

        playGame();
    }

        public static void playGame() {
            imprimeTabuleiro(tabuleiro);
            Scanner jogada = new Scanner(System.in);


            while (!Winner || !Draw) {
                //Jogador1 faz sua jogada
                System.out.println(firstPlayerName + ", escolha e digite o número de uma posição vazia:");
                char posicaoJogador1 = jogada.next().charAt(0);
                String jogadorChar = "XXX";
                turns++;
                //Exibe jogada jogador1
                marcaPosicao(tabuleiro, posicaoJogador1, "jogador 1");
                verificarGanhador(tabuleiro, jogadorChar, firstPlayerName);
                if (Winner) {
                    firstPlayerPoints++;
                    getPlacar(firstPlayerName, firstPlayerPoints, secondPlayerName, secondPlayersPoints);
                    break;
                }
                ;

                if (Draw) break;

                //Jogador2 faz sua jogada
                System.out.println(secondPlayerName + ", escolha e digite o número de uma posição vazia:");

                char posicaoJogador2 = jogada.next().charAt(0);
                jogadorChar = "OOO";
                turns++;
                //Exibe jogada jogador2
                marcaPosicao(tabuleiro, posicaoJogador2, "jogador 2");
                verificarGanhador(tabuleiro, jogadorChar, secondPlayerName);
                if (Winner) {
                    secondPlayersPoints++;
                    getPlacar(secondPlayerName, secondPlayersPoints, firstPlayerName, firstPlayerPoints);
                    break;

                }
                if (Draw) break;
            }
        }


    public static void startGame() {
        System.out.println("Bem vindo ao Jogo da Velha! Gostaria de iniciar uma partida?");
        System.out.println("| 1 - SIM   | 2 - NÃO  |");


        switch (input.nextInt()) {
            case 1:
                System.out.println("Insira os dados dos jogadores: ");
                getPlayerInformation();
                break;
            case 2:
                System.out.println("Ah! Que pena! Até a próxima!");
                break;
        }


    }

    public static void getPlayerInformation() {


        System.out.println("Qual o nome do primeiro jogador? ");
        firstPlayerName = input.next();
        System.out.println(firstPlayerName + " você será o X !");


        System.out.println("Qual o nome do segundo jogador? ");
        secondPlayerName = input.next();
        System.out.println(secondPlayerName + " você será o O !");

    }


    public static void imprimeTabuleiro(char[][] tabuleiro) {


        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void marcaPosicao(char[][] tabuleiro, char posicao, String jogador) {
        //Impressão da jogada no tabuleiro
        char marca = 'X';
        if (jogador.equals("jogador 1")) {
            marca = 'X';
        } else if (jogador.equals("jogador 2")) {
            marca = 'O';
        }

        switch (posicao) {
            case '1':
                tabuleiro[0][0] = marca;
                break;
            case '2':
                tabuleiro[0][2] = marca;
                break;
            case '3':
                tabuleiro[0][4] = marca;
                break;
            case '4':
                tabuleiro[1][0] = marca;
                break;
            case '5':
                tabuleiro[1][2] = marca;
                break;
            case '6':
                tabuleiro[1][4] = marca;
                break;
            case '7':
                tabuleiro[2][0] = marca;
                break;
            case '8':
                tabuleiro[2][2] = marca;
                break;
            case '9':
                tabuleiro[2][4] = marca;
                break;
        }

        imprimeTabuleiro(tabuleiro);
    }

    public static void verificarGanhador(char[][] tabuleiro, String jogadorChar, String nomeJogador) {

        String linha1 = String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[0][2])) + String.valueOf((tabuleiro[0][4]));
        String linha2 = String.valueOf((tabuleiro[1][0])) + String.valueOf((tabuleiro[1][2])) + String.valueOf((tabuleiro[1][4]));
        String linha3 = String.valueOf((tabuleiro[2][0])) + String.valueOf((tabuleiro[2][2])) + String.valueOf((tabuleiro[2][4]));

        String coluna1 = String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[1][0])) + String.valueOf((tabuleiro[2][0]));
        String coluna2 = String.valueOf((tabuleiro[0][2])) + String.valueOf((tabuleiro[1][2])) + String.valueOf((tabuleiro[2][2]));
        String coluna3 = String.valueOf((tabuleiro[0][4])) + String.valueOf((tabuleiro[1][4])) + String.valueOf((tabuleiro[2][4]));

        String diagonal1 = String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[1][2])) + String.valueOf((tabuleiro[2][4]));
        String diagonal2 = String.valueOf((tabuleiro[0][4])) + String.valueOf((tabuleiro[1][2])) + String.valueOf((tabuleiro[2][0]));


        if (linha1.equals(jogadorChar) ||
        linha2.equals(jogadorChar) ||
        linha3.equals(jogadorChar) ||
        coluna1.equals(jogadorChar) ||
        coluna2.equals(jogadorChar) ||
        coluna3.equals(jogadorChar) ||
        diagonal1.equals(jogadorChar) ||
        diagonal2.equals(jogadorChar)) {
            Winner = true;

            System.out.println(nomeJogador + ", Voce venceu");


        } else if (turns == 9) {
            Draw = true;
            System.out.println("VELHA! Deseja jogar outra partida?");
            System.out.println("| 1 - SIM   | 2 - NÃO  |");
            switch (input.nextInt()) {
                case 1:
                    resetaTabuleiro();
                    playGame();
                    break;
                case 2:
                    System.out.println("Ah! Que pena! Até a próxima!");
                    input.close();
                    break;
            }
        }



    }

    public static void getPlacar(String nomeJogadorVencedor, int pontosVencedor, String nomeOutroJogador, int pontosOutroJogador) {
        System.out.println("Placar:");
        System.out.println(nomeJogadorVencedor + ": " + pontosVencedor + " X " + nomeOutroJogador + ": " + pontosOutroJogador);
        System.out.println("Revanche?");
        System.out.println("| 1 - SIM   | 2 - NÃO  |");
        switch (input.nextInt()) {
            case 1:

                resetaTabuleiro();
                playGame();
                break;
            case 2:
                System.out.println("Ah! Que pena! Até a próxima!");
                input.close();
                break;

        }
    }

    public static void resetaTabuleiro() {
        turns = 0;
        Winner = false;
        Draw = false;
        tabuleiro = new char[][]{
                {'1', '|', '2', '|', '3'},
                {'4', '|', '5', '|', '6'},
                {'7', '|', '8', '|', '9'}};
    }
}