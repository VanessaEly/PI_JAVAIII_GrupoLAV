package infnet.loja.enums;
/**
 * Cores que podem ser definidas para carros e motos
 * PRETO
 * BRANCO
 * AZUL
 * VERDE
 * ROSA
 * AMARELO
 */
public enum Cor {
	PRETO(0),
	BRANCO(1),
	AZUL(2),
	VERDE(3),
	ROSA(4),
	AMARELO(5);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Cor(int indice) {
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
