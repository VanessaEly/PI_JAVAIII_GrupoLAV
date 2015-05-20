package infnet.loja.veiculos;
/**
 * Classe Veiculo eh a classe pai de carro e motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public abstract class Veiculo {
	protected EspecificacaoVeiculo espV;

	public EspecificacaoVeiculo getEspV() {
		return espV;
	}

	public void setEv(EspecificacaoVeiculo espV) {
		this.espV = espV;
	}
	
	
}
