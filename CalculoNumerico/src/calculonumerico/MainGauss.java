package calculonumerico;
/**
 *
 * @author andecio
 */
public class MainGauss {
    private static float[] valores;
	public static void main(String[] args) {
		Matriz matriz = new Matriz(4,5);
		float[] valores = {1,-1,1,1,-1,
						   4,-2,3,1,2,
						   1,-5,-2,2,-13,
						   2,5,1,1,12};
		matriz.alimentarMatriz(valores);
		matriz.imprimeMatriz(true);
		System.out.println();
		Gauss g = new Gauss(matriz);
		g.gerarMatrizResposta();
	}
}