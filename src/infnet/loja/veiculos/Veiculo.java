package infnet.loja.veiculos;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import infnet.Menu;
import infnet.loja.enums.*;

/**
 * Classe Veiculo, que pode ser tanto carro quanto moto
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 08-06-2015
 */
@SuppressWarnings("rawtypes")
public class Veiculo {
	private String chassi;
	private float preco;
	public HashMap<String, Enum> map;
	private int cilindrada; 
	private float capacidadeDoTanque; //ate 20l

	/**
	 * Construtor de Veiculo
	 * @throws IOException tratamento de excecao
	 */
	public Veiculo() throws IOException {
		try{
			map = new HashMap <String, Enum>();
			map.put("TipoVeiculo", addTipoVeiculo());
			this.chassi = addChassi();
			map.put("Montadora", addMontadora());
			map.put ("Modelo", addModelo());
			map.put("Tipo", addTipo());
			map.put ("Cor", addCor());
			this.preco = addPreco();
			if (map.containsValue(TipoVeiculo.CARRO)){
				map.put("Motorizacao", addMotorizacao());
				map.put("Cambio", addCambio());
			}
			else{
				this.cilindrada = addCilindrada();
				this.capacidadeDoTanque = addCapacidadeDoTanque();
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Operacao cancelada, voltando para o Menu Principal");
			Menu.chamarMenu();
		}
	}
	/**
	 * Metodo que permite a escolha entre opcoes de carro e de moto
	 * @return veiculo tipo do veiculo
	 */
	public TipoVeiculo addTipoVeiculo(){
		TipoVeiculo veiculo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do veiculo:\n1 - Carro\n2 - Moto"));
		if (aux <= 0 || aux >= 3)
			veiculo = null;
		else{
			for (TipoVeiculo t: TipoVeiculo.values()){
				if (t.getIndice() == aux-1)
					veiculo = t;
			}
		}
		return veiculo;
	}

	/**
	 * metodo addModelo retorna o modelo do veiculo inputado pelo usuario
	 * @return modelo modelo do veiculo
	 */
	public Modelo addModelo() {
		Modelo modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - Carro FOX / Moto CBR\n2 - Carro GOL / Moto NINJA\n3 - Carro CELTA / Moto CB_HORNET"));
		if (aux <= 0 || aux >=4)
			return modelo;
		if (map.containsValue(TipoVeiculo.MOTOCICLETA))
			aux = aux+3;
		for (Modelo m: Modelo.values()){
			if (m.getIndice() == (aux-1))
				modelo = m;
		}
		return modelo;
	}

	/**
	 * metodo addTipo retorna o tipo do veiculo inputado pelo usuario
	 * @return tipo tipo do veiculo
	 */
	public Tipo addTipo() {
		Tipo tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - Carro SEDAN / Moto CHOPPER\n2 - Carro HATCH / Moto SCOOTER\n3 - Carro SUV / Moto ESPORTIVO"));
		if (aux <= 0 || aux >=4)
			return tipo;
		if (map.containsValue(TipoVeiculo.MOTOCICLETA))
			aux = aux+3;
		for (Tipo m: Tipo.values()){
			if (m.getIndice() == (aux-1))
				tipo = m;
		}
		return tipo;
	}

	/**
	 * metodo addChassi retorna o chassi do veiculo inputado pelo usuario
	 * @return chassi chassi do veiculo
	 */
	public String addChassi() {
		String chassi = (JOptionPane.showInputDialog("Digite o chassi: "));
		if (chassi.isEmpty() || chassi.equals("0"))
			chassi = null;
		return chassi;
	}

	/**
	 * metodo addMontadora retorna a montadora do veiculo inputado pelo usuario
	 * @return montadora montadora do veiculo
	 */
	public Montadora addMontadora(){
		Montadora montadora = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora:\n1 - Carro VOLKSWAGEN / Moto HONDA\n2 - Carro FORD / Moto SUZUKI\n3 - Carro CHEVROLET / Moto YAMAHA\n4 - Carro FIAT / Moto KAWASAKI"));
		if (aux <= 0 || aux >= 5)
			return montadora;
		if (map.containsValue(TipoVeiculo.MOTOCICLETA))
			aux = aux + 4;
		for (Montadora m: Montadora.values()){
			if (m.getIndice() == aux)
				montadora = m;
		}
		return montadora;
	}

	/**
	 * metodo addCor retorna a cor do veiculo inputado pelo usuario
	 * @return cor cor do veiculo
	 */
	public Cor addCor() {
		Cor cor = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:\n1 - PRETO\n2 - BRANCO\n3 - AZUL\n4 - VERDE\n5 - ROSA\n6 - AMARELO"));
		if (aux <= 0 || aux >= 7)
			cor = null;
		else{
			for (Cor m: Cor.values()){
				if (m.getIndice() == (aux-1))
					cor = m;
			}
		}
		return cor;
	}

	/**
	 * metodo addPreco retorna o preco do veiculo inputado pelo usuario
	 * @return preco preco do veiculo
	 */
	public float addPreco(){
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco:"));
		return preco;
	}

	/**
	 * metodo addMotorizacao retorna a motorizacao do carro inputado pelo usuario
	 * @return motorizacao motorizacao do carro
	 */
	public Motorizacao addMotorizacao(){
		Motorizacao motorizacao = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da motorizacao:\n1 - 1.0\n2 - 1.3\n3 - 1.4\n4 - 1.5\n5 - 1.6\n6 - 1.8\n7 - 2.0"));
		if (aux <= 0 || aux >= 9)
			motorizacao = null;
		else{
			for (Motorizacao m: Motorizacao.values()){
				if (m.getIndice() == (aux-1))
					motorizacao = m;
			}
		}
		return motorizacao;
	}

	/**
	 * metodo addCambio retorna o cambio do carro inputado pelo usuario
	 * @return cambio cambio do carro
	 */
	public Cambio addCambio() {
		Cambio cambio = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:\n1 - MANUAL\n2 - SEMI\n3 - AUTO"));
		if (aux <= 0 || aux >=4)
			cambio = null;
		else{
			for (Cambio m: Cambio.values()){
				if (m.getIndice() == (aux-1))
					cambio = m;
			}
		}
		return cambio;
	}

	/**
	 * metodo addCilindrada retorna as cilindradas da moto inputadas pelo usuario
	 * @return cilindrada cilindrada da moto
	 */
	public int addCilindrada() {
		int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de cilindradas:"));
		while ((cilindrada < 0 || cilindrada > 1000))
			cilindrada = Integer.parseInt(JOptionPane.showInputDialog("ERRO:Cilindradas soh adotam valores entre 0 e 1000.\nDigite o numero de cilindradas:"));
		return cilindrada;
	}

	/**
	 * metodo addCapacidadeDoTanque retorna a capacidade do tanque da moto inputado pelo usuario
	 * @return capacidadeDoTanque capacidade do tanque da moto
	 */
	public float addCapacidadeDoTanque() {
		float capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do Tanque:"));
		while (capacidadeDoTanque < 0 || capacidadeDoTanque > 20)
			capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("A capacidade do tanque soh aceita valores entre 0 e 20 litros.\nDigite a capacidade do Tanque:"));
		return capacidadeDoTanque;
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
	 * setCapacidadeDoTanque altera o valor da variavel capacidadeDoTanque para o inteiro que foi passado pelo parametro capacidadeDoTanque
	 * @param capacidadeDoTanque capacidade do tanque da moto
	 */
	public void       setCapacidadeDoTanque(float capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}

	/**
	 * getCapacidadeDoTanque retorna a capacidade do tanque da moto
	 * @return capacidadeDoTanque capacidade do tanque da moto
	 */
	public float getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}

