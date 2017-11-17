package calculonumerico;
import java.util.ArrayList;
/**
 *
 * @author Andecio
 */
public class Gauss {
    private Matriz matriz;
	int k,posLinhaUsada,quantLinhaTrabalhada;
	float pivo;
	private ArrayList<Float> ms = new ArrayList<>(); 
	public Gauss(Matriz matriz){
		this.matriz = matriz;
		k=0;
	}
	private void iniciar(){
		pivo =matriz.getEle(k, k); 
		if(verificarElemento(pivo)){
			permutar();
		}else{
			quantLinhaTrabalhada++;
			if(calcularMs(quantLinhaTrabalhada)){
				if(attMatriz(quantLinhaTrabalhada)){
					if(verificarTriangulo()){
						matriz.imprimeMatriz(false);
					}else{
						k++;
						iniciar();
					}
				}
			}
		}
	}
	private boolean calcularMs(int linha){
		for(int i=linha;i<matriz.getI();i++){
		float mLinha =matriz.getEle(i,k) /pivo;
		ms.add(mLinha);
		}
		return true;
	}
	private boolean attMatriz(int p){
		int cont =0;
		for(int i=p;i<matriz.getI();i++){
			attLinha(ms.get(cont), i);
			cont++;
		}
		ms.clear();
		return true;
	}
	private void attLinha(float mDela,int linha){
		float[] linhaDoPivo = matriz.getLinha(k);
		float[]	linhaPivoMultiplicada = new float[linhaDoPivo.length];
		float[] novaLinha = new float[linhaDoPivo.length];
		float[] linhaASerAlterada = matriz.getLinha(linha);
		
		for(int i=0;i<linhaDoPivo.length;i++){
			linhaPivoMultiplicada[i] = linhaDoPivo[i]*mDela;
			novaLinha[i] = linhaASerAlterada[i]-linhaPivoMultiplicada[i];
		}
		matriz.setLinha(novaLinha, linha);
	}
	private boolean verificarElemento(float elemento){
		if(elemento==0){
			return true;
		}
		return false;
	}
	private void permutar(){
		float[] l_aPermutar = matriz.getLinha(k);
	    float[] l_P_Permutar = encontrarLinhaValida();
	    if(l_P_Permutar !=null){
	    	matriz.setLinha(l_P_Permutar,k);
	    	matriz.setLinha(l_aPermutar,posLinhaUsada);
	    }
	    verificarTriangulo();
	}
	private float[] encontrarLinhaValida(){
		for(int a=0;a<matriz.getI();a++){
			if(matriz.getEle(a+1,k)!=0){
				posLinhaUsada = a+1;
				return matriz.getLinha(a+1);
			}
		}
		return null;
	}
	private boolean verificarTriangulo(){
		boolean resultado;
		for(int a=0;a<matriz.getJ()-2;a++){
			resultado = auxTriangulo(a);
			if(resultado==false){
				return false;
			}
		}
		return true;
	}
	private boolean auxTriangulo(int p){
			for(int j=p+1;j<matriz.getI();j++){
				if(matriz.getEle(j, p)!=0){
					return false;
				}
			}
		return true;
	}
	public void gerarMatrizResposta(){
		iniciar();
	}
}