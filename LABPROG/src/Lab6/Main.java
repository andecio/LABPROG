/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab6;
import java.util.ArrayList;
import Lab6.CD;
import Lab6.MinhaCDTeca;

/**
 *
 * @author andecio
 */
public class Main {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CD album = new CD(" Seleção ", "Ao Vivo", 6);
        
        album.adicionaMusica("Music A");
        album.adicionaMusica("Music B");
        album.adicionaMusica("Music C");
        album.adicionaMusica("Music D");
        album.adicionaMusica("Music E");
        album.adicionaMusica("Music F");
        album.adicionaMusica("Music G");
        album.setTrilhaPrincipal("Music D");
        System.out.println(album.toString());
        
        MinhaCDTeca cdTeca = new MinhaCDTeca();      
       
        CD cdMarina = new CD("Evanescense", "Metalica", 15);
	CD	cdRihanna = new CD("Loud", "Guns N'Roses", 15);
		CD cdColdplay = new CD("As melhores", "Coldplay", 11);
        cdTeca.adicionarCD(cdMarina);
        cdTeca.adicionarCD(cdRihanna);
        cdTeca.adicionarCD(cdColdplay);
        
        System.out.println(cdTeca.numeroDeCDs());
        System.out.print(cdTeca.toString());
          
    }
}