	/**
	 * getMap retorna o mapa do veiculo
	 * @return map mapa do veiculo
	 */
	public HashMap<String, Enum> getMap() {
		return map;
	}

	/**
	 * setMap altera o mapa do veiculo
	 * @param map mapa do veiculo
	 */
	public void setMap(HashMap<String, Enum> map) {
		this.map = map;
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
		if ((!this.getChassi().equals(other.getChassi()))&&(this.map.get("TipoVeiculo") != other.map.get("TipoVeiculo"))&&(this.map.get("Cor") != other.map.get("Cor"))&&
				(this.map.get("Montadora") != other.map.get("Montadora"))&&(Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco))&&
				(this.map.get("Modelo") != other.map.get("Modelo"))&&(this.map.get("Tipo") != other.map.get("Tipo"))){
			return false;
		}
		return true;
	}

	/**
	 * Substitui o metodo toString do objeto
	 */
	@Override
	public String toString() {
		if (map.containsValue(TipoVeiculo.CARRO)){
			return "Carro - Chassi = " + chassi + " Montadora = " + map.get("Montadora")
					+ " Modelo = " + map.get("Modelo") + " Tipo = " + map.get("Tipo") + " Cor = " + map.get("Cor")
					+ " Motorizacao = " + map.get("Motorizacao") + " Cambio = " + map.get("Cambio")
					+ " Preco = " + preco + ".";
		}
		else{
			return   "Moto - Chassi = " + chassi 			    + " Montadora = " + map.get("Montadora")
					+ " Modelo = " + map.get("Modelo") 			+ " Tipo = "      + map.get("Tipo") 
					+ " Cor = "    + map.get("Cor")				+ " Cilindrada = " + cilindrada 
					+ " Tanque = " + capacidadeDoTanque + " Preco = " + preco + ".";
		}
	}
}