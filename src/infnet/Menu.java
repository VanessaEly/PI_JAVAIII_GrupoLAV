package infnet;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Menu 
{
//-------------------------Metodo Chamar Menu--------------------------------------------------------------------------
	public static void chamarMenu() 
	throws IOException
	{
		JOptionPane.showMessageDialog(null,"Controle de Estoque");
		Object[] itens = {"Carro", "Moto"};
	  Object selectedValue = JOptionPane.showInputDialog(null, "Qual tipo de automovel voce deseja?", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);
	    
//-------------------------Opcao Carro---------------------------------------------------------------------------------
		if (selectedValue == itens[0])
		Menu.chamarMenuCarro();
//-------------------------Opcao Moto----------------------------------------------------------------------------------
		if (selectedValue == itens[1])
			Menu.chamarMenuMoto();		
	}
//-------------------------Metodo Chamar Menu Carro-------------------------------------------------------------------------------	
	public static void chamarMenuCarro()
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
				Loja.adicionarCarro();
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Pesquisar Carro");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Buscar Carro pelo Chassi");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Listar Estoque de Carros");
				break;
			case 5:
				Menu.chamarMenu();
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Fechando");
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opção valida.");
				Menu.chamarMenuCarro();
				break;
		}
	}
//-------------------------Metodo Chamar Menu Moto--------------------------------------------------------------------------------
	public static void chamarMenuMoto()
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
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Pesquisar Moto");
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Buscar Moto pelo Chassi");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Listar Estoque de Motos");
				break;
			case 5:
				Menu.chamarMenu();
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Fechando");
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opção valida.");
				Menu.chamarMenuMoto();
				break;
		}
	}
}

