package infnet.loja.veiculos;

/**
 * Classe Motocicleta define uma nova Motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-04-2015
 */
public class Motocicleta extends Veiculo
{
	private EspecMoto espM;

	public EspecMoto getEspM() {
		return espM;
	}

	public void setEspM(EspecMoto espM) {
		this.espM = espM;
	}
}