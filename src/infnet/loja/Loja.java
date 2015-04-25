package infnet.loja;

import infnet.Menu;
import infnet.Principal;
import infnet.loja.veiculos.*;
import infnet.loja.enums.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Classe Loja define uma loja e faz a manutencao de seu "estoque"
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 1.0
 * @since 15-04-2015
 */
public class Loja 
{

	//VARIAVEIS DA CLASSE
	private String endereco;
	private String nome;
	private ArrayList <Carro>	estoqueDeCarros       = new ArrayList <Carro>();
	private ArrayList <Motocicleta>  estoqueDeMotocicletas = new ArrayList <Motocicleta>();
	private static PrintWriter gravarArq;

	/**
	 * Construtor Default
	 * Cria uma loja sem valores definidos
	 */
	public Loja() {}

	/**
	 * Construtor Loja constroi uma nova loja
	 * @param nome nome da loja
	 * @param endereco endereco da loja
	 */
	public Loja(String nome, String endereco) 
	{
		this.endereco              = endereco;
		this.nome                  = nome;
	}

	/**
	 * Cria uma nova loja e um novo arquivo para a mesma (caso ele ainda nao exista)
	 * @return loja retorna a loja criada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static Loja criarLoja() throws IOException {
		Loja loja = new Loja();
		Principal.nomearq = (JOptionPane.showInputDialog("Digite o nome e formato do arquivo (Ex: 'loja.txt'): "));
		File arq = new File(Principal.nomearq);

		if (!arq.exists()) 
		{
			arq.createNewFile();
			new Loja("Loja Infnet", "Rua Sao Jose n90");
		}
		return loja;
	}

	/**
	 * Adiciona um novo carro com os atributos imputados pelo usuario
	 * @param loja loja cujo estoque recebera o carro 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarCarro(Loja loja) throws IOException
	{
		//variaveis nescessarias para a construcao de um novo Carro
		Montadora   _montadora   = null;
		ModeloCarro _modelo      = null;
		TipoCarro   _tipo 	     = null;
		Cambio 		_cambio      = null;
		Cor 		_cor 	     = null;
		float 		_motorizacao = 0; 
		String 		_chassi      = "";
		float 		_preco 		 = 0;
		int aux;

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))"));
		while (aux <= 0 || aux >=5) //tratamento de excecao limitando o indice que pode ser escolhido, utilizado sempre que tratar-se de uma enumeracao
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da montadora: \n (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))"));
		}
		for (Montadora m: Montadora.values()) //percorre a enumeracao
		{
			if (m.getIndice() == aux) //verifica qual valor da enumeracao possui o índice escolhido
				_montadora = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))"));
		}
		for (ModeloCarro m: ModeloCarro.values())
		{
			if (m.getIndice() == aux)
				_modelo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))"));
		}
		for (TipoCarro m: TipoCarro.values())
		{
			if (m.getIndice() == aux)
				_tipo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))"));
		}
		for (Cambio m: Cambio.values())
		{
			if (m.getIndice() == aux)
				_cambio = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		while (aux <= 0 || aux >=7)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == aux)
				_cor = m;
		}

		_motorizacao = Float.parseFloat(JOptionPane.showInputDialog("Digite numero do motor:		(1.0/1.4/1.6/1.8/2.0)"));

		_chassi = (JOptionPane.showInputDialog("Digite o chassi: "));

		_preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do carro"));

		//chamando o metodo construtor e colocando o carro criado no array de carros da loja
		Carro carroaux = new Carro(_chassi, _montadora, _modelo, _tipo, _cor, _motorizacao, _cambio, _preco);
		loja.estoqueDeCarros.add(carroaux);

		//-----------------ESCREVENDO NO ARQUIVO-------------------------------------------------------------------//
		try
		{
			gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true)))); //true garante que a escrita nao sobrescreva o conteudo atual
			gravarArq.printf("\nCarro %s", carroaux); //dados que serao escritos
			gravarArq.println();
			gravarArq.flush(); //limpa buffer
		} 
		finally 
		{
			if (gravarArq != null) 
			{
				gravarArq.close();
			} 
		}
		JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso.");
		Menu.chamarMenu(loja);
	}
	
	/**
	 * Adiciona uma nova moto com os atributos imputados pelo usuario
	 * @param loja loja cujo estoque recebera a moto 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarMoto(Loja loja) 
			throws IOException
	{
		Montadora   _montadora          = null;
		ModeloMoto  _modelo             = null;
		TipoMoto    _tipo 	    	    = null;
		int 		_capacidadeDoTanque = 0;
		Cor 		_cor 	            = null;
		int 		_cilindradas 		= 0; 
		String 		_chassi      		= "";
		float 		_preco 		 		= 0;
		int aux;

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))"));
		while (aux <= 4 || aux >=9)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))"));
		}
		for (Montadora m: Montadora.values())
		{
			if (m.getIndice() == aux)
				_montadora = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))"));
		}
		for (ModeloMoto m: ModeloMoto.values())
		{
			if (m.getIndice() == aux)
				_modelo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))"));
		}
		for (TipoMoto m: TipoMoto.values())
		{
			if (m.getIndice() == aux)
				_tipo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		while (aux <= 0 || aux >=6)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == aux)
				_cor = m;
		}

		_cilindradas = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cilindradas:	(50cc, 60cc, 100cc, 120cc, 150cc)"));	
		_capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do Tanque:"));
		_chassi = (JOptionPane.showInputDialog("Digite o chassi:"));
		_preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco da moto:"));

		Motocicleta motoaux = new Motocicleta (_chassi, _montadora, _modelo, _tipo, _cor, _cilindradas, _capacidadeDoTanque, _preco);
		loja.estoqueDeMotocicletas.add(motoaux);

		//-----------------ESCREVENDO NO ARQUIVO-------------------------------------------------------------------//
		try
		{
			gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true))));
			gravarArq.printf("Moto %s", motoaux);
			gravarArq.println();
			gravarArq.flush();
		} 
		finally 
		{
			if (gravarArq != null) 
			{
				gravarArq.close();
			} 
		}

		JOptionPane.showMessageDialog(null,"Moto Cadastrada com Sucesso");
		Menu.chamarMenu(loja);
	}

	/**
	 * Metodo listarEstoqueDeCarros exibe todos os carros que foram adicionados ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeCarros (Loja loja){

		// Criacao de Buffer para receber os valores do Array A
		StringBuilder carrosA = new StringBuilder();
		int i = 1;

		for (Carro c: loja.estoqueDeCarros)
		{
			carrosA.append(" - " + c + "\n");
			i++;
		}
		JOptionPane.showMessageDialog(null,"Lista de Carros: \n" + carrosA.toString());
	}

	/**
	 * Metodo listarEstoqueDeMotocicletas exibe todas as motocicletas que foram adicionadas ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeMotocicletas (Loja loja){
		// Criacao de Buffer para receber os valores do Array A
		StringBuilder motosA = new StringBuilder();
		int i = 1;

		for (Motocicleta m: loja.estoqueDeMotocicletas)
		{
			motosA.append(" - " + m + "\n");
			i++;
		}
		JOptionPane.showMessageDialog(null,"Lista de Motos: \n" + motosA.toString());
	}

	/**
	 * Metodo removerCarro remove o carro desejado da array estoqueDeCarros
	 * @param car carro a ser removido
	 */
	public void removerCarro(Carro car)
	{
		estoqueDeCarros.remove(car);
	}

