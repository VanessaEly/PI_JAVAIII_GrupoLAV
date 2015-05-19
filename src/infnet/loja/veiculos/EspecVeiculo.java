package infnet.loja.veiculos;

import java.io.IOException;
import infnet.Menu;
import infnet.loja.Loja;
import infnet.loja.enums.Cor;
import infnet.loja.enums.Montadora;
import javax.swing.JOptionPane;

/**
 * Classe EspecVeiculo possui as especificacoes de veiculo
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 2.0
 * @since 12-05-2015
 */
public class EspecVeiculo {

	/**
	 * metodo addChassi retorna o chassi do veiculo inputado pelo usuario
	 * @param loja loja a qual o carro será adicionado
	 * @return chassi chassi do veiculo
	 * @throws IOException excecao de entrada e saida
	 */
	public static String addChassi(Loja loja) throws IOException {
		String chassi = (JOptionPane.showInputDialog("Digite o chassi: "));
		if (chassi == null)
		{
			JOptionPane.showMessageDialog(null, "Voltando para o Menu Principal.");
			Menu.chamarMenu(loja);
		}
		if (chassi.isEmpty() || chassi.equals("0"))
			chassi = null;
		return chassi;
	}

	/**
	 * metodo addMontadora retorna a montadora do veiculo inputado pelo usuario
	 * @return montadora montadora do veiculo
	 */
	public static Montadora addMontadora(){
		Montadora montadora = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora:\n1 - VOLKSWAGEN\n2 - FORD\n3 - CHEVROLET\n4 - FIAT\n5 - HONDA\n6 - SUZUKI\n7 - YAMAHA\n8 - KAWASAKI"));
		if (aux <= 0 || aux >= 9)
			montadora = null;
		else
		{
			for (Montadora m: Montadora.values())
			{
				if (m.getIndice() == aux)
					montadora = m;
			}
		}
		return montadora;
	}

	/**
	 * metodo addCor retorna a cor do veiculo inputado pelo usuario
	 * @return cor cor do veiculo
	 */
	public static Cor addCor() {
		Cor cor = null;
		int aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:\n1 - PRETO\n2 - BRANCO\n3 - AZUL\n4 - VERDE\n5 - ROSA\n6 - AMARELO"));
		if (aux <= 0 || aux >= 7)
			cor = null;
		else
		{
			for (Cor m: Cor.values())
			{
				if (m.getIndice() == (aux-1))
					cor = m;
			}
		}
		return cor;
	}

	/**
	 * metodo addPreco retorna o preco do veiculo inputado pelo usuario
	 * @return preco preco do carro
	 */
	public static float addPreco(){
		float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco:"));
		return preco;
	}
}