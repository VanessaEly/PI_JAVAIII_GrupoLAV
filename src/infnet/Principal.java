package infnet;

import infnet.loja.Loja;

import java.io.IOException;

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
	 * @throws IOException 
	 */
	public static void main(String[] args)
	throws IOException 
	{

		Loja loja1 = new Loja("Loja1", "Rua Tal n17");
		Menu.chamarMenu(loja1);
	}
}
