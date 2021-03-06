package infnet.loja.enums;

/**
 * Cambios que podem ser definidos para carros
 * MANUAL
 * SEMI
 * AUTO
 */
public enum Cambio {
	MANUAL(0),
	SEMI (1),
	AUTO (2);

	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Cambio(int indice) {
		this.indice = indice;
	}

	/**
	 * Retorna o valor do indice
	 * @return indice indice do enum
	 */
	public int getIndice() {
		return indice;
	}

}
