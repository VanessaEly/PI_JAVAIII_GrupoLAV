package infnet.loja.enums;

/**
 * Montadoras que podem ser definidas para carros (1-4) e motos (5-8)
 * VOLKSWAGEN
 * FORD
 * CHEVROLET
 * HONDA
 * FIAT
 * SUZUKI
 * YAMAHA
 * KAWASAKI
 */
public enum Montadora 
{
	VOLKSWAGEN(0), 
	FORD(1), 
	CHEVROLET(2), 
	FIAT(3), 
	HONDA(4), 
	SUZUKI(5), 
	YAMAHA(6),
	KAWASAKI(7);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Montadora(int indice) 
	{
		this.indice = indice ;
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
