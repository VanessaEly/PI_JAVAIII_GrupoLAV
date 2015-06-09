package infnet;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import infnet.loja.Loja;
import infnet.loja.veiculos.Veiculo;

/**
 * Classe Menu possui o menu que direciona o usuario pelo programa
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 3.0
 * @since 19-05-2015
 */
public class Menu 
{
	/**
	 * Menu que exibe todas as opcoes disponiveis
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenu() throws IOException
	{
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
				"1 - Adicionar              \n" + 
				"2 - Remover                \n" +
				"3 - Buscar pelo Chassi     \n" +
				"4 - Pesquisar              \n" +
				"5 - Listar Estoque         \n" +
				"6 - Criar Nova Loja        \n" +
				"7 - Sair"));
		switch (opcao) {
		case 1: 
			Loja.adicionarVeiculo();
			chamarMenu();
			break;
		case 2: 
			String chassi = JOptionPane.showInputDialog("Insira o chassi do Veiculo a ser removido:");
			Loja.removerVeiculo(chassi);
			chamarMenu();
			break;
		case 3:
			chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
			Veiculo v = Loja.buscarVeiculo(chassi);
			if (v != null)
				JOptionPane.showMessageDialog(null, "Encontrado!\n" + v.toString());
			else
				JOptionPane.showMessageDialog(null, "Nao Encontrado.");
			chamarMenu();
			break;
		case 4:
			JOptionPane.showMessageDialog(null,"OBS: DIGITE 0 PARA IGNORAR CAMPOS.");
			ArrayList <Veiculo> veiculosEncontrados = new ArrayList <Veiculo> (Loja.pesquisarVeiculo());
			if (veiculosEncontrados.isEmpty())
				JOptionPane.showMessageDialog(null,"Nenhum Veiculo foi encontrado");
			for (Veiculo m: veiculosEncontrados)
				JOptionPane.showMessageDialog(null, m.toString());
			JOptionPane.showMessageDialog(null,"Voltando para o Menu Principal");
			chamarMenu();
			break;
		case 5:
			Loja.listarEstoqueDeVeiculos();
			chamarMenu();
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Voce optou por Criar uma nova Loja");
			Loja.salvarEstoque();
			break;
		case 7:
			JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
			chamarMenu();
		}
	}
}

