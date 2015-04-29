package infnet.loja.enums;

/**
 * Modelos que podem ser definidos para motos
 * CBR
 * NINJA
 * CB HORNET
 */
public enum ModeloMoto 
{
	CBR(0),
	NINJA(1),
	CB_HORNET(2);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private ModeloMoto(int indice) 
	{
		this.indice = indice;
	}

	/**
	 * Retorna o valor do indice
	 * @return indice indice do enum
	 */
	public int getIndice() 
	{
		return indice;
	}

}
