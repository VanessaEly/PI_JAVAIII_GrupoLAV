package infnet.loja.veiculos;

import infnet.loja.enums.*;

/**
 * Classe Carro define um novo carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 08-04-2015
 */
public class Carro extends Veiculo 
{
	//VARIAVEIS DA CLASSE
	
	private ModeloCarro modelo;
	private TipoCarro tipo; 
	private float motorizacao;
	private Cambio cambio;

	/**
	 * Construtor Carro constroi um novo carro
	 * @param chassi chassi do carro
	 * @param montadora montadora do carro
	 * @param modelo modelo do carro
	 * @param tipo tipo do carro
	 * @param cor cor do carro
	 * @param motorizacao motorizacao do carro
	 * @param cambio cambio do carro
	 * @param preco preco do carro
	 */
	public Carro(String chassi, Montadora montadora, ModeloCarro modelo, TipoCarro tipo, Cor cor, 
			float motorizacao, Cambio cambio, float preco) 
	{
		super(chassi, montadora, cor, preco);
		this.tipo        = tipo;
		this.modelo         = modelo;
		this.motorizacao = motorizacao;
		this.cambio      = cambio;
	}

	/**
	 * Metodo equals sobrescreve o equals da classe
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (cambio != other.cambio)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (cor != other.cor)
			return false;
		if (modelo != other.modelo)
			return false;
		if (montadora != other.montadora)
			return false;
		if (Float.floatToIntBits(motorizacao) != Float
				.floatToIntBits(other.motorizacao))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	//-------------------------GETTERS AND SETTERS------------------------------------------------------------------------
	/**
	 * getModelo Retorna o modelo do carro
	 * @return modelo modelo do carro
	 */
	public ModeloCarro getModelo() {
		return modelo;
	}

	/**
	 * setModelo altera o valor da variavel modelo para enum ModeloCarro que foi passado pelo parametro modelo
	 * @param modelo modelo do carro
	 */
	public void        setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	/**
	 * getTipo Retorna o tipo do carro
	 * @return tipo tipo do carro
	 */
	public TipoCarro   getTipo() {
		return tipo;
	}

	/**
	 * setTipo altera o valor da variavel tipo para enum TipoCarro que foi passado pelo parametro tipo
	 * @param tipo tipo do carro
	 */
	public void        setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	/**
	 * getMotorizacao retorna a motorizacao do carro
	 * @return motorizacao motorizacao do carro
	 */
	public float       getMotorizacao() {
		return motorizacao;
	}

	/**
	 * setMotorizacao altera o valor da variavel motorizacao para o float que foi passado pelo parametro motorizacao
	 * @param motorizacao motorizacao do carro
	 */
	public void        setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}

	/**
	 * getCambio retorna o cambio do carro
	 * @return cambio cambio do carro
	 */
	public Cambio      getCambio() {
		return cambio;
	}

	/**
	 * setCambio altera o valor da variavel cambio para enum Cambio que foi passado pelo parametro cambio
	 * @param cambio cambio do carro
	 */
	public void        setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	/**
	 * Metodo toString sobrepondo o original, formatando a String da forma desejada.
	 * @return String que representa o objeto.
	 */
	public String toString() {
		return "Chassi = " + chassi + " Montadora = " + montadora
				+ " Modelo = " + modelo + " Tipo = " + tipo + " Cor = " + cor
				+ " Motorizacao = " + motorizacao + " Cambio = " + cambio
				+ " Preco = " + preco + ".";
	}
}