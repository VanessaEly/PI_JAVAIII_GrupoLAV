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
	PRETO(1),
	BRANCO(2),
	AZUL(3),
	VERDE(4),
	ROSA(5),
	AMARELO(6);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice
	 */
	private Cor(int indice) {
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
