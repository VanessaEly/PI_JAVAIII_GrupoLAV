package infnet.loja.enums;

/**
 * Modelos que podem ser definidos para motos
 * CBR
 * NINJA
 * CB HORNET
 */
public enum ModeloMoto 
{
	CBR(1),
	NINJA(2),
	CB_HORNET(3);
	
	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice
	 */
	private ModeloMoto(int indice) 
	{
		this.indice = indice;
	}

	/**
	 * Retorna o valor do indice
	 * @return indice
	 */
	public int getIndice() 
	{
		return indice;
	}
	
}
