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
	 * Metodo que permite a escolha entre opcoes de carro e de moto
	 * @param loja loja que esta sendo trabalhada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static int chamarMenuVeiculo(Loja loja) throws IOException
	{
		Object[] itens = {"Carro", "Moto", "Voltar"};
		Object selectedValue = JOptionPane.showInputDialog(null, "Carro ou Moto?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
		if (selectedValue == itens[0])
			return 1;
		if (selectedValue == itens[1])
			return 2;
		if ((selectedValue == itens[3])||(selectedValue == null)){
			JOptionPane.showMessageDialog(null,"Voltando para o Menu Principal");
			chamarMenu(loja);
		}
		return 0;
	}

	/**
	 * Menu que exibe todas as opcoes disponiveis
	 * @param loja loja sendo trabalhada
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenu(Loja loja) throws IOException
	{
		try{
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
				Loja.indiceVeiculo = chamarMenuVeiculo(loja);
				Loja.adicionarVeiculo(loja);
				chamarMenu(loja);
				break;
			case 2: 
				Loja.indiceVeiculo = chamarMenuVeiculo(loja);
				String chassi = JOptionPane.showInputDialog("Insira o chassi do Veiculo a ser removido:");
				Loja.removerVeiculo(chassi, loja);
				chamarMenu(loja);
				break;
			case 3:
				Loja.indiceVeiculo = chamarMenuVeiculo(loja);
				chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Veiculo v = Loja.buscarVeiculo(chassi, loja);
				if (v != null)
					JOptionPane.showMessageDialog(null, "Encontrado!\n" + v.toString());
				else
					JOptionPane.showMessageDialog(null, "Nao Encontrado.");
				chamarMenu(loja);
				break;
			case 4:
				Loja.indiceVeiculo = chamarMenuVeiculo(loja);
				JOptionPane.showMessageDialog(null,"OBS: DIGITE 0 PARA IGNORAR CAMPOS.");
				ArrayList <Veiculo> veiculosEncontrados = new ArrayList <Veiculo> (Loja.pesquisarVeiculo(loja));
				if (veiculosEncontrados.isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhum Veiculo foi encontrado");
				for (Veiculo m: veiculosEncontrados)
					JOptionPane.showMessageDialog(null, m.toString());
				JOptionPane.showMessageDialog(null,"Voltando para o Menu Principal");
				chamarMenu(loja);
				break;
			case 5:
				Loja.indiceVeiculo = chamarMenuVeiculo(loja);
				Loja.listarEstoqueDeVeiculos(loja);
				chamarMenu(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Voce optou por Criar uma nova Loja");
				loja = Loja.salvarEstoque();
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
				chamarMenu(loja);
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Saindo do Sistema. Ate a Proxima.");
			System.exit(0);
		}
	}
}

