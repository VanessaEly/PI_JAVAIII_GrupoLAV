package infnet;
import java.io.IOException;
import javax.swing.JOptionPane;
import infnet.loja.Loja;

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
		JOptionPane.showMessageDialog(null,"Controle de Estoque");
		Object[] itens = {"Carro", "Moto"};
	  Object selectedValue = JOptionPane.showInputDialog(null, "Qual tipo de automovel voce deseja?", "OpÃ§ao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
	    
//-------------------------Opcao Carro---------------------------------------------------------------------------------
		if (selectedValue == itens[0])
		Menu.chamarMenuCarro(loja);
//-------------------------Opcao Moto----------------------------------------------------------------------------------
		if (selectedValue == itens[1])
			Menu.chamarMenuMoto(loja);		
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
				JOptionPane.showMessageDialog(null,"Adicionar Carro");
				Loja.adicionarCarro(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Pesquisar Carro");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Buscar Carro pelo Chassi");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Listar Estoque de Carros");
				Loja.listarEstoqueDeCarros(loja);
				break;
			case 5:
				Menu.chamarMenu(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Fechando o sistema, até a próxima!");
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
				JOptionPane.showMessageDialog(null,"Adicionar Moto");
				Loja.adicionarMoto(loja);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Pesquisar Moto");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Buscar Moto pelo Chassi");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Listar Estoque de Motos");
				Loja.listarEstoqueDeMotocicletas(loja);
				break;
			case 5:
				Menu.chamarMenu(loja);
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Fechando o sistema, até a próxima!");
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opÃ§Ã£o valida.");
				Menu.chamarMenuMoto(loja);
				break;
		}
	}
}
