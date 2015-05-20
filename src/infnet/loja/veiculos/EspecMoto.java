package infnet.loja.veiculos;

import javax.swing.JOptionPane;

import infnet.loja.enums.*;

/**
 * Classe EspecMoto possui as especificacoes de moto
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class EspecMoto extends EspecificacaoVeiculo {
	private ModeloMoto modelo;
	private TipoMoto tipo;
	private int cilindrada;
	private int capacidadeDoTanque;
	
	public EspecMoto()
	{
		this(addChassi(), addMontadora(), addModeloMoto(), addTipoMoto(), addCor(), addCilindrada(), addCapacidadeDoTanque(), addPreco()); 
	}

	public EspecMoto(String addChassi, Montadora addMontadora, ModeloMoto addModeloMoto, TipoMoto addTipoMoto, Cor addCor, 
			int addCilindrada, int addCapacidadeDoTanque, float addPreco) {
		chassi = addChassi;
		montadora = addMontadora;
		modelo = addModeloMoto;
		tipo = addTipoMoto;
		cor = addCor;
		cilindrada = addCilindrada;
		capacidadeDoTanque = addCapacidadeDoTanque;
		preco = addPreco;
	}

	/**
	 * metodo addModeloMoto retorna o modelo da moto inputado pelo usuario
	 * @return modelo modelo da moto
	 */
	public static  ModeloMoto addModeloMoto(){
		ModeloMoto modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - CBR\n2 - NINJA\n3 - CB_HORNET"));
		if (aux <= 0 || aux >= 4)
			modelo = null;
		else
		{
			for (ModeloMoto m: ModeloMoto.values())
			{
				if (m.getIndice() == (aux-1))
					modelo = m;
			}
		}
		return modelo;
	}

	/**
	 * metodo addTipoMoto retorna o tipo da moto inputado pelo usuario
	 * @return tipo tipo da moto
	 */
	public static TipoMoto addTipoMoto() {
		TipoMoto tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - CHOPPER\n2 - SCOOTER\n3 - ESPORTIVO"));
		if (aux <= 0 || aux >=4)
			tipo = null;
		else
		{
			for (TipoMoto m: TipoMoto.values())
			{
				if (m.getIndice() == (aux-1))
					tipo = m;
			}
		}
		return tipo;
	}

	/**
	 * metodo addCilindrada retorna as cilindradas da moto inputadas pelo usuario
	 * @return cilindrada cilindrada da moto
	 */
	public static int addCilindrada() {
		int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cilindradas:"));
		return cilindrada;
	}

	/**
	 * metodo addCapacidadeDoTanque retorna a capacidade do tanque da moto inputado pelo usuario
	 * @return capacidadeDoTanque capacidade do tanque da moto
	 */
	public static int addCapacidadeDoTanque() {
		int capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do Tanque:"));
		return capacidadeDoTanque;
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
	public void setModelo(ModeloMoto modelo) {
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
	public void setTipo(TipoMoto tipo) {
		this.tipo = tipo;
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
	public void setCilindrada(int cilindrada) {
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
	 * Metodo toString sobrepondo o original, formatando a String da forma desejada.
	 * @return String que representa o objeto.
	 */
	public String toString() {
		return   "Chassi = " + chassi 			    + " Montadora = " + montadora
				+ " Modelo = " + modelo 			+ " Tipo = "      + tipo 
				+ " Cor = "    + cor				+ " Cilindrada = " + cilindrada 
				+ " Tanque = " + capacidadeDoTanque + " Preco = " + preco + ".";
	}

	/**
	 * Metodo equals sobrescreve o equals da classe
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		EspecMoto other = (EspecMoto) obj;
		if ((!super.equals(obj))&&(capacidadeDoTanque != other.capacidadeDoTanque)&&(cilindrada != other.cilindrada)&&(modelo != other.modelo)&&(tipo != other.tipo))
			return false;
		return true;
	}
	
	
}
