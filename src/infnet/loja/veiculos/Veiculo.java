package infnet.loja.veiculos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import infnet.loja.Loja;
import infnet.loja.enums.Cambio;
import infnet.loja.enums.Cor;
import infnet.loja.enums.Modelo;
import infnet.loja.enums.Montadora;
import infnet.loja.enums.Tipo;

/**
 * Classe Veiculo eh a classe pai de carro e motocicleta
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class Veiculo {
	private Modelo modelo;
	private Tipo tipo;
	private String chassi;
	private Montadora montadora;
	private Cor cor;
	private float preco;
	//Inteiro 1 quando carro, 2 quando moto
	public static Map<Veiculo, Integer> map = new HashMap<Veiculo, Integer>();

	//variaveis especificas de carro
	private float motorizacao;
	private Cambio cambio;

	//variaveis especificas de moto
	private int cilindrada;
	private int capacidadeDoTanque;

	/**
	 * Construtor Default de Veiculo
	 */
	public Veiculo (){}
	
	/**
	 * Construtor de Veiculo
	 * @param loja loja onde o veiculo sera cadastrado
	 * @throws IOException para tratamento de excecao
	 */
	public Veiculo(Loja loja) throws IOException {
		this.chassi = addChassi(loja);
		this.montadora = addMontadora();
		this.modelo = addModelo();
		this.tipo = addTipo();
		this.cor = addCor();
		this.preco = addPreco();
		if (Loja.indiceVeiculo == 1)
		{
			this.motorizacao = addMotorizacao();
			this.cambio = addCambio();
		}
		else
		{
			this.cilindrada = addCilindrada();
			this.capacidadeDoTanque = addCapacidadeDoTanque();
		}
	}
	
	/**
	 * metodo addModelo retorna o modelo do veiculo inputado pelo usuario
	 * @return modelo modelo do veiculo
	 */
	public Modelo addModelo() {
		Modelo modelo = null;
		//caso carro
		if (Loja.indiceVeiculo == 1)
		{
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
		}
		//caso moto
		else{
			int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - CBR\n2 - NINJA\n3 - CB_HORNET"));
			if (aux <= 0 || aux >= 4)
				modelo = null;
			else
			{
				for (Modelo m: Modelo.values())
				{
					if (m.getIndice() == (aux+2))
						modelo = m;
				}
			}
		}
		return modelo;

	}

	/**
	 * metodo addTipo retorna o tipo do veiculo inputado pelo usuario
	 * @return tipo tipo do veiculo
	 */
	public Tipo addTipo() {
		Tipo tipo = null;
		if (Loja.indiceVeiculo == 1)
		{
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
		}
		else
		{
			int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - CHOPPER\n2 - SCOOTER\n3 - ESPORTIVO"));
			if (aux <= 0 || aux >=4)
				tipo = null;
			else
			{
				for (Tipo m: Tipo.values())
				{
					if (m.getIndice() == (aux+2))
						tipo = m;
				}
			}
		}
		return tipo;
	}

	/**
	 * metodo addChassi retorna o chassi do veiculo inputado pelo usuario
	 * @return chassi chassi do veiculo
	 * @throws IOException tratamento de excecao
	 * @param loja loja
	 */
	public static String addChassi(Loja loja) throws IOException {
		String chassi = (JOptionPane.showInputDialog("Digite o chassi: "));
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
	//carro
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

	//moto
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
	 * getModelo Retorna o modelo do veiculo
	 * @return modelo modelo do veiculo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * setModelo altera o valor da variavel modelo para enum Modelo que foi passado pelo parametro modelo
	 * @param modelo modelo do veiculo
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * getTipo Retorna o tipo do veiculo
	 * @return tipo tipo do veiculo
	 */
	public Tipo   getTipo() {
		return tipo;
	}

	/**
	 * setTipo altera o valor da variavel tipo para enum Tipo que foi passado pelo parametro tipo
	 * @param tipo tipo do veiculo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
	 * getMap retorna o mapa
	 * @return map mapa com os valores
	 */
	public Map<Veiculo, Integer> getMap() {
		return map;
	}
	
	/**
	 * setMap altera os valores do mapa do veiculo
	 * @param map mapa a ser alterado
	 */
	public void setMap(Map<Veiculo, Integer> map) {
		Veiculo.map = map;
	}

	/**
	 * Metodo equals sobrescreve o equals de objeto
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} 
		else 
		{
			//caso carro
			if ((Loja.indiceVeiculo == 1)&&(!chassi.equals(other.chassi))&&(cor != other.cor)&&(montadora != other.montadora)&&(Float.floatToIntBits(preco) 
					!= Float.floatToIntBits(other.preco))&&(cambio != other.cambio)&&(modelo != other.modelo)&&(Float.floatToIntBits(motorizacao) != Float.floatToIntBits(other.motorizacao))&&(tipo != other.tipo))
			{
				System.out.println("true");
				return false;
			}
			//caso moto
			if ((Loja.indiceVeiculo == 2)&&(!chassi.equals(other.chassi))&&(cor != other.cor)&&(montadora != other.montadora)&&(Float.floatToIntBits(preco) 
					!= Float.floatToIntBits(other.preco))&&(capacidadeDoTanque != other.capacidadeDoTanque)&&(cilindrada != other.cilindrada)&&(modelo != other.modelo)&&(tipo != other.tipo))
				return false;
		}
		return true;
	}

	/**
	 * Substitui o metodo toString do objeto
	 */
	@Override
	public String toString() {
		//caso carro
		if (Loja.indiceVeiculo == 1)
		{
			return "Carro - Chassi = " + chassi + " Montadora = " + montadora
					+ " Modelo = " + modelo + " Tipo = " + tipo + " Cor = " + cor
					+ " Motorizacao = " + motorizacao + " Cambio = " + cambio
					+ " Preco = " + preco + ".";
		}
		//caso moto
		else
		{
			return   "Moto - Chassi = " + chassi 			    + " Montadora = " + montadora
					+ " Modelo = " + modelo 			+ " Tipo = "      + tipo 
					+ " Cor = "    + cor				+ " Cilindrada = " + cilindrada 
					+ " Tanque = " + capacidadeDoTanque + " Preco = " + preco + ".";
		}
	}
}
