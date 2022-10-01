
import java.util.Scanner;

//Tabuleiro e While de Jogadas, mas sem verificação
public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro = {{'1','|','2','|','3'},{'-','+','-','+','-'},{'4','|','5','|','6'},{'-','+','-','+','-'},{'7','|','8','|','9'}};

        imprimeTabuleiro(tabuleiro);
        Scanner jogada = new Scanner(System.in);

        while(true) {
            //Jogador1 faz sua jogada
            System.out.println("Jogador 1, escolha e digite o número de uma posição vazia:");
            int posicaoJogador1 = jogada.nextInt();

            //Exibe jogada jogador1
            marcaPosicao(tabuleiro, posicaoJogador1, "jogador 1");

            //Jogador2 faz sua jogada
            System.out.println("Jogador 2, escolha e digite o número de uma posição vazia:");

            int posicaoJogador2 = jogada.nextInt();

            //Exibe jogada jogador2
            marcaPosicao(tabuleiro, posicaoJogador2, "jogador 2");

        }

    }
    //Imprimir tabuleiro
    public static void imprimeTabuleiro(char[][] tabuleiro) {

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void marcaPosicao(char[][] tabuleiro, int posicao, String jogador){
        //Impressão da jogada no tabuleiro
        char marca = 'X';
        if(jogador.equals("jogador 1")){
            marca = 'X';
        } else if(jogador.equals("jogador 2")){
            marca = 'O';
        }

        switch(posicao) {
            case 1:
                tabuleiro[0][0] = marca;
                break;
            case 2:
                tabuleiro[0][2] = marca;
                break;
            case 3:
                tabuleiro[0][4] = marca;
                break;
            case 4:
                tabuleiro[2][0] = marca;
                break;
            case 5:
                tabuleiro[2][2] = marca;
                break;
            case 6:
                tabuleiro[2][4] = marca;
                break;
            case 7:
                tabuleiro[4][0] = marca;
                break;
            case 8:
                tabuleiro[4][2] = marca;
                break;
            case 9:
                tabuleiro[4][4] = marca;
                break;
        }
        imprimeTabuleiro(tabuleiro);
    }
}
