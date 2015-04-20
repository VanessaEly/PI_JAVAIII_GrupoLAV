package infnet.loja.enums;

public enum Montadora 
{
	VOLKSWAGEN(1), 
	FORD(2), 
	CHEVROLET(3), 
	HONDA(4), 
	FIAT(5), 
	SUZUKI(6), 
	YAMAHA(7),
	KAWASAKI(8);

	private int indice;

	private Montadora(int indice) 
	{
		this.setIndice(indice);
	}
	
	public int getIndice() 
	{
		return indice;
	}

	public void setIndice(int indice) 
	{
		this.indice = indice;
	}
}
