package infnet.loja.enums;

public enum ModeloCarro {
	FOX(1),
	GOL(2),
	CELTA(3);
	
	private int indice;

	private ModeloCarro(int indice) {
		this.indice = indice;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
}
