package infnet;

import infnet.loja.Loja;

/**
 * Classe Principal eh a classe executavel que mostra o funcionamento do programa, instancia classes e demonstra seus metodos
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 1.0
 * @since 15-04-2015
 */
public class Principal 
{
	/**
	 * Metodo main eh onde a execucao do programa se torna possivel
	 * @param args argumentos do metodo main
	 */
	public static void main(String[] args) 
	{
		Menu.chamarMenu();

		/**
		//-------------------------Criando nova Loja---------------------------------------------------------------------------------------------------------
		Loja loja1 = new Loja("Lojas de Teste", "Rua Qualquer, num 2");
		System.out.println("Loja: " + loja1.getNome() + "\n End: " + loja1.getEndereco() + "\n" );		
		//-------------------------Adicionando Carros para Teste---------------------------------------------------------------------------------------------		
		loja1.adicionarCarro();
		loja1.listarEstoqueDeCarros();
		System.out.println();
		//-------------------------Adicionando Motos para Teste----------------------------------------------------------------------------------------------		
		loja1.adicionarMoto();
		loja1.listarEstoqueDeMotocicletas();
		//-------------------------Fim do Main---------------------------------------------------------------------------------------------------------------		
		*/
	}
}
