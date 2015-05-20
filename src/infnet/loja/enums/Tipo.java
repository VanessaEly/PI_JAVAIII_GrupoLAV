package infnet.loja.enums;

/**
 * Tipos que podem ser definidos para carros
 * SEDAN
 * HATCH
 * SUV
 */
public enum Tipo
{
	SEDAN (0),
	HATCH (1),
	SUV (2),
	CHOPPER (3),
	SCOOTER (4),
	ESPORTIVO (5);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Tipo(int indice)
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
