package infnet.loja;

import infnet.Arquivo;
import infnet.Menu;
import infnet.loja.veiculos.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

/**
 * Classe Loja define uma loja e faz a manutencao de seu "estoque"
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 4.0
 * @since 30-05-2015
 */
public class Loja 
{
	//VARIAVEIS DA CLASSE
	private String endereco;
	private String nome;
	public static int indiceVeiculo;

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
	public static void adicionarVeiculo(Loja loja) throws IOException
	{
		try{
			Veiculo veiculo = new Veiculo(loja);
			if (veiculo.getChassi() == null)
			{
				JOptionPane.showMessageDialog(null, "Voce inseriu um valor nulo para chassi.\nVoltando para o Menu Principal.");
				Menu.chamarMenu(loja);
			}
			for (Veiculo v: Veiculo.map.keySet())
			{
				if ((veiculo.getChassi().equals(v.getChassi()))&&(Veiculo.map.get(v).intValue() == Loja.indiceVeiculo))
				{
					JOptionPane.showMessageDialog(null, "Um veiculo com esse chassi ja esta cadastrado.");
					Menu.chamarMenu(loja);
				}
			}
			if (Loja.indiceVeiculo == 1)
			{
				if ((veiculo.getCambio() == null)||(veiculo.getCor()== null)||(veiculo.getModelo()== null)||(veiculo.getMontadora()== null)||(veiculo.getMotorizacao()<= 0)||(veiculo.getPreco()<= 0)||(veiculo.getTipo()== null))
				{
					JOptionPane.showMessageDialog(null, "Você inseriu valores invalidos e o veiculo nao pode ser adicionado.\n Voltando para o menu de Veiculos.");
					Menu.chamarMenu(loja);
				}
			}
			else
			{
				if ((veiculo.getCapacidadeDoTanque() <= 0)||(veiculo.getCor()== null)||(veiculo.getModelo()== null)||(veiculo.getMontadora()== null)||(veiculo.getCilindrada()<= 0)||(veiculo.getPreco()<= 0)||(veiculo.getTipo()== null))			{
					JOptionPane.showMessageDialog(null, "Você inseriu valores invalidos e a moto nao pode ser adicionado.\n Voltando para o menu de Veiculos.");
					Menu.chamarMenu(loja);
				}
			}
			Veiculo.map.put(veiculo, Loja.indiceVeiculo);
			Arquivo.escreveVeiculo(loja, veiculo);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Operacao cancelada, voltando para o Menu Principal");
			Menu.chamarMenu(loja);
		}
	}

	/**
	 * Metodo listarEstoqueDeVeiculos exibe todos os veiculos do tipo desejado que foram adicionados ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeVeiculos (Loja loja){
		StringBuilder veiculosEncontrados = new StringBuilder();
		if (!(Veiculo.map.values().contains(Loja.indiceVeiculo)))
			JOptionPane.showMessageDialog(null,"Nao existe veiculo para ser exibido");
		else{
			for (Entry<Veiculo, Integer> v: Veiculo.map.entrySet())
			{
				if (v.getValue().equals(Loja.indiceVeiculo))
					veiculosEncontrados.append(v.getKey().toString() + "\n");
			}
			JOptionPane.showMessageDialog(null, veiculosEncontrados.toString());
		}
	}

	/**
	 * Busca por um carro baseado pelo chassi recebido por parametro
	 * @param chassi chassi do carro que sera buscado
	 * @param loja na qual sera efetada a busca
	 * @return carro carro que foi encontrado pela busca
	 */
	public static Veiculo buscarVeiculo(String chassi, Loja loja){
		Veiculo veiculo = null;
		for (Veiculo v: Veiculo.map.keySet())
		{
			if (chassi.equals(v.getChassi())&&(Veiculo.map.get(v).intValue() == Loja.indiceVeiculo)) {
				veiculo = v;
			}
		}
		return veiculo;
	}

	/**
	 * Pesquisa e retorna carros com valores específicos no estoque, caso eles exista,
	 * @param loja loja do estoque
	 * @return carrosOk arraylist do resultado obtido
	 * @throws IOException tratamento de excecao
	 * */
	public static ArrayList<Veiculo> pesquisarVeiculo(Loja loja) throws IOException
	{
		ArrayList <Veiculo> veiculosEncontrados = new ArrayList <Veiculo>();
		Veiculo veiculo = new Veiculo(loja);
		System.out.println(veiculo.toString());
		for (Veiculo v: Veiculo.map.keySet())
		{
			if (v.equals(veiculo) == true)
				veiculosEncontrados.add(v);

		}

		return veiculosEncontrados;
	}

	/**
	 * Metodo removerCarro remove o carro com o chassi desejado da array estoqueDeMotocicletas
	 * @param chassi chassi do carro
	 * @param loja loja do estoque
	 * @throws IOException 
	 */
	public static void removerVeiculo(String chassi, Loja loja) throws IOException	
	{
		boolean ok = false;
		for (Veiculo v: Veiculo.map.keySet()){
			if (v.getChassi().equals(chassi)&&(Veiculo.map.get(v).intValue() == Loja.indiceVeiculo))
			{
				Veiculo.map.remove(v);
				ok = true;
				JOptionPane.showMessageDialog(null, "Veiculo Removido com sucesso.");
				Menu.chamarMenu(loja);
			}
		}
		if (!ok)
			JOptionPane.showMessageDialog(null, "Nao existe Veiculo desse tipo com esse Chassi no Estoque");
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

}