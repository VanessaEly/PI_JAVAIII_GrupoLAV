package infnet.loja.veiculos;

import infnet.loja.enums.*;

/**
 * Classe Motocicleta define uma nova Motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 1.0
 * @since 15-04-2015
 */
public class Motocicleta 
{
	//VARIAVEIS DA CLASSE
	private String chassi;
	private Montadora montadora;
	private ModeloMoto modelo;
	private TipoMoto tipo;
	private Cor cor;
	private int cilindrada;
	private int capacidadeDoTanque; 
	private float preco;
	
	/**
	 * Construtor Motocicleta constroi uma nova motocicleta
	 * @param chassi chassi da motocicleta
	 * @param montadora montadora da motocicleta
	 * @param modelo modelo da motocicleta
	 * @param tipo tipo da motocicleta
	 * @param cor cor da motocicleta
	 * @param cilindrada cilindradas da motocicleta
	 * @param capacidadeDoTanque capacidade do tanque da motocicleta
	 * @param preco preco da motocicleta
	 */
	public Motocicleta(String chassi, Montadora montadora, ModeloMoto modelo, TipoMoto tipo, Cor cor, 
		           int cilindrada, int capacidadeDoTanque, float preco) 
	{
		this.chassi      	= chassi;
		this.montadora   	= montadora;	
		this.modelo     	= modelo;
		this.tipo        	= tipo;
		this.cor                = cor;
		this.cilindrada         = cilindrada;
		this.capacidadeDoTanque = capacidadeDoTanque;
		this.preco              = preco;
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
		Motocicleta other = (Motocicleta) obj;
		if (capacidadeDoTanque != other.capacidadeDoTanque)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (cilindrada != other.cilindrada)
			return false;
		if (cor != other.cor)
			return false;
		if (modelo != other.modelo)
			return false;
		if (montadora != other.montadora)
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
//-------------------------GETTERS AND SETTERS------------------------------------------------------------------------
	/**
	 *getChassi Retorna o chassi da moto
	 * @return chassi chassi da moto
	 */
	public String     getChassi() {
		return chassi;
	}
	
	/**
	 * setChassi altera o valor da variavel chassi para String que foi passado pelo parametro chassi
	 * @param chassi chassi da moto
	 */
	public void       setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	/**
	 * getMontadora Retorna a montadora da moto
	 * @return montadora montadora da moto
	 */
	public Montadora  getMontadora() {
		return montadora;
	}
	
	/**
	 * setMontadora altera o valor da variavel montadora para enum Montadora que foi passado pelo parametro montadora
	 * @param montadora montadora da moto
	 */
	public void       setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	
	/**
	 * getModelo Retorna o modelo da moto
	 * @return modelo modelo da moto
	 */
	public ModeloMoto getModelo() {
		return modelo;
	}
	
	/**
	 * setModelo altera o valor da variavel modelo para enum ModeloCarro que foi passado pelo parametro modelo
	 * @param modelo modelo da moto
	 */
	public void       setModelo(ModeloMoto modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * getTipo Retorna o tipo da moto
	 * @return tipo tipo da moto
	 */
	public TipoMoto   getTipo() {
		return tipo;
	}
	
	/**
	 * setTipo altera o valor da variavel tipo para enum TipoCarro que foi passado pelo parametro tipo
	 * @param tipo tipo da moto
	 */
	public void       setTipo(TipoMoto tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * getCor retorna a cor da moto
	 * @return cor cor da moto
	 */
	public Cor        getCor() {
		return cor;
	}
	
	/**
	 * setCor altera o valor da variavel cor para enum Cor que foi passado pelo parametro cor
	 * @param cor cor da moto
	 */
	public void       setCor(Cor cor) {
		this.cor = cor;
	}
	
	/**
	 * getCilindrada retorna as cilindradas da moto
	 * @return cilindrada cilindradas da moto
	 */
	public int        getCilindrada() {
		return cilindrada;
	}
	
	/**
	 * setCilindrada altera o valor da variavel cilindrada para o float que foi passado pelo parametro cilindrada
	 * @param cilindrada cilindradas da moto
	 */
	public void       setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	/**
	 * getCapacidadeDoTanque retorna a capacidade do tanque da moto
	 * @return capacidadeDoTanque capacidade do tanque da moto
	 */
	public int        getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}
	
	/**
	 * setCapacidadeDoTanque altera o valor da variavel capacidadeDoTanque para o inteiro que foi passado pelo parametro capacidadeDoTanque
	 * @param capacidadeDoTanque capacidade do tanque da moto
	 */
	public void       setCapacidadeDoTanque(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
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
	
	/**
	 * Metodo toString sobrepondo o original, formatando a String da forma desejada.
	 * @return String que representa o objeto.
	 */
	public String toString() {
		return   "Chassi = " + chassi 			    + " Montadora = " + montadora
				+ " Modelo = " + modelo 			+ " Tipo = "      + tipo 
				+ " Cor = "    + cor				+ " Cilindrada = " + cilindrada 
				+ " Tanque = " + capacidadeDoTanque + " Preco = " + preco + ".";
	}
}
