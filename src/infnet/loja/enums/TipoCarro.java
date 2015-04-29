package infnet.loja.enums;

/**
 * Tipos que podem ser definidos para carros
 * SEDAN
 * HATCH
 * SUV
 */
public enum TipoCarro 
{
	SEDAN (0),
	HATCH (1),
	SUV (2);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private TipoCarro(int indice)
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
