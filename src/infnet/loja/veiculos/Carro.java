package infnet.loja.veiculos;

import infnet.loja.enums.*;

/**
 * Classe Carro define um novo carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 1.0
 * @since 15-04-2015
 */
public class Carro 
{
	//VARIAVEIS DA CLASSE
	private String chassi;
	private Montadora montadora;
	private ModeloCarro modelo;
	private TipoCarro tipo; 
	private Cor cor;
	private float motorizacao;
	private Cambio cambio;
	private float preco;

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
		this.chassi      = chassi;
		this.montadora   = montadora;	
		this.modelo      = modelo;
		this.tipo        = tipo;
		this.cor         = cor;
		this.motorizacao = motorizacao;
		this.cambio      = cambio;
		this.preco       = preco;
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
	 *getChassi Retorna o chassi do carro
	 * @return chassi chassi do carro
	 */
	public String      getChassi() {
		return chassi;
	}
	
	/**
	 * setChassi altera o valor da variavel chassi para String que foi passado pelo parametro chassi
	 * @param chassi chassi do carro
	 */
	public void        setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	/**
	 * getMontadora Retorna a montadora do carro
	 * @return montadora montadora do carro
	 */
	public Montadora   getMontadora() {
		return montadora;
	}
	
	/**
	 * setMontadora altera o valor da variavel montadora para enum Montadora que foi passado pelo parametro montadora
	 * @param montadora montadora do carro
	 */
	public void        setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	
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
	 * getCor retorna a cor do carro
	 * @return cor cor do carro
	 */
	public Cor         getCor() {
		return cor;
	}
	
	/**
	 * setCor altera o valor da variavel cor para enum Cor que foi passado pelo parametro cor
	 * @param cor cor do carro
	 */
	public void        setCor(Cor cor) {
		this.cor = cor;
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
	 * getPreco retorna o preco do carro
	 * @return preco preco do carro
	 */
	public float       getPreco() {
		return preco;
	}
	
	/**
	 * setPreco altera o valor da variavel preco para o float que foi passado pelo parametro preco
	 * @param preco preco do carro
	 */
	public void        setPreco(float preco) {
		this.preco = preco;
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
