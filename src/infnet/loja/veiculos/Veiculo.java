package infnet.loja.veiculos;
/**
 * Classe Veiculo eh a classe pai de carro e motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public abstract class Veiculo {
	protected EspecificacaoVeiculo espV;

	/**
	 * getter da especificacao do veiculo
	 * @return especificacao do veiculo
	 */
	public EspecificacaoVeiculo getEspV() {
		return espV;
	}

	/**
	 * setter da especificacao do veiculo
	 * @param espV especificacao do veiculo
	 */
	public void setEv(EspecificacaoVeiculo espV) {
		this.espV = espV;
	}
	
	
}
