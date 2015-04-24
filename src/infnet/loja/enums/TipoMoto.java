package infnet.loja.enums;

/**
 * Tipos que podem ser definidos para motos
 * CHOPPER
 * SCOOTER
 * ESPORTIVO
 */
public enum TipoMoto 
{
	CHOPPER (1),
	SCOOTER (2),
	ESPORTIVO (3);
	
	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice
	 */
	private TipoMoto(int indice) 
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
