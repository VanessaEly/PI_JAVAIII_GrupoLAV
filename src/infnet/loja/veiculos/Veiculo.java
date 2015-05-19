package infnet.loja.veiculos;

import infnet.loja.enums.Cor;
import infnet.loja.enums.Montadora;

/**
 * Classe Veiculo eh a classe pai de carro e motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public abstract class Veiculo {
	protected String chassi;
	protected Montadora montadora;
	protected Cor cor;
	protected float preco;

	/**
	 * Construtor veiculo constroi um novo veiculo
	 * @param chassi chassi do veiculo
	 * @param montadora montadora do veiculo
	 * @param cor cor do veiculo
	 * @param preco preco do veiculo
	 */
	public Veiculo(String chassi, Montadora montadora, Cor cor, float preco) {
		this.chassi = chassi;
		this.montadora = montadora;
		this.cor = cor;
		this.preco = preco;
	}

	/**
	 * Metodo equals sobrescreve o equals da classe
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Veiculo other = (Veiculo) obj;
		if ((this.chassi.equals(other.chassi) == false)&&(this.cor != other.cor)&&(this.montadora != other.montadora)&&(Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)))
			return false;
		return true;
	}

	/**
	 *getChassi Retorna o chassi do veiculo
	 * @return chassi chassi do veiculo
	 */
	public String getChassi() {
		return chassi;
	}

	/**
	 * setChassi altera o valor da variavel chassi para String que foi passado pelo parametro chassi
	 * @param chassi chassi do veiculo
	 */
	public void setChassi(String chassi){
		this.chassi = chassi;
	}

	/**
	 * getMontadora Retorna a montadora do veiculo
	 * @return montadora montadora do veiculo
	 */
	public Montadora getMontadora() {
		return montadora;
	}

	/**
	 * setMontadora altera o valor da variavel montadora para enum Montadora que foi passado pelo parametro montadora
	 * @param montadora montadora do veiculo
	 */
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	/**
	 * getCor retorna a cor do veiculo
	 * @return cor cor do veiculo
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * setCor altera o valor da variavel cor para enum Cor que foi passado pelo parametro cor
	 * @param cor cor do veiculo
	 */
	public void setCor(Cor cor) {
		this.cor = cor;
	}

	/**
	 * getPreco retorna o preco do veiculo
	 * @return preco preco do veiculo
	 */
	public float      getPreco() {
		return preco;
	}

	/**
	 * setPreco altera o valor da variavel preco para o float que foi passado pelo parametro preco
	 * @param preco preco do veiculo
	 */
	public void setPreco(float preco) { 
		this.preco = preco;
	}

}
