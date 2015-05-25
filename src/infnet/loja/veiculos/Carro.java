package infnet.loja.veiculos;

import java.io.IOException;

import infnet.loja.Loja;
import infnet.loja.enums.Cambio;
import infnet.loja.enums.Modelo;
import infnet.loja.enums.Tipo;

import javax.swing.JOptionPane;

/**
 * Classe Carro define um novo carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class Carro extends Veiculo 
{
	private Modelo modelo;
	private Tipo tipo; 
	private float motorizacao;
	private Cambio cambio;
	
	/**
	 * Construtor da especificacao de carro
	 * @throws IOException 
	 */
	public Carro(Loja loja) throws IOException {
		chassi = addChassi(loja);
		montadora = addMontadora();
		modelo = addModelo();
		tipo = addTipo();
		cor = addCor();
		motorizacao = addMotorizacao();
		cambio = addCambio();
		preco = addPreco();
		
	}
	/**
	 * metodo addModeloCarro retorna o modelo do carro inputado pelo usuario
	 * @return modelo modelo do carro
	 */
	public Modelo addModelo() {
		Modelo modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - FOX\n2 - GOL\n3 - CELTA"));
		if (aux <= 0 || aux >=4)
			modelo = null;
		else
		{
			for (Modelo m: Modelo.values())
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
	public Tipo addTipo() {
		Tipo tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - SEDAN\n2 - HATCH\n3 - SUV"));
		if (aux <= 0 || aux >=4)
			tipo = null;
		else
		{
			for (Tipo m: Tipo.values())
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
	public  Modelo getModelo() {
		return modelo;
	}
	/**
	 * setModelo altera o valor da variavel modelo para enum ModeloCarro que foi passado pelo parametro modelo
	 * @param modelo modelo do carro
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * getTipo Retorna o tipo do carro
	 * @return tipo tipo do carro
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * setTipo altera o valor da variavel tipo para enum TipoCarro que foi passado pelo parametro tipo
	 * @param tipo tipo do carro
	 */
	public void setTipo(Tipo tipo) {
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
	 * Metodo equals sobrescreve o equals da classe
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if ((!super.equals(obj))&&(cambio != other.cambio)&&(modelo != other.modelo)&&(Float.floatToIntBits(motorizacao) != Float
				.floatToIntBits(other.motorizacao))&&(tipo != other.tipo))
			return false;
		return true;
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