package infnet.loja.enums;

public enum TipoMoto 
{
	CHOPPER (1),
	SCOOTER (2),
	ESPORTIVO (3);
	
	private int indice;

	private TipoMoto(int indice) 
	{
		this.indice = indice;
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
