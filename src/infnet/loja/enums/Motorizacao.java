package infnet.loja.enums;

public enum Motorizacao {
	M1p0(0),
	M1p3(1),
	M1p4(2),
	M1p5(3),
	M1p6(4),
	M1p8(5),
	M2p0(6);

	//variavel do enum
	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private Motorizacao(int indice) {
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
