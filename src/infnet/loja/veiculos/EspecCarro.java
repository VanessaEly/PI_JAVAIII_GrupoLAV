package infnet.loja.veiculos;

import infnet.loja.Loja;
import infnet.loja.enums.Cambio;
import infnet.loja.enums.ModeloCarro;
import infnet.loja.enums.TipoCarro;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Classe EspecCarro possui as especificacoes de carro
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
 */
public class EspecCarro {

	/**
	 * metido criaCarro cria um novo carro
	 * @param loja loja onde o carro sera criado
	 * @return carro carro criado
	 * @throws IOException para tratamento de excecao
	 */
	public static Carro criaCarro(Loja loja) throws IOException
	{
		Carro carro = new Carro(EspecVeiculo.addChassi(loja), EspecVeiculo.addMontadora(), addModeloCarro(), addTipoCarro(), 
				EspecVeiculo.addCor(), addMotorizacao(), addCambio(), EspecVeiculo.addPreco());
		return carro;
	}

	/**
	 * metodo addModeloCarro retorna o modelo do carro inputado pelo usuario
	 * @return modelo modelo do carro
	 */
	public static ModeloCarro addModeloCarro() {
		ModeloCarro modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - FOX\n2 - GOL\n3 - CELTA"));
		if (aux <= 0 || aux >=4)
			modelo = null;
		else
		{
			for (ModeloCarro m: ModeloCarro.values())
			{
				if (m.getIndice() == (aux-1))
					modelo = m;
			}
		}
		return modelo;
	}

	/**
	 * metodo addTipoCarro retorna o tipo de carro inputado pelo usuario
	 * @return tipo tipo do carro
	 */
	public static TipoCarro addTipoCarro() {
		TipoCarro tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - SEDAN\n2 - HATCH\n3 - SUV"));
		if (aux <= 0 || aux >=4)
			tipo = null;
		else
		{
			for (TipoCarro m: TipoCarro.values())
			{
				if (m.getIndice() == (aux-1))
					tipo = m;
			}
		}
		return tipo;
	}

	/**
	 * metodo addMotorizacao retorna a motorizacao do carro inputado pelo usuario
	 * @return motorizacao motorizacao do carro
	 */
	public static float addMotorizacao(){
		float motorizacao = Float.parseFloat(JOptionPane.showInputDialog("Digite numero do motor:"));
		return motorizacao;
	}

	/**
	 * metodo addCambio retorna o cambio do carro inputado pelo usuario
	 * @return cambio cambio do carro
	 */
	public static Cambio addCambio() {
		Cambio cambio = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:\n1 - MANUAL\n2 - SEMI\n3 - AUTO"));
		if (aux <= 0 || aux >=4)
			cambio = null;
		else
		{
			for (Cambio m: Cambio.values())
			{
				if (m.getIndice() == (aux-1))
					cambio = m;
			}
		}
		return cambio;
	}
}
