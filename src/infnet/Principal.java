package infnet;

import infnet.loja.Loja;
import infnet.loja.enums.*;
import infnet.loja.veiculos.*;

public class Principal 
{

	public static void main(String[] args) 
	{
//-------------------------Adicionando Loja para Teste---------------------------------------------------------------------------------------------
		Loja loja1 = new Loja("Lojas de Teste", "Rua Qualquer, nÂº 2");
		System.out.println("Loja: " + loja1.getNome() + "\n End: " + loja1.getEndereco() + "\n" );		
//-------------------------Adicionando Carros para Teste---------------------------------------------------------------------------------------------		
		Carro carro1 = new Carro(null, null, null, null, null, 0, null, 0);
		loja1.adicionarCarro(carro1);
		loja1.listarEstoqueDeCarros();
		System.out.println();
//-------------------------Adicionando Motos para Teste----------------------------------------------------------------------------------------------		
		Motocicleta moto1= new Motocicleta(null, null, null, null, null, 0, 0, 0);
		loja1.adicionarMoto(moto1);
		loja1.listarEstoqueDeMotocicletas();
//-------------------------Fim do Main---------------------------------------------------------------------------------------------------------------		
	}
}
