package calculonumerico;
/**
 *
 * @author andecio
 */
public class Matriz {
    private float[][] matriz; 
	private int i,j;
	public Matriz(int i,int j){
		this.i=i;
		this.j=j;
		matriz = new float[this.i][this.j];
		}
public void alimentarMatriz(float[] valores){
	int cont=0;
	for(int a=0;a<i;a++){
		for(int b=0;b<j;b++){
			matriz[a][b]= valores[cont];
			cont++;
		}
	}
}
public void imprimeMatriz(boolean e){
	if(!e){
	System.out.println("Resultado da Matriz");
	}else{
	System.out.println("<atriz inicial");
	}
	int cont=0;
	for(int a=0;a<i;a++){
		for(int b=0;b<j;b++){
			System.out.print("("+matriz[a][b]+") ");
			cont++;
			if(cont>=j){
				System.out.println();
				cont=0;
			}
		}
	}
}
public void setLinha(float[] valor,int linha){
	for(int a =0;a<valor.length;a++){
		matriz[linha][a]=valor[a];
	}
}
public float[] getLinha(int linha){
	float[] saida = new float[j];
	for(int a =0;a<j;a++){
		saida[a]=matriz[linha][a];
	}
	return saida;
}

public float[] getColuna(int coluna){
	float[] saida = new float[i];
	for(int a =0;a<i;a++){
		saida[a]=matriz[a][coluna];
	}
	return saida;
}
public int getI() {
	return i;
}
public float getEle(int i,int j){
	return matriz[i][j];
}
public int getJ() {
	return j;
}
}