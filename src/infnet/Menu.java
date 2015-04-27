package infnet;
import java.io.IOException;

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
					"3 - Pesquisar Carro Especifico   \n" +
					"4 - Buscar Carro pelo Chassi     \n" +
					"5 - Listar Estoque de Carros     \n" +
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
				Loja.pesquisarCarro(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar um Carro Especifico");
				
				input = JOptionPane.showInputDialog("Digite o chassi: ");
				String _chassi = (Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite o numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))");
				int montadora = Integer.parseInt(Loja.validarInput(input));;
				input = JOptionPane.showInputDialog("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))");
				int modelo = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))");
				int tipo = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
				int cor = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero do motor:		(1.0/1.4/1.6/1.8/2.0)");
				float motorizacao = Float.parseFloat(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))");
				int cambio = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite o preco do carro");
				float preco = Float.parseFloat(Loja.validarInput(input));
				
				Carro carro = Loja.pesquisarCarroEspecifico(loja, _chassi, montadora, modelo, tipo, cor, motorizacao, cambio, preco);
				if (carro == null)
					JOptionPane.showMessageDialog(null,"Carro nao encontrado");
				else
					JOptionPane.showMessageDialog(null,"Carro Encontrado.\n" + carro);
				Menu.chamarMenuCarro(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar um Carro pelo Chassi");
				String chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Carro car = Loja.buscarCarro(chassi, loja);
				if (car != null)
					JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
				else
					JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
				Menu.chamarMenuCarro(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Carros");
				Loja.listarEstoqueDeCarros(loja);
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
			JOptionPane.showMessageDialog(null, "Valor inv�lido, voltando para o menu de carros");
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
					"3 - Pesquisar Moto Especifica \n"+
					"4 - Buscar Moto pelo Chassi \n" +
					"5 - Listar Estoque de Motos \n" +
					"6 - Voltar para o Menu Principal \n"+
					"7 - Sair");
			int opcao = Integer.parseInt(Loja.validarInput(input));
			switch (opcao) 
			{
			case 1: 
				JOptionPane.showMessageDialog(null,"Voce optou por Adicionar uma Moto");
				Loja.adicionarMoto(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar uma Moto");
				Loja.pesquisarMoto(loja);
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Voce optou por Pesquisar Moto Especifica");
				
				input = JOptionPane.showInputDialog("Digite o chassi: ");
				String _chassi = (Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))");
				int montadora = Integer.parseInt(Loja.validarInput(input));;
				input = JOptionPane.showInputDialog("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))");
				int modelo = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))");
				int tipo = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
				int cor = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite numero de cilindradas (Ex: 50, 60, 100, 120, 150):");
				int cilindrada = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite a Capacidade do Tanque:");
				int capacidadeDoTanque = Integer.parseInt(Loja.validarInput(input));
				input = JOptionPane.showInputDialog("Digite o preco da Moto");
				float preco = Float.parseFloat(Loja.validarInput(input));
				
				Motocicleta motocicleta = Loja.pesquisarMotoEspecifica(loja, _chassi, montadora, modelo, tipo, cor, cilindrada, capacidadeDoTanque, preco);
				if (motocicleta == null)
					JOptionPane.showMessageDialog(null,"Moto nao encontrada");
				else
					JOptionPane.showMessageDialog(null,"Moto Encontrada.\n" + motocicleta);
				Menu.chamarMenuMoto(loja);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Voce optou por Buscar uma Moto pelo Chassi");
				String chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
				Motocicleta moto = Loja.buscarMoto(chassi, loja);
				if (moto != null)
					JOptionPane.showMessageDialog(null, "Moto Encontrada!\n" + moto);
				else
					JOptionPane.showMessageDialog(null, "Moto Nao Encontrada.");
				Menu.chamarMenuMoto(loja);
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Voce optou por Listar Estoque de Motos");
				Loja.listarEstoqueDeMotocicletas(loja);
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
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inv�lido, voltando para o menu de motos.");
			chamarMenuMoto(loja);
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