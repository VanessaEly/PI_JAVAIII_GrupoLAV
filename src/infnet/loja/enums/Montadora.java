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
	VOLKSWAGEN(1), 
	FORD(2), 
	CHEVROLET(3), 
	FIAT(4), 
	HONDA(5), 
	SUZUKI(6), 
	YAMAHA(7),
	KAWASAKI(8);

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
