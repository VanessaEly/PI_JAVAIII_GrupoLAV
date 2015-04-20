package infnet.loja.enums;

public enum Cor {
	PRETO(1),
	BRANCO(2),
	AZUL(3),
	VERDE(4),
	ROSA(5),
	AMARELO(6);
	
	private int indice;

	private Cor(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
}
