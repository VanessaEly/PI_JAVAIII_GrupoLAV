package infnet.loja.enums;

public enum TipoVeiculo {
	CARRO(0),
	MOTOCICLETA (1);

	private int indice;

	/**
	 * O valor recebido por indice torna-se o indice do enum
	 * @param indice indice do enum
	 */
	private TipoVeiculo(int indice) {
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
