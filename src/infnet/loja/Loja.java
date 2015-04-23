package infnet;

import infnet.loja.Loja;

public class Principal 
{

	public static void main(String[] args) 
	{
//-------------------------Adicionando Loja para Teste---------------------------------------------------------------------------------------------
		Loja loja1 = new Loja("Lojas de Teste", "Rua Qualquer, numero 2");
		System.out.println("Loja: " + loja1.getNome() + "\n End: " + loja1.getEndereco() + "\n" );		
//-------------------------Adicionando Carros para Teste---------------------------------------------------------------------------------------------		
		loja1.adicionarCarro();
		loja1.listarEstoqueDeCarros();
		System.out.println();
//-------------------------Adicionando Motos para Teste----------------------------------------------------------------------------------------------
		loja1.adicionarMoto();
		loja1.listarEstoqueDeMotocicletas();
//-------------------------Fim do Main---------------------------------------------------------------------------------------------------------------		
	}
}
