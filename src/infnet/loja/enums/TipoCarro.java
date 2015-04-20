package infnet.loja.enums;

public enum TipoCarro 
{
	SEDAN (1),
	HATCH (2),
	SUV (3);
	
	private int indice;

	private TipoCarro(int indice) 
	
		this.indice = indice;
	}

	public int getIndice() 
	{
		return indice;
	}

	public void setIndice(int indice) 
	
		this.indice = indice;
	}
}
