package infnet;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import infnet.loja.Loja;
import infnet.loja.veiculos.Carro;
import infnet.loja.veiculos.Motocicleta;

public class Menu 
{
	/**
	 * Metodo que permite a escolha entre opcoes de carro e de moto
	 * @param loja loja que esta sendo trabalhada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void chamarMenu( Loja loja) throws IOException
	{
		Object[] itens = {"Controle de Estoque de Carros", "Controle de Estoque de Motos", "Criar nova Loja", "Sair"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);

		if (selectedValue == itens[0])
			Menu.chamarMenuCarro(loja);
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
	public static void chamarMenuCarro(Loja loja) throws IOException
	{
		try{
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
					"1 - Adicionar Carro              \n" + 
					"2 - Remover Carro                \n" +
					"3 - Pesquisar Carro     		  \n" +
					"4 - Pesquisar Carro Especifico   \n" +
					"5 - Buscar Carro pelo Chassi     \n" +
					"6 - Listar Estoque de Carros     \n" +
					"7 - Voltar para o Menu Principal \n" +
					"8 - Sair"));
			switch (opcao) 
			{
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
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar um Carro");
				Loja.pesquisarCarro(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar um Carro Especifico");

				chassi = JOptionPane.showInputDialog("Digite o chassi: ");
				if (chassi.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Voltando para o Menu Carro.");
					Menu.chamarMenuCarro(loja);
				}
				int montadora = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da montadora: \n1 - VOLKSWAGEN\n2 - FORD\n3 - CHEVROLET\n4 - FIAT"));
				int modelo = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - FOX\n2 - GOL\n3 - CELTA"));
				int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - SEDAN\n2 - HATCH\n3 - SUV"));
				int cor = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:\n1 - PRETO\n2 - BRANCO\n3 - AZUL\n4 - VERDE\n5 - ROSA\n6 - AMARELO"));
				float motorizacao = Float.parseFloat(JOptionPane.showInputDialog("Digite numero do motor:"));
				int cambio = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:\n1 - MANUAL\n2 - SEMI\n3 - AUTO"));
				float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do carro"));

				ArrayList <Carro> carrosEncontrados = new ArrayList <Carro> (Loja.pesquisarCarroEspecifico(loja, chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco));
				if (carrosEncontrados.isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhum carro foi encontrado");
				for (Carro m: carrosEncontrados)
					JOptionPane.showMessageDialog(null, m);
				JOptionPane.showMessageDialog(null,"Voltando para o menu de Carros");
				chamarMenuCarro(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar um Carro pelo Chassi");
				chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Carro car = Loja.buscarCarro(chassi, loja);
				if (car != null)
					JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
				else
					JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
				Menu.chamarMenuCarro(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Carros");
				Loja.listarEstoqueDeCarros(loja);
				Menu.chamarMenuCarro(loja);
				break;
			case 7:
				Menu.chamarMenu(loja);
				break;
			case 8:
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
					"3 - Pesquisar Moto 	          \n" +
					"4 - Pesquisar Moto Especifica    \n" +
					"5 - Buscar Moto pelo Chassi      \n" +
					"6 - Listar Estoque de Motos      \n" +
					"7 - Voltar para o Menu Principal \n" +
					"8 - Sair"));
			switch (opcao) 
			{
			case 1: 
				JOptionPane.showMessageDialog(null,"Voce optou por Adicionar uma Moto");
				Loja.adicionarMoto(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Voce optou por Remover uma Moto");
				String chassi = JOptionPane.showInputDialog("Insira o chassi da Moto a ser removido:");
				Loja.removerMotocicleta(chassi, loja);
				Menu.chamarMenuCarro(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar uma Moto");
				Loja.pesquisarMoto(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar Moto Especifica");

				chassi = JOptionPane.showInputDialog("Digite o chassi: ");
				int montadora = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora:\n1 - HONDA\n2 - SUZUKI\n3 - YAMAHA\n4 - KAWASAKI"));
				int modelo = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - CBR\n2 - NINJA\n3 - CB_HORNET"));
				int tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - CHOPPER\n2 - SCOOTER\n3 - ESPORTIVO"));
				int cor = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:\n1 - PRETO\n2 - BRANCO\n3 - AZUL\n4 - VERDE\n5 - ROSA\n6 - AMARELO"));
				int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cilindradas:"));
				int capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a Capacidade do Tanque:"));
				float preco = Float.parseFloat((JOptionPane.showInputDialog("Digite o preco da Moto")));

				ArrayList <Motocicleta> motosEncontradas = new ArrayList <Motocicleta> (Loja.pesquisarMotoEspecifica(loja, chassi, montadora, modelo, tipo, cor, cilindrada, capacidadeDoTanque, preco));
				if (motosEncontradas.isEmpty())
					JOptionPane.showMessageDialog(null,"Nenhuma moto foi encontrada");
				for (Motocicleta m: motosEncontradas)
					JOptionPane.showMessageDialog(null, m);
				JOptionPane.showMessageDialog(null,"Voltando para o menu de Motos");
				chamarMenuMoto(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar uma Moto pelo Chassi");
				chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Motocicleta moto = Loja.buscarMoto(chassi, loja);
				if (moto != null)
					JOptionPane.showMessageDialog(null, "Moto Encontrada!\n" + moto);
				else
					JOptionPane.showMessageDialog(null, "Moto Nao Encontrada.");
				Menu.chamarMenuMoto(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Motos");
				Loja.listarEstoqueDeMotocicletas(loja);
				Menu.chamarMenuCarro(loja);
				break;
			case 7:
				Menu.chamarMenu(loja);
				break;
			case 8:
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

	public static int menuPesquisaCarro(Loja loja) throws IOException
	{
		int indice = -1;
		Object[] itens = {"Pesquisar Carro por Chassi", "Pesquisar Carro por Montadora", "Pesquisar Carro por Modelo", "Pesquisar Carro por Tipo","Pesquisar Carro por Cor",
				"Pesquisar Carro por Motorizacao", "Pesquisar Carro por Cambio", "Pesquisar Carro por Preco", "Voltar para o Menu de Carros"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
		if (selectedValue == itens[0])
			indice = 0;
		if (selectedValue == itens[1])
			indice = 1;	
		if (selectedValue == itens[2])
			indice = 2;
		if (selectedValue == itens[3])
			indice = 3;
		if (selectedValue == itens[4])
			indice = 4;
		if (selectedValue == itens[5])
			indice = 5;
		if (selectedValue == itens[6])
			indice = 6;
		if (selectedValue == itens[7])
			indice = 7;
		if ((selectedValue == itens[8])||(selectedValue == null))
		{
			JOptionPane.showMessageDialog(null,"Voltando para o menu de Carros");
			chamarMenuCarro(loja);
		}
		return indice;
	}
	public static int menuPesquisaMoto(Loja loja) throws IOException
	{
		int indice = -1;
		Object[] itens = {"Pesquisar Moto por Chassi", "Pesquisar Moto por Montadora", "Pesquisar Moto por Modelo", "Pesquisar Moto por Tipo","Pesquisar Moto por Cor",
				"Pesquisar Carro por Cilindrada", "Pesquisar Carro por Capacidade do Tanque", "Pesquisar Carro por Preco", "Voltar para o Menu de Motos"};
		Object selectedValue = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
		if (selectedValue == itens[0])
			indice = 0;
		if (selectedValue == itens[1])
			indice = 1;	
		if (selectedValue == itens[2])
			indice = 2;
		if (selectedValue == itens[3])
			indice = 3;
		if (selectedValue == itens[4])
			indice = 4;
		if (selectedValue == itens[5])
			indice = 5;
		if (selectedValue == itens[6])
			indice = 6;
		if (selectedValue == itens[7])
			indice = 7;
		if ((selectedValue == itens[8])||(selectedValue == null))
		{
			JOptionPane.showMessageDialog(null,"Voltando para o menu de Motos");
			chamarMenuMoto(loja);
		}
		return indice;
	}
}
