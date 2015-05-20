package infnet.loja.veiculos;

import infnet.loja.enums.Cor;
import infnet.loja.enums.Modelo;
import infnet.loja.enums.Montadora;
import infnet.loja.enums.Tipo;

import javax.swing.JOptionPane;

/**
 * Classe EspecVeiculo possui as especificacoes de veiculo
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public abstract class EspecificacaoVeiculo {

	protected String chassi;
	protected Montadora montadora;
	protected Cor cor;
	protected float preco;
	
	//m�todos abstratos da classe pai
	public abstract Tipo addTipo();
	public abstract Modelo addModelo();
	
	/**
	 * metodo addChassi retorna o chassi do veiculo inputado pelo usuario
	 * @return chassi chassi do veiculo
	 */
	public static String addChassi() {
		String chassi = (JOptionPane.showInputDialog("Digite o chassi: "));
		if (chassi == null)
		{
			JOptionPane.showMessageDialog(null, "Valor em branco.");
			addChassi();
		}
		if (chassi.isEmpty() || chassi.equals("0"))
			chassi = null;
		return chassi;
	}

	/**
	 * metodo addMontadora retorna a montadora do veiculo inputado pelo usuario
	 * @return montadora montadora do veiculo
	 */
	public static Montadora addMontadora(){
		Montadora montadora = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora:\n1 - VOLKSWAGEN\n2 - FORD\n3 - CHEVROLET\n4 - FIAT\n5 - HONDA\n6 - SUZUKI\n7 - YAMAHA\n8 - KAWASAKI"));
		if (aux <= 0 || aux >= 9)
			montadora = null;
		else
		{
			for (Montadora m: Montadora.values())
			{
				if (m.getIndice() == aux)
					montadora = m;
			}
		}
		return montadora;
	}

	/**
	 * metodo addCor retorna a cor do veiculo inputado pelo usuario
	 * @return cor cor do veiculo
	 */
	public static Cor addCor() {
		Cor cor = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:\n1 - PRETO\n2 - BRANCO\n3 - AZUL\n4 - VERDE\n5 - ROSA\n6 - AMARELO"));
		if (aux <= 0 || aux >= 7)
			cor = null;
		else
		{
			for (Cor m: Cor.values())
			{
				if (m.getIndice() == (aux-1))
					cor = m;
			}
		}
		return cor;
	}

	/**
	 * metodo addPreco retorna o preco do veiculo inputado pelo usuario
	 * @return preco preco do carro
	 */
	public static float addPreco(){
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco:"));
		return preco;
	}
	
	/**
	 * Metodo equals sobrescreve o equals da classe
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EspecificacaoVeiculo other = (EspecificacaoVeiculo) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if ((!chassi.equals(other.chassi))&&(cor != other.cor)&&(montadora != other.montadora)&&(Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco)))
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