package infnet;

import infnet.loja.Loja;
import java.io.IOException;

/**
 * Classe Principal eh a classe executavel que mostra o funcionamento do programa, instancia classes e demonstra seus metodos
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
 */
public class Principal 
{
	public static String nomearq = null;

	/**
	 * Metodo main eh onde a execucao do programa se torna possivel
	 * @param args argumentos do metodo main
	 * @throws IOException Excecoes de entrada e saida e seus tratamentos
	 */
	public static void main(String[] args) throws IOException 
	{
		Loja.salvarEstoque();
	}	
}
