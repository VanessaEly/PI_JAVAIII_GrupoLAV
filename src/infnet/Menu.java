package infnet;
import java.io.IOException;

import javax.swing.JOptionPane;

import infnet.loja.Loja;
import infnet.loja.veiculos.Carro;

public class Menu 
{
	/**
	 * Metodo que permite a escolha entre opcoes de carro e de moto
	 * @param loja loja que esta sendo trabalhada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void chamarMenu( Loja loja) 
			throws IOException
	{
		Object[] itens = {"Controle de Estoque de Carros", "Controle de Estoque de Motos", "Sair"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);

		//-------------------------Opcao Carro---------------------------------------------------------------------------------
		if (selectedValue == itens[0])
			Menu.chamarMenuCarro(loja);
		//-------------------------Opcao Moto----------------------------------------------------------------------------------
		if (selectedValue == itens[1])
			Menu.chamarMenuMoto(loja);	
		if (selectedValue == itens[2])
		{
			JOptionPane.showMessageDialog(null,"Fechando o sistema, até a próxima!");
			System.exit(0);
		}

	}

	/**
	 * Menu que exibe todas as opcoes disponiveis para carro
	 * @param loja loja sendo trabalhada
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenuCarro(Loja loja)
			throws IOException
	{
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
				"1 - Adicionar Carro                      \n" +
				"2 - Pesquisar Carro 		   \n" +
				"3 - Buscar Carro pelo Chassi     \n" +
				"4 - Listar Estoque de Carros     \n" +
				"5 - Voltar para o Menu Principal \n" +
				"6 - Sair"));
		switch (opcao) 
		{
		case 1: 
			JOptionPane.showMessageDialog(null,"Voce optou por Adicionar um Carro");
			Loja.adicionarCarro(loja);
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar um Carro");
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Voce optou por Buscar um Carro pelo Chassi");
			String chassi = JOptionPane.showInputDialog("Insira o Chassi que você deseja procurar: ");
			Carro car = Loja.buscarCarro(chassi, loja);
			if (car != null)
				JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
			else
				JOptionPane.showMessageDialog(null, "Carro Não Encontrado.");
			break;
		case 4:
			JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Carros");
			Loja.listarEstoqueDeCarros(loja);
			break;
		case 5:
			Menu.chamarMenu(loja);
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, até a próxima!");
			System.exit(0);	
		default:
			JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
			Menu.chamarMenuCarro(loja);
			break;
		}
	}

	/**
	 * Metodo que exibe todas as opcoes disponiveis para moto
	 * @param loja loja sendo trabalhada
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenuMoto(Loja loja)
			throws IOException
	{
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?    \n" + 
				"1 - Adicionar Moto          \n" +
				"2 - Pesquisar Moto 	      \n" +
				"3 - Buscar Moto pelo Chassi \n" +
				"4 - Listar Estoque de Motos \n" +
				"5 - Voltar para o Menu Principal \n"+
				"6 - Sair"));
		switch (opcao) 
		{
		case 1: 
			JOptionPane.showMessageDialog(null,"Voce optou por Adicionar uma Moto");
			Loja.adicionarMoto(loja);
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Voc optou por Pesquisar uma Moto");
			break;
		case 3:
			JOptionPane.showMessageDialog(null,"Voce optou por Buscar uma Moto pelo Chassi");
			break;
		case 4:
			JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Motos");
			Loja.listarEstoqueDeMotocicletas(loja);
			break;
		case 5:
			Menu.chamarMenu(loja);
			break;
		case 6:
			JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, até a próxima!");
			System.exit(0);	
		default:
			JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
			Menu.chamarMenuMoto(loja);
			break;
		}
	}
}
