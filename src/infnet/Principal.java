package infnet;

import infnet.loja.Loja;
import infnet.loja.enums.*;
import infnet.loja.veiculos.*;

public class Principal 
{

	public static void main(String[] args) 
	{
//-------------------------Adicionando Loja para Teste---------------------------------------------------------------------------------------------
		Loja loja1 = new Loja("Lojas de Teste", "Rua Qualquer, nº 2");
		System.out.println("Loja: " + loja1.getNome() + "\n End: " + loja1.getEndereco() + "\n" );		
//-------------------------Adicionando Carros para Teste---------------------------------------------------------------------------------------------		
		Carro carro1 = new Carro("EOF31231", Montadora.CHEVROLET, ModeloCarro.CELTA, TipoCarro.SEDAN, Cor.AMARELO, 1.6f, Cambio.AUTO, 25000.350f);
		Carro carro2 = new Carro("AAJ13123", Montadora.FIAT, ModeloCarro.GOL, TipoCarro.SUV, Cor.BRANCO, 1.6f, Cambio.SEMI, 40200.00f);
		loja1.adicionarCarro(carro1);
		loja1.adicionarCarro(carro2);
		loja1.listarEstoqueDeCarros();
		System.out.println();
//-------------------------Adicionando Motos para Teste----------------------------------------------------------------------------------------------		
		Motocicleta moto1= new Motocicleta ("JDF96598", Montadora.HONDA, ModeloMoto.CBR, TipoMoto.ESPORTIVO, Cor.AZUL, 100, 150, 15000.350f);
		Motocicleta moto2= new Motocicleta ("PGI94652", Montadora.KAWASAKI, ModeloMoto.NINJA, TipoMoto.ESPORTIVO, Cor.BRANCO, 120, 180, 25000.150f);
		loja1.adicionarMotocicletas(moto1);
		loja1.adicionarMotocicletas(moto2);
		loja1.listarEstoqueDeMotocicletas();
//-------------------------Fim do Main---------------------------------------------------------------------------------------------------------------		
	}
}
