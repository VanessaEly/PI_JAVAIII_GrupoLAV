package infnet.loja.enums;

/**
 * Modelos que podem ser definidos para carros
 * FOX
 * GOL
 * CELTA
 */
public enum ModeloCarro 
{
	FOX(1),
	GOL(2),
	CELTA(3);
	
	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice
	 */
	private ModeloCarro(int indice) 
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
