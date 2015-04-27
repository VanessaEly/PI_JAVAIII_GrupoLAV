package infnet.loja.enums;

/**
 * Tipos que podem ser definidos para motos
 * CHOPPER
 * SCOOTER
 * ESPORTIVO
 */
public enum TipoMoto 
{
	CHOPPER (0),
	SCOOTER (1),
	ESPORTIVO (2);
	
	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private TipoMoto(int indice) 
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
