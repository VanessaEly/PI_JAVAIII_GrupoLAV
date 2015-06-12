package infnet.loja.enums;

/**
 * Modelos que podem ser definidos para carros
 * FOX
 * GOL
 * CELTA
 */
public enum Modelo
{
	FOX(0),
	GOL(1),
	CELTA(2),
	CBR(3),
	NINJA(4),
	CB_HORNET(5);

	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Modelo(int indice) 
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
