/*
 Componente Curricular: Laboratorio de Programação
 Aluno: Andécio Araujo Batista
*/
package Lab2; 
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class PedraPapelTesoura {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	final int JOGADAS = 3;
	final int PARASAIR = -1;
	int JOGADOR1;
	int JOGADOR2;
	String selecioneJogador;
	public static void main(String[] args) {
		PedraPapelTesoura jogo = new PedraPapelTesoura();
		jogo.play();
	}
	public void play() {
		selecioneJogador = tipoDeJogo();
		while(true) {
			System.out.print("JOGADOR 1:");
			JOGADOR1 = selecionarJogador();
			System.out.printf("%s: ", selecioneJogador);
			if(selecioneJogador.equals("JOGADOR MAQUINA")){
				JOGADOR2 = 1+rand.nextInt(3);
				System.out.println(JOGADOR2);
			}else {
				JOGADOR2 = selecionarJogador();
			}
			
			System.out.printf("\n%s - %s\n", jogada(JOGADOR1), jogada(JOGADOR2));
			if(!resultado()) {
				sc.nextLine();
				String buffer = sc.nextLine();
				if(buffer.equals("-1"))
					break;
			}
		}
	}
	public String tipoDeJogo() {
		int aux = -1;
		do {
			System.out.print("Deseja jogar contra: (1) Outro Jogador - (2) A Maquina ? ");
			try{
				aux = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.nextLine();
				//Não trata nada, apenas repetirá a mensagem solicitando um valor
			}
		}while(aux < 1 || aux > 2);
		return aux == 1 ? "JOGADOR 2" : "COMPUTADOR";
	}	
	public int selecionarJogador() {
		int escolha = -1;
		do {
			System.out.print("\n(1)Para selecionar PEDRA - (2) Para selecionar PAPEL - (3) Para selecionar TESOURA ");
			try {
				escolha = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.nextLine();
				//Não trata nada, apenas repetirá a mensagem solicitando um valor
			}
		}while(escolha < 1 || escolha > JOGADAS);
		return escolha;
	}
	public String jogada(int escolhaDoPlayer) {
		String jogada = "";
		switch(escolhaDoPlayer) {
			case 1: jogada = "PEDRA";
				break;
			case 2: jogada = "PAPEL";
				break;
			case 3: jogada = "TESOURA";
				break;
		}
		return jogada;
	}
	public boolean resultado() {
		int resultado = Math.abs((JOGADAS+JOGADOR1-JOGADOR2) % JOGADAS);

		if(0 < resultado && resultado <= (JOGADAS/2)) {
			System.out.println("O GANHADOR FOI O JOGADOR 1!");
		}else if(resultado > (JOGADAS/2)) {
			System.out.printf("O %s VENCEU!\n", selecioneJogador);
		}else{
			System.out.println("JOGO EMPATADO!\n");
			return true;
		}
		return false;
	}
}