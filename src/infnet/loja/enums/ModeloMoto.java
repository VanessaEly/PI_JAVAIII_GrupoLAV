package infnet.loja.enums;

public enum ModeloMoto 
{
	CBR(1),
	NINJA(2),
	CB_HORNET(3);
	
	private int indice;

	private ModeloMoto(int indice) 
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
