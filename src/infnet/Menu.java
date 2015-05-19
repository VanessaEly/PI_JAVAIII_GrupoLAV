package infnet;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import infnet.loja.Loja;
import infnet.loja.veiculos.Carro;
import infnet.loja.veiculos.Motocicleta;

/**
 * Classe Menu possui o menu que direciona o usuario pelo programa
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
 */
public class Menu 
{
	/**
	 * Metodo que permite a escolha entre opcoes de carro e de moto
	 * @param loja loja que esta sendo trabalhada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void chamarMenu(Loja loja) throws IOException
	{
		Object[] itens = {"Controle de Estoque de Carros", "Controle de Estoque de Motos", "Criar nova Loja", "Sair"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
		if (selectedValue == itens[0])
			Menu.chamarMenuCarro(loja);
		if (selectedValue == itens[1])
			Menu.chamarMenuMoto(loja);	
		if (selectedValue == itens[2])
			loja = Loja.salvarEstoque();
		if ((selectedValue == itens[3])||(selectedValue == null)){
			JOptionPane.showMessageDialog(null,"Fechando o sistema, ate a proxima!");
			System.exit(0);
		}
	}

	/**
	 * Menu que exibe todas as opcoes disponiveis para carro
	 * @param loja loja sendo trabalhada
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenuCarro(Loja loja) throws IOException
	{
		try{
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
					"1 - Adicionar Carro              \n" + 
					"2 - Remover Carro                \n" +
					"3 - Buscar Carro pelo Chassi     \n" +
					"4 - Pesquisar Carro              \n" +
					"5 - Listar Estoque de Carros     \n" +
					"6 - Voltar para o Menu Principal \n" +
					"7 - Sair"));
			switch (opcao) {
			case 1: 
				JOptionPane.showMessageDialog(null,"Voce optou por Adicionar um Carro");
				Loja.adicionarCarro(loja);
				break;
			case 2: 
				JOptionPane.showMessageDialog(null,"Voce optou por Remover um Carro");
				String chassi = JOptionPane.showInputDialog("Insira o chassi do Carro a ser removido:");
				Loja.removerCarro(chassi, loja);
				Menu.chamarMenuCarro(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar um Carro pelo Chassi");
				chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Carro car = Loja.buscarCarro(chassi, loja);
				if (car != null)
					JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
				else
					JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
				Menu.chamarMenuCarro(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar um Carro");
				ArrayList <Carro> carrosEncontrados = new ArrayList <Carro> (Loja.pesquisarCarro(loja));
				if (carrosEncontrados.isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhum carro foi encontrado");
				for (Carro m: carrosEncontrados)
					JOptionPane.showMessageDialog(null, m);
				JOptionPane.showMessageDialog(null,"Voltando para o menu de Carros");
				chamarMenuCarro(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Carros");
				Loja.listarEstoqueDeCarros(loja);
				Menu.chamarMenuCarro(loja);
				break;
			case 6:
				Menu.chamarMenu(loja);
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
				Menu.chamarMenuCarro(loja);
				break;
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Voltando para o Menu Principal.");
			Menu.chamarMenu(loja);
		}
	}

	/**
	 * Metodo que exibe todas as opcoes disponiveis para moto
	 * @param loja loja sendo trabalhada
	 * @throws IOException excecoes de entrada e saida
	 */
	public static void chamarMenuMoto(Loja loja) throws IOException
	{
		try{
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?    \n" + 
					"1 - Adicionar Moto               \n" +
					"2 - Remover Moto                 \n" +
					"3 - Buscar Moto pelo Chassi      \n" +
					"4 - Pesqusar Moto                \n" +
					"5 - Listar Estoque de Motos      \n" +
					"6 - Voltar para o Menu Principal \n" +
					"7 - Sair"));
			switch (opcao) {
			case 1: 
				JOptionPane.showMessageDialog(null,"Voce optou por Adicionar uma Moto");
				Loja.adicionarMoto(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Voce optou por Remover uma Moto");
				String chassi = JOptionPane.showInputDialog("Insira o chassi da Moto a ser removido:");
				Loja.removerMotocicleta(chassi, loja);
				Menu.chamarMenuMoto(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar uma Moto pelo Chassi");
				chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Motocicleta moto = Loja.buscarMoto(chassi, loja);
				if (moto != null)
					JOptionPane.showMessageDialog(null, "Moto Encontrada!\n" + moto);
				else
					JOptionPane.showMessageDialog(null, "Moto Nao Encontrada.");
				Menu.chamarMenuMoto(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar uma Moto");
				ArrayList <Motocicleta> motosEncontradas = new ArrayList <Motocicleta> (Loja.pesquisarMoto(loja));
				if (motosEncontradas.isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhuma moto foi encontrada");
				for (Motocicleta m: motosEncontradas)
					JOptionPane.showMessageDialog(null, m);
				JOptionPane.showMessageDialog(null,"Voltando para o menu de Motos");
				chamarMenuMoto(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Motos");
				Loja.listarEstoqueDeMotocicletas(loja);
				Menu.chamarMenuMoto(loja);
				break;
			case 6:
				Menu.chamarMenu(loja);
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
				Menu.chamarMenuMoto(loja);
				break;
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Voltando para o Menu Principal.");
			Menu.chamarMenu(loja);
		}
	}
}
