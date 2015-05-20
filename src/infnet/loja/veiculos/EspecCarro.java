package infnet.loja.veiculos;

import infnet.loja.enums.*;

import javax.swing.JOptionPane;

/**
 * Classe EspecCarro possui as especificacoes de carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class EspecCarro extends EspecificacaoVeiculo{
	private ModeloCarro modelo;
	private TipoCarro tipo; 
	private float motorizacao;
	private Cambio cambio;
	
	public EspecCarro()
	{
		this(addChassi(), addMontadora(), addModeloCarro(), addTipoCarro(), addCor(), addMotorizacao(), addCambio(), addPreco());
	}
	
	public EspecCarro(String addChassi, Montadora addMontadora, ModeloCarro addModeloCarro, TipoCarro addTipoCarro, Cor addCor, float addMotorizacao, Cambio addCambio, float addPreco) {
		chassi = addChassi;
		montadora = addMontadora;
		modelo = addModeloCarro;
		tipo = addTipoCarro;
		cor = addCor;
		motorizacao = addMotorizacao;
		cambio = addCambio;
		preco = addPreco;
		
	}
	/**
	 * metodo addModeloCarro retorna o modelo do carro inputado pelo usuario
	 * @return modelo modelo do carro
	 */
	public static ModeloCarro addModeloCarro() {
		ModeloCarro modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - FOX\n2 - GOL\n3 - CELTA"));
		if (aux <= 0 || aux >=4)
			modelo = null;
		else
		{
			for (ModeloCarro m: ModeloCarro.values())
			{
				if (m.getIndice() == (aux-1))
					modelo = m;
			}
		}
		return modelo;
	}

	/**
	 * metodo addTipoCarro retorna o tipo de carro inputado pelo usuario
	 * @return tipo tipo do carro
	 */
	public static TipoCarro addTipoCarro() {
		TipoCarro tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - SEDAN\n2 - HATCH\n3 - SUV"));
		if (aux <= 0 || aux >=4)
			tipo = null;
		else
		{
			for (TipoCarro m: TipoCarro.values())
			{
				if (m.getIndice() == (aux-1))
					tipo = m;
			}
		}
		return tipo;
	}

	/**
	 * metodo addMotorizacao retorna a motorizacao do carro inputado pelo usuario
	 * @return motorizacao motorizacao do carro
	 */
	public static float addMotorizacao(){
		float motorizacao = Float.parseFloat(JOptionPane.showInputDialog("Digite numero do motor:"));
		return motorizacao;
	}

	/**
	 * metodo addCambio retorna o cambio do carro inputado pelo usuario
	 * @return cambio cambio do carro
	 */
	public static Cambio addCambio() {
		Cambio cambio = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:\n1 - MANUAL\n2 - SEMI\n3 - AUTO"));
		if (aux <= 0 || aux >=4)
			cambio = null;
		else
		{
			for (Cambio m: Cambio.values())
			{
				if (m.getIndice() == (aux-1))
					cambio = m;
			}
		}
		return cambio;
	}
	/**
	 * getModelo Retorna o modelo do carro
	 * @return modelo modelo do carro
	 */
	public  ModeloCarro getModelo() {
		return modelo;
	}
	/**
	 * setModelo altera o valor da variavel modelo para enum ModeloCarro que foi passado pelo parametro modelo
	 * @param modelo modelo do carro
	 */
	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	/**
	 * getTipo Retorna o tipo do carro
	 * @return tipo tipo do carro
	 */
	public TipoCarro getTipo() {
		return tipo;
	}

	/**
	 * setTipo altera o valor da variavel tipo para enum TipoCarro que foi passado pelo parametro tipo
	 * @param tipo tipo do carro
	 */
	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	/**
	 * getMotorizacao retorna a motorizacao do carro
	 * @return motorizacao motorizacao do carro
	 */
	public float getMotorizacao() {
		return motorizacao;
	}

	/**
	 * setMotorizacao altera o valor da variavel motorizacao para o float que foi passado pelo parametro motorizacao
	 * @param motorizacao motorizacao do carro
	 */
	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}

	/**
	 * getCambio retorna o cambio do carro
	 * @return cambio cambio do carro
	 */
	public Cambio getCambio() {
		return cambio;
	}

	/**
	 * setCambio altera o valor da variavel cambio para enum Cambio que foi passado pelo parametro cambio
	 * @param cambio cambio do carro
	 */
	public void setCambio(Cambio cambio) {
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
	/**
	 * Metodo equals sobrescreve o equals da classe
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		EspecCarro other = (EspecCarro) obj;
		if ((!super.equals(obj))&&(cambio != other.cambio)&&(modelo != other.modelo)&&(Float.floatToIntBits(motorizacao) != Float
				.floatToIntBits(other.motorizacao))&&(tipo != other.tipo))
			return false;
		return true;
	}
	
}
