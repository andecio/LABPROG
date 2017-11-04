/* Universidade Estadual da Paraíba
*  Atividade de Laboratório nº03 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo - Kelvin Vandik
 */
package Lab3;
public class Jogo {
    char[][] table = new char[3][3];
    public void inicializarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                table[i][p] = ' ';
            }
        }
    }
    public boolean verificarSlotValido(int linha, int coluna) {
        if ((linha < 1 || linha > 3) || (coluna < 1 || coluna > 3)) {
            return true;
        }
        return false;
    }
    public void trocarLado(char player, int linha, int coluna) {
        table[linha][coluna] = player;
    }
    public void exibirTabuleiro() {
        System.out.println("\n");
        System.out.println("  1  " + table[0][0] + "|" + table[0][1] + "|" + table[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + table[1][0] + "|" + table[1][1] + "|" + table[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  3  " + table[2][0] + "|" + table[2][1] + "|" + table[2][2]);
        System.out.println("     1 2 3 ");
        System.out.println("\n");
    }
    public char mudarPlayer(char player) {
        char novaRodada = '-';
        if (player == 'O') {
            novaRodada = 'X';
        }
        if (player == 'X') {
            novaRodada = 'O';
        }
        return novaRodada;
    }
    public boolean verificarVencedor() {
        if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && (table[0][1] == 'X' || table[0][1] == 'O')) {
            return true;
        } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && (table[0][2] == 'X' || table[0][2] == 'O')) {
            return true;
        } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && (table[1][0] == 'X' || table[1][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && (table[0][0] == 'X' || table[0][0] == 'O')) {
            return true;
        } else if (table[2][0] == table[1][1] && table[1][1] == table[0][2] && (table[2][0] == 'X' || table[2][0] == 'O')) {
            return true;
        } else {
            return false;
        }
    }
    public boolean verificarSlot(int linha, int coluna) {
        if ((linha > 2 || coluna > 2) || (linha < 0 || coluna < 0)) {
            return true;
        } else if (table[linha][coluna] == 'X' || table[linha][coluna] == 'O') {
            return true;
        }
        return false;
    }
    public boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 3; p++) {
                if (table[i][p] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}