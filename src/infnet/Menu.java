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
	{
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?     \n" + 
														    	 "1 - Adicionar Carro          \n" +
																 "2 - Pesquisar Carro 		   \n" +
																 "3 - Buscar Carro pelo Chassi \n" +
																 "4 - Listar Estoque de Carros \n"));
		switch (opcao) 
		{
			case 1: 
				JOptionPane.showMessageDialog(null,"Adicionar Carro");
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
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opção valida.");
				Menu.chamarMenuCarro();
				break;
		}
	}
//-------------------------Metodo Chamar Menu Moto--------------------------------------------------------------------------------
	public static void chamarMenuMoto()
	{
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("O que voce deseja fazer?    \n" + 
														    	 "1 - Adicionar Moto          \n" +
																 "2 - Pesquisar Moto 		  \n" +
																 "3 - Buscar Moto pelo Chassi \n" +
																 "4 - Listar Estoque de Motos \n"));
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
			default:
				JOptionPane.showMessageDialog(null,"Escolha uma opção valida.");
				Menu.chamarMenuMoto();
				break;
		}
	}
}

