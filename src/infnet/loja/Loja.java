package infnet.loja;

import infnet.loja.veiculos.*;
import infnet.loja.enums.*;
import java.util.Scanner;
import java.util.ArrayList;

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
	private ArrayList <Motocicleta> estoqueDeMotocicletas = new ArrayList <Motocicleta>();;
	Scanner scan = new Scanner(System.in);

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

	/**adicionarCarro
	 * Metodo adicionarCarro adiciona um carro ao estoque da loja
	 * Valores das variáveis são recebidos por input do usuário
	 */
	public void adicionarCarro()
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

		System.out.println("Digite o numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=5) //tratamento de excecao limitando o indice que pode ser escolhido, utilizado sempre que tratar-se de uma enumeracao
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Montadora m: Montadora.values()) //percorre a enumeração
		{
			if (m.getIndice() == aux) //verifica qual valor da enumeração possui o índice escolhido
				_montadora = m;
		}

		System.out.println("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (ModeloCarro m: ModeloCarro.values())
		{
			if (m.getIndice() == aux)
				_modelo = m;
		}
		System.out.println("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (TipoCarro m: TipoCarro.values())
		{
			if (m.getIndice() == aux)
				_tipo = m;
		}
		System.out.println("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Cambio m: Cambio.values())
		{
			if (m.getIndice() == aux)
				_cambio = m;
		}
		System.out.println("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=7)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == aux)
				_cor = m;
		}
		System.out.println("Digite numero do motor:		(1,0/1,4/1,6/1,8/2,0)");
		_motorizacao = scan.nextFloat();
		System.out.println("Digite o chassi");
		_chassi = scan.next();
		System.out.println("Digite o preco do carro");
		_preco = scan.nextFloat();

		//chamando o metodo construtor e colocando o carro criado no array de carros da loja
		Carro carroaux = new Carro(_chassi, _montadora, _modelo, _tipo, _cor, _motorizacao, _cambio, _preco);
		estoqueDeCarros.add(carroaux);
	}

	/**
	 * Metodo adicionarMoto adiciona uma motocicleta ao estoque da loja
	 * Valores das variáveis são recebidos por input do usuário
	 */
	public void adicionarMoto()
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

		System.out.println("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))");
		aux = scan.nextInt();
		while (aux <= 4 || aux >=9)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Montadora m: Montadora.values())
		{
			if (m.getIndice() == aux)
				_montadora = m;
		}
		System.out.println("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (ModeloMoto m: ModeloMoto.values())
		{
			if (m.getIndice() == aux)
				_modelo = m;
		}
		System.out.println("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Invalido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (TipoMoto m: TipoMoto.values())
		{
			if (m.getIndice() == aux)
				_tipo = m;
		}
		System.out.println("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
		_cor = Cor.values()[scan.nextInt()];
		System.out.println("Digite numero de cilindradas:	(50cc, 60cc, 100cc, 120cc, 150cc)");
		_cilindradas = scan.nextInt();
		System.out.println("Digite a capacidade do Tanque:");
		_capacidadeDoTanque = scan.nextInt();
		System.out.println("Digite o chassi");
		_chassi = scan.next();
		System.out.println("Digite o preco da Moto");
		_preco = scan.nextFloat();

		Motocicleta motoaux = new Motocicleta (_chassi, _montadora, _modelo, _tipo, _cor, _cilindradas, _capacidadeDoTanque, _preco);
		estoqueDeMotocicletas.add(motoaux);
		scan.close();
	}

	/**
	 * Metodo listarEstoqueDeCarros exibe todos os carros que foram adicionados ao estoque da loja
	 * Array estoqueDeCarros é percorrido por um enhanced for
	 */
	public void listarEstoqueDeCarros (){
		int i = 1;
		for (Carro c: estoqueDeCarros)
		{
			System.out.println("Carro " + i);
			System.out.println(c);
			i++;
		}
	}

	/**
	 * Metodo listarEstoqueDeMotocicletas exibe todas as motocicletas que foram adicionadas ao estoque da loja
	 * Array estoqueDeMotocicletas é percorrido por um enhanced for
	 */
	public void listarEstoqueDeMotocicletas (){
		int i = 1;
		for (Motocicleta d: estoqueDeMotocicletas)
		{
			System.out.println("Moto " + i);
			System.out.println(d);
			i++;
		}
	}

	/**
	 * Metodo removerCarro remove o carro desejado da array estoqueDeCarros
	 */
	public void removerCarro(Carro car)
	{
		estoqueDeCarros.remove(car);
	}

	/**
	 * Metodo removerMotocicleta remove a motocicleta desejada da array estoqueDeMotocicletas
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
	 * @return nome
	 */
	public String                 getNome() {
		return nome;
	}
	/**
	 * getEndereco Retorna o endereco da loja
	 * @return endereco
	 */
	public String                 getEndereco() {
		return endereco;
	}
	/**
	 * getEstoqueDeCarros retorna o ArrayList do estoque de carros da loja
	 * @return estoqueDeCarros
	 */
	public ArrayList<Carro>       getEstoqueDeCarros() {
		return estoqueDeCarros;
	}
	
	/**
	 * getEstoqueDeMotocicletas retorna o ArrayList do estoque de motocicletas da loja
	 * @return estoqueDeMotocicletas
	 */
	public ArrayList<Motocicleta> getEstoqueDeMotocicletas() {
		return estoqueDeMotocicletas;
	}

	//SETTERS
	/**
	 * setNome altera o valor da variavel nome para o que foi passado pelo parametro nome
	 * @param nome
	 */
	public void                   setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * setEndereco altera o valor da variavel endereco para o que foi passado pelo parametro endereco
	 * @param endereco
	 */

	public void                   setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * setEstoqueDeCarros altera os valores da ArrayList estoqueDeCarros para os valores da ArrayList que foi passada pelo parametro estoqueDeCarros
	 * @param estoqueDeCarros
	 */
	public void                   setEstoqueDeCarros(ArrayList<Carro> estoqueDeCarros) {
		this.estoqueDeCarros = estoqueDeCarros;
	}

	/**
	 * setEstoqueDeMotocicletas altera os valores da ArrayList estoqueDeMotocicletas para os valores da ArrayList que foi passada pelo parametro estoqueDeMotocicletas
	 * @param estoqueDeMotocicletas
	 */
	public void 		      setEstoqueDeMotocicletas(ArrayList<Motocicleta> estoqueDeMotocicletas) {
		this.estoqueDeMotocicletas = estoqueDeMotocicletas;
	}


}
