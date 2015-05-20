package infnet.loja;

import infnet.Arquivo;
import infnet.Menu;
import infnet.loja.veiculos.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Classe Loja define uma loja e faz a manutencao de seu "estoque"
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class Loja 
{
	//VARIAVEIS DA CLASSE
	private String endereco;
	private String nome;
	private ArrayList <Carro>	estoqueDeCarros       = new ArrayList <Carro>();
	private ArrayList <Motocicleta>  estoqueDeMotocicletas = new ArrayList <Motocicleta>();

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
	public static Loja salvarEstoque() throws IOException {
		Loja loja = new Loja();
		Arquivo.criaArquivo(loja);
		return loja;
	}

	/**
	 * Adiciona um novo carro e o escreve no arquivo
	 * @param loja loja cujo estoque recebera o carro 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarCarro(Loja loja) throws IOException
	{
		try{
			Carro carro = new Carro();
			EspecCarro carroE = new EspecCarro();
			carro.setEspC(carroE);

			for (Carro c: loja.getEstoqueDeCarros())
			{
				if (carro.getEspC().getChassi().equals(c.getEspC().getChassi()))
				{
					JOptionPane.showMessageDialog(null, "Um carro com esse chassi ja esta cadastrado.");
					Menu.chamarMenu(loja);
				}
			}
			if ((carroE.getCambio() == null)||(carroE.getChassi()== null)||(carroE.getCor()== null)||(carroE.getModelo()== null)||(carroE.getMontadora()== null)||(carroE.getMotorizacao()<= 0)||(carroE.getPreco()<= 0)||(carroE.getTipo()== null))
			{
				JOptionPane.showMessageDialog(null, "Você inseriu valores invalidos e o carro nao pode ser adicionado.\n Voltando para o menu de Carros.");
				Menu.chamarMenuCarro(loja);
			}
			else
			{
				loja.estoqueDeCarros.add(carro);
				Arquivo.escreveCarro(loja);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Operacao cancelada, voltando para o menu de carros");
			Menu.chamarMenuCarro(loja);
		}
	}

	/**
	 * Adiciona uma nova moto e a escreve no arquivo
	 * @param loja loja cujo estoque recebera a moto 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarMoto(Loja loja) throws IOException{
		try{
			Motocicleta moto = new Motocicleta();
			EspecMoto motoE = new EspecMoto();
			moto.setEspM(motoE);
			for (Motocicleta m: loja.getEstoqueDeMotocicletas())
			{
				if (moto.getEspM().getChassi().equals(m.getEspM().getChassi()))
				{
					JOptionPane.showMessageDialog(null, "Uma moto com esse chassi ja esta cadastrada.");
					Menu.chamarMenu(loja);
				}
			}
			if ((motoE.getCapacidadeDoTanque() <= 0)||(motoE.getChassi()== null)||(motoE.getCor()== null)||(motoE.getModelo()== null)||(motoE.getMontadora()== null)||(motoE.getCilindrada()<= 0)||(motoE.getPreco()<= 0)||(motoE.getTipo()== null))
			{
				JOptionPane.showMessageDialog(null, "Você inseriu valores invalidos e a moto nao pode ser adicionada.\n Voltando para o menu de Motos.");
				Menu.chamarMenuMoto(loja);
			}
			else
			{
				loja.estoqueDeMotocicletas.add(moto);
				Arquivo.escreveMoto(loja);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Operacao cancelada, voltando para o menu de motos");
			Menu.chamarMenuMoto(loja);
		}
	}

	/**
	 * Metodo listarEstoqueDeCarros exibe todos os carros que foram adicionados ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeCarros (Loja loja){
		StringBuilder carrosA = new StringBuilder();
		if (loja.estoqueDeCarros.isEmpty())
			JOptionPane.showMessageDialog(null,"Nao a nenhum carro para ser exibido");
		else{
			for (Carro c: loja.estoqueDeCarros)
				carrosA.append(" - " + c.getEspC().toString() + "\n");
			JOptionPane.showMessageDialog(null,"Lista de Carros: \n" + carrosA.toString());
		}
	}

	/**
	 * Metodo listarEstoqueDeMotocicletas exibe todas as motocicletas que foram adicionadas ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeMotocicletas (Loja loja){
		StringBuilder motosA = new StringBuilder();
		if (loja.estoqueDeMotocicletas.isEmpty())
			JOptionPane.showMessageDialog(null,"Nao a nenhuma moto para ser exibida");
		else{
			for (Motocicleta m: loja.estoqueDeMotocicletas)
				motosA.append(" - " + m.getEspM().toString() + "\n");
			JOptionPane.showMessageDialog(null,"Lista de Motos: \n" + motosA.toString());
		}
	}

	/**
	 * Busca por um carro baseado pelo chassi recebido por parametro
	 * @param chassi chassi do carro que sera buscado
	 * @param loja na qual sera efetada a busca
	 * @return carro carro que foi encontrado pela busca
	 */
	public static Carro buscarCarro(String chassi, Loja loja){
		Carro carro = null;
		for (Carro car: loja.estoqueDeCarros)
		{
			if (chassi.equals(car.getEspC().getChassi())) {
				carro = car;
			}
		}
		return carro;
	}

	/**
	 * Busca por uma moto baseado pelo chassi recebido por parametro
	 * @param chassi chassi da moto que sera buscada
	 * @param loja na qual sera efetada a busca
	 * @return moto moto que foi encontrado pela busca
	 */
	public static Motocicleta buscarMoto(String chassi, Loja loja){
		Motocicleta moto = null;
		for (Motocicleta m: loja.estoqueDeMotocicletas)
		{
			if (chassi.equals(m.getEspM().getChassi())) {
				moto = m;
			}
		}
		return moto;
	}

	/**
	 * Pesquisa e retorna carros com valores específicos no estoque, caso eles exista,
	 * @param loja loja do estoque
	 * @throws IOException tratamento deexcecao de entrada e saida
	 * @return carrosOk arraylist do resultado obtido
	 * */
	public static ArrayList<Carro> pesquisarCarro(Loja loja) throws IOException
	{
		ArrayList <Carro> carrosOk = new ArrayList <Carro>();
		Carro carro = new Carro();
		EspecCarro carroE = new EspecCarro();
		carro.setEspC(carroE);
		for (Carro c: loja.estoqueDeCarros)
		{
			if (c.getEspC().equals(carroE) == true)
				carrosOk.add(c);
		}
		return carrosOk;
	}

	/**
	 * Pesquisa e retorna motos com valores específicos no estoque, caso elas existam
	 * @param loja loja do estoque
	 * @throws IOException tratamento de excecao de entrada e saida
	 * @return motosOk arraylist do resultado obtido
	 */
	public static ArrayList <Motocicleta> pesquisarMoto(Loja loja) throws IOException
	{
		ArrayList <Motocicleta> motosOk = new ArrayList <Motocicleta>();
		Motocicleta moto = new Motocicleta();
		EspecMoto motoE = new EspecMoto();
		moto.setEspM(motoE);
		for (Motocicleta c: loja.estoqueDeMotocicletas)
		{
			if (c.getEspM().equals(motoE) == true)
				motosOk.add(c);
		}
		return motosOk;
	}

	/**
	 * Metodo removerCarro remove o carro com o chassi desejado da array estoqueDeMotocicletas
	 * @param chassi chassi do carro
	 * @param loja loja do estoque
	 */
	public static void removerCarro(String chassi, Loja loja)	
	{
		boolean ok = false;
		for (Carro c: loja.estoqueDeCarros){
			if (c.getEspC().getChassi().equals(chassi))
			{
				loja.estoqueDeCarros.remove(c);
				ok = true;
				JOptionPane.showMessageDialog(null, "Carro Removido com sucesso.");
			}
		}
		if (!ok)
			JOptionPane.showMessageDialog(null, "Nao existe Carro com esse Chassi no Estoque");
	}

	/**
	 * Metodo removerMotocicleta remove a motocicleta com o chassi desejado da array estoqueDeMotocicletas
	 * @param chassi chassi da moto
	 * @param loja loja do estoque
	 */
	public static void removerMotocicleta(String chassi, Loja loja)	
	{
		boolean ok = false;
		for (Motocicleta c: loja.estoqueDeMotocicletas){
			if (c.getEspM().getChassi().equals(chassi))
			{
				loja.estoqueDeMotocicletas.remove(c);
				ok = true;
				JOptionPane.showMessageDialog(null, "Moto Removida com sucesso.");
			}
		}
		if (!ok)
			JOptionPane.showMessageDialog(null, "Nao existe Moto com esse Chassi no Estoque");
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