package infnet;

import infnet.loja.Loja;
import infnet.loja.enums.Cambio;
import infnet.loja.enums.Cor;
import infnet.loja.enums.ModeloCarro;
import infnet.loja.enums.Montadora;
import infnet.loja.enums.TipoCarro;
import infnet.loja.veiculos.Carro;

public class Principal 
{

	public static void main(String[] args) 
	{
		Loja loja1 = new Loja("loja1", "Rua a, nº 2");
		Carro carro1 = new Carro("EOF31231", Montadora.CHEVROLET, ModeloCarro.CELTA, TipoCarro.SEDAN, Cor.AMARELO, 1.6f, Cambio.AUTO, 25000.350f);
		Carro carro2 = new Carro("AAJ13123", Montadora.FIAT, ModeloCarro.GOL, TipoCarro.SUV, Cor.BRANCO, 1.6f, Cambio.SEMI, 40200.00f);
		loja1.adicionarCarro(carro1);
		loja1.adicionarCarro(carro2);
		loja1.listarEstoqueDeCarros();
	}

}
