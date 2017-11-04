/*
 Componente Curricular: Laboratorio de Programação
 Aluno: Andécio Araujo Batista
*/
package Lab4;
public class ProgressaoAritmetica {
    public static void main(String[] args) {
	ProgressaoAritmetica pa = new ProgressaoAritmetica(2, 4);
	
	//mostra 5 primeiros termos da PA, gerando um por vez
	System.out.println("5 primeiros termos da PA: um por vez...");
	System.out.println("Primeiro: " + pa.primeiro());
	for (int i = 2; i <=5; i++) {
		System.out.println("Termo " + i + ": " + pa.proximo());
	}
	
	//mostra um termo qualquer e seu proximo
	System.out.println("Um termo qualquer (8): " + pa.termo(8));
	System.out.println("Proximo: " + pa.proximo());
	
	//mostra 5 primeiros termos da PA, gerando todos de uma vez
	System.out.println("5 primeiros termos da PA: todos de uma vez...");
	System.out.println(pa.geraTermos(5));
	System.out.println("Proximo: " + pa.proximo());
	
	//reinicia a PA
	System.out.println("Primeiro: " + pa.primeiro());
	System.out.println("Proximo: " + pa.proximo());
    }

    private ProgressaoAritmetica(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String primeiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String proximo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String termo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean geraTermos(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

