package infnet.loja.enums;

public enum Cambio {
	MANUAL(1),
	SEMI (2),
	AUTO (3);
	
	private int indice;

	private Cambio(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
}
