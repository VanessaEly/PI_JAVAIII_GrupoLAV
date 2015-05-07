package infnet.loja.veiculos;

import infnet.loja.enums.Cor;
import infnet.loja.enums.Montadora;

public class Veiculo {
	protected String chassi;
	protected Montadora montadora;
	protected Cor cor;
	protected float preco;
	
	/**
	 *getChassi Retorna o chassi do veiculo
	 * @return chassi chassi do veiculo
	 */
	public String      getChassi() {
		return chassi;
	}

	/**
	 * setChassi altera o valor da variavel chassi para String que foi passado pelo parametro chassi
	 * @param chassi chassi do veiculo
	 */
	public void        setChassi(String chassi) {
		this.chassi = chassi;
	}

	/**
	 * getMontadora Retorna a montadora do veiculo
	 * @return montadora montadora do veiculo
	 */
	public Montadora   getMontadora() {
		return montadora;
	}

	/**
	 * setMontadora altera o valor da variavel montadora para enum Montadora que foi passado pelo parametro montadora
	 * @param montadora montadora do veiculo
	 */
	public void        setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	/**
	 * getCor retorna a cor do veiculo
	 * @return cor cor do veiculo
	 */
	public Cor        getCor() {
		return cor;
	}

	/**
	 * setCor altera o valor da variavel cor para enum Cor que foi passado pelo parametro cor
	 * @param cor cor do veiculo
	 */
	public void       setCor(Cor cor) {
		this.cor = cor;
	}
	
	/**
	 * getPreco retorna o preco da moto
	 * @return preco preco da moto
	 */
	public float      getPreco() {
		return preco;
	}

	/**
	 * setPreco altera o valor da variavel preco para o float que foi passado pelo parametro preco
	 * @param preco preco da moto
	 */
	public void       setPreco(float preco) {
		this.preco = preco;
	}
	
}
