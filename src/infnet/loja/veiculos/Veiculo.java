package infnet.loja.veiculos;

import java.io.IOException;
import infnet.loja.enums.Cor;
import infnet.loja.enums.Montadora;

/**
 * Classe Veiculo eh a classe pai de carro e motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
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
	 *getChassi Retorna o chassi do veiculo
	 * @return chassi chassi do veiculo
	 */
	public String getChassi() {
		return chassi;
	}

	/**
	 * setChassi altera o valor da variavel chassi para String que foi passado pelo parametro chassi
	 * @param chassi 
	 * @param loja loja do veiculo
	 * @return 
	 * @throws IOException 
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
	 * @param montadora 
	 * @param loja loja do veiculo
	 * @return 
	 * @return 
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
	 * @param cor 
	 * @param cor cor do veiculo
	 * @return 
	 */
	public Cor setCor(Cor cor) {
		return this.cor = cor;
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
	 * @param preco 
	 * @param preco preco do veiculo
	 * @return 
	 */
	public float setPreco(float preco) { 
		return this.preco = preco;
	}

}
