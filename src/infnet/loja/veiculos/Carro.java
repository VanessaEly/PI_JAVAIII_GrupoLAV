package infnet.loja.veiculos;

/**
 * Classe Carro define um novo carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class Carro extends Veiculo 
{
	private EspecCarro espC;

	public EspecCarro getEspC() {
		return espC;
	}

	public void setEspC(EspecCarro espC) {
		this.espC = espC;
	}
}