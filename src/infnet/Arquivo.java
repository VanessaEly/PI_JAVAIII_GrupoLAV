package infnet;

import infnet.loja.Loja;
import infnet.loja.veiculos.Veiculo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * Classe Arquivo possui os metodos referentes a gravacao em arquivo
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 08-06-2015
 */
public class Arquivo {
	public static PrintWriter gravarArq;

	/**
	 * metodo criaArquivo cria um novo txt com o nome e endereco da loja
	 * @param loja loja a qual pertence o arquivo
	 * @throws IOException 
	 */
	public static void criaArquivo(Loja loja) throws IOException {
		
			Principal.nomearq = (JOptionPane.showInputDialog("Digite o nome do seu arquivo de estoque(Ex: 'loja.txt'): "));
			while (Principal.nomearq.isEmpty())
				Principal.nomearq = (JOptionPane.showInputDialog("Nome Invalido. Digite o nome do seu arquivo .txt(Ex: 'loja.txt'): "));
			if (!(Principal.nomearq.contains(".txt")))
				Principal.nomearq = Principal.nomearq + ".txt";
			//cria objeto file
			File arq = new File(Principal.nomearq);
			//se arquivo nao existir, cria novo arquivo e nova loja
			if (!arq.exists()) 
			{
				loja.setNome(JOptionPane.showInputDialog("Digite o nome da loja: "));
				while (loja.getNome().isEmpty())
					loja.setNome(JOptionPane.showInputDialog("Nome Invalido. Digite o nome da loja: "));
				loja.setEndereco(JOptionPane.showInputDialog("Digite o endereco da loja: "));
				while (loja.getEndereco().isEmpty())
					loja.setEndereco(JOptionPane.showInputDialog("Nome Invalido. Digite o endereco da loja: "));
				//cria arquivo txt
				arq.createNewFile();
				//escreve nome da loja e endereco no arquivo
				try
				{
					gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true)))); //true garante que a escrita nao sobrescreva o conteudo atual
					gravarArq.printf("\nLoja %s", loja.getNome());
					gravarArq.printf(" - Endereco %s", loja.getEndereco()); //dados que serao escritos
					gravarArq.println();
					gravarArq.flush(); //limpa buffer
					JOptionPane.showMessageDialog(null,"Arquivo " + Principal.nomearq + " criado com sucesso. Agora voce esta trabalhando com essa loja.");
				} 
				finally 
				{
					if (gravarArq != null) 
						gravarArq.close();
				}
			}
			else
				JOptionPane.showMessageDialog(null,"Arquivo ja existe. Dados acrescentados serao incluidos no mesmo.");
			Menu.chamarMenu();
		
	}

	/**
	 * metodo escreveVeiculo escreve o veiculo em questao no arquivo da loja recebida por parametro
	 * @param veiculo veiculo a ser escrito
	 * @throws IOException para traramento de excecao
	 */
	public static void escreveVeiculo(Veiculo veiculo) throws IOException {
		try
		{
			Arquivo.gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true)))); //true garante que a escrita nao sobrescreva o conteudo atual
			Arquivo.gravarArq.printf("\n%s", veiculo.toString()); //dados que serao escritos
			Arquivo.gravarArq.println();
			Arquivo.gravarArq.flush(); //limpa buffer
		}
		finally 
		{
			if (Arquivo.gravarArq != null) 
				Arquivo.gravarArq.close();
		}
		JOptionPane.showMessageDialog(null,"Veiculo cadastrado com sucesso.");
		Menu.chamarMenu();
	}
}
