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
 * @version 4.0
 * @since 30-05-2015
 */
public class Loja {
	private String endereco;
	private String nome;
	private static ArrayList <Veiculo> estoque = new ArrayList <Veiculo>();

	/**
	 * Construtor Default, cria uma loja sem valores definidos
	 */
	public Loja() {}

	/**
	 * Construtor Loja constroi uma nova loja
	 * @param nome nome da loja
	 * @param endereco endereco da loja
	 */
	public Loja(String nome, String endereco) {
		this.endereco = endereco;
		this.nome = nome;
		estoque = new ArrayList<>();
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
	 * Adiciona um novo veiculo e o escreve no arquivo
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarVeiculo() throws IOException{
		Veiculo veiculo = new Veiculo();
		if (veiculo.getChassi() == null){
			JOptionPane.showMessageDialog(null, "Voce inseriu um valor nulo para chassi.\nVoltando para o Menu Principal.");
			Menu.chamarMenu();
		}
		for (Veiculo v: estoque){
			if (v.getChassi().equals(veiculo.getChassi())){
				JOptionPane.showMessageDialog(null, "Um veiculo com esse chassi ja esta cadastrado.");
				Menu.chamarMenu();
			}
		}
		estoque.add(veiculo);
		Arquivo.escreveVeiculo(veiculo);
	}

	/**
	 * Metodo listarEstoqueDeVeiculos exibe todos os veiculos do tipo desejado que foram adicionados ao estoque da loja
	 */
	public static void listarEstoqueDeVeiculos (){
		StringBuilder veiculosEncontrados = new StringBuilder();
		if (estoque.isEmpty())
			JOptionPane.showMessageDialog(null,"Nao existe veiculo para ser exibido");
		else{
			for (Veiculo v: estoque)
				veiculosEncontrados.append(v.toString() + "\n");
			JOptionPane.showMessageDialog(null, veiculosEncontrados.toString());
		}
	}

	/**
	 * Busca por um veiculo baseado pelo chassi recebido por parametro
	 * @param chassi chassi do carro que sera buscado
	 * @return veiculo veiculo que foi encontrado pela busca
	 */
	public static Veiculo buscarVeiculo(String chassi){
		Veiculo veiculo = null;
		for (Veiculo v: estoque){
			if (v.getChassi().equals(chassi))
				veiculo = v;
		}
		return veiculo;
	}

	/**
	 * Pesquisa e retorna veiculos com valores específicos no estoque, caso eles exista,
	 * @return veiculosEncontrados arraylist do resultado obtido
	 * @throws IOException tratamento de excecao
	 * */
	public static ArrayList<Veiculo> pesquisarVeiculo() throws IOException{
		ArrayList <Veiculo> veiculosEncontrados = new ArrayList <Veiculo>();
		Veiculo veiculo = new Veiculo();
		for (Veiculo v: estoque){
			if (v.equals(veiculo) == true)
				veiculosEncontrados.add(v);
		}
		return veiculosEncontrados;
	}

	/**
	 * Metodo removerVeiculo remove o veiculo com o chassi desejado da array estoque
	 * @param chassi chassi do veiculo
	 * @throws IOException para tratamento de excecao
	 */
	public static void removerVeiculo(String chassi) throws IOException		{
		boolean ok = false;
		for (Veiculo v: estoque){
			if (v.getChassi().equals(chassi)){
				estoque.remove(v);
				ok = true;
				JOptionPane.showMessageDialog(null, "Veiculo Removido com sucesso.");
				Menu.chamarMenu();
			}
		}
		if (!ok)
			JOptionPane.showMessageDialog(null, "Nao existe Veiculo desse tipo com esse Chassi no Estoque");
	}

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