	/**
	 * Metodo removerMotocicleta remove a motocicleta desejada da array estoqueDeMotocicletas
	 * @param moto motocicleta a ser removida
	 */
	public void removerMotocicleta(Motocicleta moto)	
	{
		estoqueDeMotocicletas.remove(moto);
	}

	//------------To Do--------------------------------------------------------------------------------------------

	//pesquisarCarro(...);  Retorna um carro, utilizando os atributos passados, caso exista no inventÃ¡rio. 
	//buscarCarro(Chassi); Retorna um carro, caso exista no estoque um com o Chassi indicado. 
	//pesquisarMoto(...); Retorna um carro, utilizando os atributos passados, caso exista no inventÃ¡rio. 
	//buscarMoto(Chassi); Retorna uma moto, caso exista no estoque uma com o Chassi indicado. 

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
		Loja other = (Loja) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estoqueDeCarros == null) {
			if (other.estoqueDeCarros != null)
				return false;
		} else if (!estoqueDeCarros.equals(other.estoqueDeCarros))
			return false;
		if (estoqueDeMotocicletas == null) {
			if (other.estoqueDeMotocicletas != null)
				return false;
		} else if (!estoqueDeMotocicletas.equals(other.estoqueDeMotocicletas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	//GETTERS
	/**
	 * getNome Retorna o nome da Loja
	 * @return nome nome da loja
	 */
	public String                 getNome() {
		return nome;
	}
	/**
	 * getEndereco Retorna o endereco da loja
	 * @return endereco endereco da loja
	 */
	public String                 getEndereco() {
		return endereco;
	}
	/**
	 * getEstoqueDeCarros retorna o ArrayList do estoque de carros da loja
	 * @return estoqueDeCarros estoque de carros da loja
	 */
	public ArrayList<Carro>       getEstoqueDeCarros() {
		return estoqueDeCarros;
	}

	/**
	 * getEstoqueDeMotocicletas retorna o ArrayList do estoque de motocicletas da loja
	 * @return estoqueDeMotocicletas estoque de motocicletas da loja
	 */
	public ArrayList<Motocicleta> getEstoqueDeMotocicletas() {
		return estoqueDeMotocicletas;
	}

	//SETTERS
	/**
	 * setNome altera o valor da variavel nome para o que foi passado pelo parametro nome
	 * @param nome nome da loja
	 */
	public void                   setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * setEndereco altera o valor da variavel endereco para o que foi passado pelo parametro endereco
	 * @param endereco endereco da loja
	 */

	public void                   setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * setEstoqueDeCarros altera os valores da ArrayList estoqueDeCarros para os valores da ArrayList que foi passada pelo parametro estoqueDeCarros
	 * @param estoqueDeCarros estoque de carros da loja
	 */
	public void                   setEstoqueDeCarros(ArrayList<Carro> estoqueDeCarros) {
		this.estoqueDeCarros = estoqueDeCarros;
	}

	/**
	 * setEstoqueDeMotocicletas altera os valores da ArrayList estoqueDeMotocicletas para os valores da ArrayList que foi passada pelo parametro estoqueDeMotocicletas
	 * @param estoqueDeMotocicletas estoque de motocicletas da loja
	 */
	public void 		      setEstoqueDeMotocicletas(ArrayList<Motocicleta> estoqueDeMotocicletas) {
		this.estoqueDeMotocicletas = estoqueDeMotocicletas;
	}
}