package infnet;
import java.io.IOException;

import javax.swing.JOptionPane;

import infnet.loja.Loja;
import infnet.loja.enums.Cambio;
import infnet.loja.enums.Cor;
import infnet.loja.enums.ModeloCarro;
import infnet.loja.enums.Montadora;
import infnet.loja.enums.TipoCarro;
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
		Object[] itens = {"Controle de Estoque de Carros", "Controle de Estoque de Motos", "Criar nova Loja", "Sair"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);

		//-------------------------Opcao Carro---------------------------------------------------------------------------------
		if (selectedValue == itens[0])
			Menu.chamarMenuCarro(loja);
		//-------------------------Opcao Moto----------------------------------------------------------------------------------
		if (selectedValue == itens[1])
			Menu.chamarMenuMoto(loja);	
		if (selectedValue == itens[2])
			loja = Loja.salvarEstoque();
		if ((selectedValue == itens[3])||(selectedValue == null))
		{
			JOptionPane.showMessageDialog(null,"Fechando o sistema, ate a proxima!");
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
		try{
			String input = JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
					"1 - Adicionar Carro                      \n" +
					"2 - Pesquisar Carro 		   \n" +
					"3 - Buscar Carro pelo Chassi     \n" +
					"4 - Listar Estoque de Carros     \n" +
					"5 - Pesquisar Carro pelo atributo     \n" +
					"6 - Voltar para o Menu Principal \n" +
					"7 - Sair");
			int opcao = Integer.parseInt(Loja.validarInput(input));
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
				String chassi = JOptionPane.showInputDialog("Insira o Chassi que vocÃª deseja procurar: ");
				Carro car = Loja.buscarCarro(chassi, loja);
				if (car != null)
					JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
				else
					JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Carros");
				Loja.listarEstoqueDeCarros(loja);
				break;
			case 5:
				Menu.pesquisarCarro(loja);
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
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, voltando para o menu de carros");
			chamarMenuCarro(loja);
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
		try{
			String input = JOptionPane.showInputDialog("O que voce deseja fazer?    \n" + 
					"1 - Adicionar Moto          \n" +
					"2 - Pesquisar Moto 	      \n" +
					"3 - Buscar Moto pelo Chassi \n" +
					"4 - Listar Estoque de Motos \n" +
					"5 - Voltar para o Menu Principal \n"+
					"6 - Sair");
			int opcao = Integer.parseInt(Loja.validarInput(input));
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
				JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
				Menu.chamarMenuMoto(loja);
				break;
			}
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, voltando para o menu de motos.");
			chamarMenuMoto(loja);
		}
	}
	
	/*pesquisar carro utilizando os atributos escolhidos
	 */
	
	public static void pesquisarCarro(Loja loja)
			throws IOException
			
	{
		try{
			String input = JOptionPane.showInputDialog("Pesquisar pelo?     \n" + 
					"1 - Chassi                      \n" +
					"2 - Montadora 		   \n" +
					"3 - Modelo     \n" +
					"4 - Tipo do Carro     \n" +
					"5 - Cor \n" +
					"6 - Motorização \n" +
					"7 - Câmbio \n" +
					"8 - Preço \n" +
					"9 - Sair");
			int opcao = Integer.parseInt(Loja.validarInput(input));
			switch (opcao) 
			{
			case 1: 
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pelo chassi");
				String chassi = JOptionPane.showInputDialog("Insira o Chassi que vocÃª deseja procurar: ");
				Carro car = Loja.buscarCarro(chassi, loja);
				if (car != null)
					JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
				else
					JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
				chamarMenuCarro(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pela montadora");
				int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))"));
				loja.pesquisaCarroMontadora(aux, loja);
				chamarMenuCarro(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pelo modelo");
				int aux1 = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: (FOX(1),GOL(2),CELTA(3))"));
				loja.pesquisaCarroModelo(aux1, loja);
				chamarMenuCarro(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pelo tipo");
				int aux2 = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (SEDAN (1),HATCH (2),SUV (3))"));
				loja.pesquisaCarroTipo(aux2, loja);
				chamarMenuCarro(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pela cor");
				int aux3 = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da cor: (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
				loja.pesquisaCarroCor(aux3, loja);
				chamarMenuCarro(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pela motorização");
				float aux4 = Float.parseFloat(JOptionPane.showInputDialog("Digite a motorização: "));
				loja.pesquisaCarroMotorizacao(aux4, loja);
				chamarMenuCarro(loja);
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pelo câmbio");
				int aux5 = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do câmbio: (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
				loja.pesquisaCarroCambio(aux5, loja);
				chamarMenuCarro(loja);
				break;
			case 8:
				JOptionPane.showMessageDialog(null,"Voce optou por pesquisar pelo preço");
				float aux6 = Float.parseFloat(JOptionPane.showInputDialog("Digite o preço: "));
				loja.pesquisaCarroPreco(aux6, loja);
				chamarMenuCarro(loja);
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opcao valida.");
				Menu.chamarMenuCarro(loja);
				break;
			}

		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, voltando para o menu de carros");
			chamarMenuCarro(loja);
		}
	}
	 
}
