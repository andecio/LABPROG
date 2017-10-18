/*
Aluno: Andécio Araujo
Lab4
Série de Fibonacci
 */

package Lab4;

/**
 *
 * @author andecio
 */
public class Fibonacci {
    private int atual = 0, anterior = 0;
    
	/*Métodos    
	 Calcula o n-esimo termo da progressão de Fibonacci.
	 @param elementos
	 O termo n a ser mostrado.
	 @return O termo atual da progressão de Fibonacci que vai ser o termo solicitado.
	 */

    /**
     *
     * @param elementos
     * @return
     */

    
	public int termoFibonacci(int elementos) {
		for (int i = 0; i < elementos; i++) {
			if (i == 1) {
				atual = 1;
				anterior = 0;
			} else {
				atual = atual + anterior;
				anterior = atual - anterior;
			}
		}
		return atual;
	}
        
	/*Gera os "n" primeiros termos (1 .. n) da progressão de Fibonacci
	 @param n
	 A quantidade de termos a serem gerados.
	 @return Os termos "n" da progressão de Fibonacci.
	 */

    /**
     *
     * @param n
     */

        
	public void geraTermoFibo(int n){
		if (n <= 0){
			System.out.println("Informe um valor positivo maior que zero.");
		}else{
			for (int i = 0; i < n; i++) {
				System.out.printf("Termo[%d]: %d\n", i + 1, termoFibonacci(i+1));
			}
		}
	}
}
