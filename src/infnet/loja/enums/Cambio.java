package infnet.loja.enums;

/**
 * Cambios que podem ser definidos para carros
 * MANUAL
 * SEMI
 * AUTO
 */
public enum Cambio {
	MANUAL(1),
	SEMI (2),
	AUTO (3);
	
	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice
	 */
	private Cambio(int indice) {
		this.indice = indice;
	}

	/**
	 * Retorna o valor do indice
	 * @return indice
	 */
	public int getIndice() {
		return indice;
	}
	
}
