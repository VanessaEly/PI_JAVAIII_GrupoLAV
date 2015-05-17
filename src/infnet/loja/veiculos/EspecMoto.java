package infnet.loja.veiculos;

import java.io.IOException;
import javax.swing.JOptionPane;
import infnet.loja.Loja;
import infnet.loja.enums.ModeloMoto;
import infnet.loja.enums.TipoMoto;

/**
 * Classe EspecMoto possui as especificacoes de moto
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
 */
public class EspecMoto {
	public Motocicleta criaMoto(Loja loja) throws IOException
	{
		Motocicleta moto = new Motocicleta(EspecVeiculo.addChassi(loja), EspecVeiculo.addMontadora(), addModeloMoto(), addTipoMoto(), EspecVeiculo.addCor(), 
				addCilindrada(), addCapacidadeDoTanque(), EspecVeiculo.addPreco());
		return moto;
	}

	/**
	 * metodo addModeloMoto retorna o modelo da moto inputado pelo usuario
	 * @return modelo modelo da moto
	 */
	public static  ModeloMoto addModeloMoto(){
		ModeloMoto modelo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo:\n1 - CBR\n2 - NINJA\n3 - CB_HORNET"));
		while (aux <= 0 || aux >= 4)
			aux = Integer.parseInt(JOptionPane.showInputDialog("Valor Invalido. Digite numero do modelo:\n1 - CBR\n2 - NINJA\n3 - CB_HORNET"));
		for (ModeloMoto m: ModeloMoto.values())
		{
			if (m.getIndice() == (aux-1))
				modelo = m;
		}
		return modelo;
	}

	/**
	 * metodo addTipoMoto retorna o tipo da moto inputado pelo usuario
	 * @return tipo tipo da moto
	 */
	public static TipoMoto addTipoMoto() {
		TipoMoto tipo = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:\n1 - CHOPPER\n2 - SCOOTER\n3 - ESPORTIVO"));
		while (aux <= 0 || aux >=4)
			aux = Integer.parseInt(JOptionPane.showInputDialog("Valor Invalido. Digite numero do tipo:\n1 - CHOPPER\n2 - SCOOTER\n3 - ESPORTIVO"));
		for (TipoMoto m: TipoMoto.values())
		{
			if (m.getIndice() == (aux-1))
				tipo = m;
		}
		return tipo;
	}

	/**
	 * metodo addCilindrada retorna as cilindradas da moto inputadas pelo usuario
	 * @return cilindrada cilindrada da moto
	 */
	public static int addCilindrada() {
		int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cilindradas:"));
		return cilindrada;
	}

	/**
	 * metodo addCapacidadeDoTanque retorna a capacidade do tanque da moto inputado pelo usuario
	 * @return capacidadeDoTanque capacidade do tanque da moto
	 */
	public static int addCapacidadeDoTanque() {
		int capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do Tanque:"));
		return capacidadeDoTanque;
	}
}
