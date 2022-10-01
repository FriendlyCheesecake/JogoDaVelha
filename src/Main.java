public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = {{'X', '0', 'X'},
                {'4', 'X', '6'},
                {'7', '8', 'X'}};
        String jogadorChar = "XXX";
        String nomeJogador = "Amanda";
        verificarGanhador(tabuleiro, jogadorChar, nomeJogador);

    }


    public static void verificarGanhador(char[][] tabuleiro, String jogadorChar, String nomeJogador) {

        String linha1 = String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[0][1])) + String.valueOf((tabuleiro[0][2]));
        String linha2 = String.valueOf((tabuleiro[1][0])) + String.valueOf((tabuleiro[1][1])) + String.valueOf((tabuleiro[1][2]));
        String linha3 =  String.valueOf((tabuleiro[2][0])) + String.valueOf((tabuleiro[2][1])) + String.valueOf((tabuleiro[2][2]));

        String coluna1 =  String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[1][0])) + String.valueOf((tabuleiro[2][0]));
        String coluna2 =  String.valueOf((tabuleiro[0][1])) + String.valueOf((tabuleiro[1][1])) + String.valueOf((tabuleiro[2][1]));
        String coluna3 =  String.valueOf((tabuleiro[0][2])) + String.valueOf((tabuleiro[1][2])) + String.valueOf((tabuleiro[2][2]));

        String diagonal1 =  String.valueOf((tabuleiro[0][0])) + String.valueOf((tabuleiro[1][1])) + String.valueOf((tabuleiro[2][2]));
        String diagonal2 = String.valueOf((tabuleiro[0][2])) + String.valueOf((tabuleiro[1][1])) + String.valueOf((tabuleiro[2][0]));

        if(diagonal1.equals(jogadorChar))

        System.out.println(nomeJogador + ", Voce venceu");

        else {
            System.out.println("Velha");
        }
    }
}