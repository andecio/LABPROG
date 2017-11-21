package Lab6;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Andécio
 */
public class CD {
     private String banda,principalFaixa, titulo;
    private int nFaixas;
    private int  N = 12;
    private final List<String> faixa;
   
   public CD(String titulo, String banda) throws Exception {
	informacoes(titulo, banda);
	nFaixas = N;
	faixa = new ArrayList<>(nFaixas);
	}

   private void informacoes(String titulo, String banda) throws Exception {
        if(titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        }
        else {
            throw new Exception("O nome do CD, não pode estar vazio.");
        }
        if(banda != null && !banda.trim().isEmpty()) {
            this.banda = banda;
        }
        else {
            throw new Exception("O nome da banda, nao pode estar vazio.");
            }
	}
   public CD(String titulo, String banda, int nFaixas) throws Exception{
        informacoesnFaixas(nFaixas);
        informacoes(titulo, banda);
        faixa = new ArrayList<>(this.nFaixas);
        
   }

    private void informacoesnFaixas(int nFaixas)throws Exception {
        if(nFaixas > 0) {
            this.nFaixas = nFaixas;
	}
        else {
            throw new Exception("O CD tem que apresentar pelo menos uma musica.");
	}
    }
    public String getTitulo() {
	return titulo;
    }
    public String getprincipalfaixa() {
	return principalFaixa;
    }
    public String getbanda(){
        return banda;
    }
    public int getnFaixas(){
        return nFaixas;
    }
       public List<String> getFaixas() {
		return faixa;
    
    }

    public boolean principalFaixa(String faixas) {
	if(faixas != null && !faixas.trim().isEmpty()) {
            for(int i = 0; i < faixa.size(); i++) {
		if(faixas.equals(faixa.get(i))) {
                    principalFaixa = faixas;
                    return true;
		}
            }
        }
        return false;
    }
 
    public boolean cadastrarFaixa(String musica) {
	if(faixa != null && !musica.trim().isEmpty() && faixa.size() < nFaixas) {
		return faixa.add(musica);
	}
	return false;
    }
    public String getFaixa(int indice){
	if(indice >= 0 && indice < faixa.size()){
            return faixa.get(indice);
	}
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
	StringBuilder string = new StringBuilder();
	string.append("Banda: "+getbanda());
	string.append("\nTítulo: "+getTitulo());
	string.append("\nPrincipal Faixa: "+getprincipalfaixa());
	string.append("\n\nLista de faixas: ");
	for(int i = 0; i < faixa.size(); i++) {
            string.append(String.format("\n%02d - %s", i+1, getFaixa(i)));
	}
            return string.toString();
    }
}
