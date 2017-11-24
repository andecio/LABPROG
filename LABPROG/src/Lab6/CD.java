/* Universidade Estadual da Paraíba
*  Atividade de Laboratório 6 - Prof.: Daniel Gondim
*  Alunos: Andécio Araujo , Kelvin Vandick
*/
package Lab6;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um CD de músicas.
*/

public class CD{
	
	private ArrayList<String> musicas = new ArrayList<String>();
	private String nomeAlbum, nomeArtista, trilhaPrincipal;
	private int M;
        
/**
 * Construtor: recebe o nome do álbum, nome do artista e nº de músicas do CD
 * @param nomeAlbum O nome do CD.
 * @param nomeArtista O artista do CD.
 * @param M O numero de musicas do CD
 * @throws Exception Se o album ou artista for 'null', string vazia e se numero de faixas for menor ou igual a zero.
 */
        
	public CD(String nomeAlbum, String nomeArtista, int M) throws Exception{
		if (nomeAlbum == null || nomeAlbum.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}
                if (nomeArtista == null || nomeArtista.trim().isEmpty()){
			throw new Exception ("Artista do album nao pode ser nulo ou vazio.");
		}
                if (M <= 0){
			throw new Exception ("Numero de faixas nao pode ser igual ou inferior a zero");
		}
		this.nomeArtista = nomeArtista;
		this.nomeAlbum = nomeAlbum;
		this.M = M;
                this.trilhaPrincipal = "";
                adicionaMusicasVaziasCD();
	}
	
/**
* Construtor default: recebe o nome do álbum e o artista do CD. O valor para o nº de faixas predefinido é 10.
* @param nomeAlbum O nome do CD.
* @param nomeArtista O artista do CD.
* @throws Exception Se o álbum ou artista for 'null' ou se a string estiver vazia.
 */
        
	public CD(String nomeAlbum, String nomeArtista) throws Exception {
		if (nomeAlbum == null || nomeAlbum.trim().isEmpty()){
			throw new Exception ("Titulo do album nao pode ser nulo ou vazio.");
		}
                if (nomeArtista == null || nomeArtista.trim().isEmpty()){
			throw new Exception ("Artista do album nao pode ser nulo ou vazio.");
		}
		this.nomeArtista = nomeArtista;
		this.nomeAlbum = nomeAlbum;
		this.M = 10;
		this.trilhaPrincipal = "";
                adicionaMusicasVaziasCD();
	}
        
/**
* Inseri a nova música no álbum
* @param novaMusica O nome da musica que deseja adicionar no CD.
* @return True se a condição do indice estiver dentro do cd ai a musica sera adicionada ou false que não adicionou a musica pois esta fora do indice
*/
        
	public boolean adicionaMusica(String novaMusica)  {
		int indice = musicas.indexOf("");
		if (indice <= musicas.size() && indice != -1 && novaMusica != null) {
			musicas.set(indice, novaMusica);
			return true;
		}
		return false;
	}
/**
* Informação do Artista
* @return Nome do artista
*/
        /**
* Adiciona a quantidade de musicas que o cd vai conter para ter controle do indice do CD
*/
        
        private void adicionaMusicasVaziasCD () {
		for (int i = 0; i < M; i++) {
			musicas.add(i, "");
		}
	}

        
	public String getArtista() {
		return nomeArtista;
	}
/**
* Informação do Nome do album
* @return Nome do album
*/
        
	public String getAlbum() {
		return nomeAlbum;
	}
/**
* Informação do numero de faixas
* @return Numero de faixas
*/
        
	public int getM(){
		return M;
	}
/**
* Qual a trilha principal do cd
* @return O nome da trilha principal do CD
*/
        
	public String getTrilhaPrincipal () {
		return trilhaPrincipal;
	}
	
	public String getMusica(int i){
            if (i >= M || i < 0) {
		return null;
            }
            return musicas.get(i-1);
	}
	
        public void setTrilhaPrincipal (String trilhaPrincipal) throws Exception {
		if (!(musicas.contains(trilhaPrincipal))) {
			throw new Exception("A trilha nao existe no CD, nao vai ser adicionada.");
		}
		this.trilhaPrincipal = trilhaPrincipal;
	}

        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musicas == null) ? 0 : musicas.hashCode());
		result = prime * result + ((nomeAlbum == null) ? 0 : nomeAlbum.hashCode());
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
		return result;
	}

        @Override
	public boolean equals(Object album){
		if (album instanceof CD){
			CD novoAlbum = (CD)album;
			return nomeAlbum.equals(novoAlbum.getAlbum()) && nomeArtista.equals(novoAlbum.getArtista());
		}
		return false;
	}
	
        @Override
	public String toString(){
		String resultado = "\nAlbum: " + nomeAlbum + ", Artista: " + nomeArtista;
		for (String msc: musicas){
			resultado += msc; 
		}
		return resultado;
	}
}