package infnet.loja;

import infnet.loja.veiculos.*;
import infnet.loja.enums.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Loja 
{
	/******************************************* /
	/** Classe Loja define loja e seu estoque ** / 
	/** @author Antonio, Leandro e Vanessa    ** /
	/********************************************/

	//-------------------------DECLARACAO DE VARIAVEIS--------------------------------------------------------------------
	String endereco;
	String nome;
	ArrayList <Carro	estoqueDeCarros       = new ArrayList <Carro>();
	ArrayList <Motocicleta> estoqueDeMotocicletas = new ArrayList <Motocicleta>();;

	//-------------------------ADICIONANDO METODO CONSTRUTOR-----------------------------------------------------------
	public Loja(String nome, String endereco) {
		this.endereco              = endereco;
		this.nome                  = nome;
	}
	
	//-------------------------METODOS--------------------------------------------------------------------------------
	
	//-------------------------ADICIONAR CARRO---------------------------------------------------------------------------
	public void adicionarCarro()
	{
		Montadora   _montadora   = null;
		ModeloCarro _modelo      = null;
		TipoCarro   _tipo 	     = null;
		Cambio 		_cambio      = null;
		Cor 		_cor 	     = null;
		float 		_motorizacao = 0; 
		String 		_chassi      = "";
		float 		_preco 		 = 0;
		int aux;
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))");
			aux = scan.nextInt();
			while (aux <= 0 || aux >=5)
			{
				System.out.println("Valor Inválido. Insira outro valor:");
				aux = scan.nextInt();
			}
			for (Montadora m: Montadora.values())
			{
				if (m.getIndice() == aux)
					_montadora = m;
			}
			
		System.out.println("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Inválido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (ModeloCarro m: ModeloCarro.values())
		{
			if (m.getIndice() == aux)
				_modelo = m;
		}
		System.out.println("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Inválido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (TipoCarro m: TipoCarro.values())
		{
			if (m.getIndice() == aux)
				_tipo = m;
		}
		System.out.println("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=4)
		{
			System.out.println("Valor Inválido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Cambio m: Cambio.values())
		{
			if (m.getIndice() == aux)
				_cambio = m;
		}
		System.out.println("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
		aux = scan.nextInt();
		while (aux <= 0 || aux >=7)
		{
			System.out.println("Valor Inválido. Insira outro valor:");
			aux = scan.nextInt();
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == aux)
				_cor = m;
		}
		System.out.println("Digite numero do motor:		(1,0/1,4/1,6/1,8/2,0)");
			_motorizacao = scan.nextFloat();
		System.out.println("Digite o chassi");
			_chassi = scan.next();
		System.out.println("Digite o preco do carro");
			_preco = scan.nextFloat();
				
		Carro carroaux = new Carro(_chassi, _montadora, _modelo, _tipo, _cor, _motorizacao, _cambio, _preco);
		estoqueDeCarros.add(carroaux);
		scan.close();
	}
	
//-------------------------ADICIONAR MOTO----------------------------------------------------------------------------
	public void adicionarMoto(Motocicleta moto)
	{
		Montadora   _montadora          = null;
		ModeloMoto  _modelo             = null;
		TipoMoto    _tipo 	    	    = null;
		int 		_capacidadeDoTanque = 0;
		Cor 		_cor 	            = null;
		int 		_cilindradas 		= 0; 
		String 		_chassi      		= "";
		float 		_preco 		 		= 0;
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))");
			_montadora = Montadora.values()[scan.nextInt()];
		System.out.println("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))");
			_modelo = ModeloMoto.values()[scan.nextInt()];
		System.out.println("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))");
			_tipo = TipoMoto.values()[scan.nextInt()];
		System.out.println("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))");
			_cor = Cor.values()[scan.nextInt()];
		System.out.println("Digite numero de cilindradas:	(50cc, 60cc, 100cc, 120cc, 150cc)");
			_cilindradas = scan.nextInt();
		System.out.println("Digite a capacidade do Tanque:");
			_capacidadeDoTanque = scan.nextInt();
		System.out.println("Digite o chassi");
			_chassi = scan.next();
		System.out.println("Digite o preço do carro");
			_preco = scan.nextFloat();
				
		Motocicleta motoaux = new Motocicleta (_chassi, _montadora, _modelo, _tipo, _cor, _cilindradas, _capacidadeDoTanque, _preco);
		estoqueDeMotocicletas.add(motoaux);
	}
	
	//----------------------listarEstoquedeCarros()--------------------------------------------------------------------
	public void listarEstoqueDeCarros (){
			int i = 1;
			for (Carro c: estoqueDeCarros)
			{
				System.out.println("Carro " + i);
				System.out.println(c);
				i++;
			}
		}
		
	//----------------------listarEstoquedeMotos()--------------------------------------------------------------------
	public void listarEstoqueDeMotocicletas (){
			int i = 1;
			for (Motocicleta d: estoqueDeMotocicletas)
			{
				System.out.println("Moto " + i);
				System.out.println(d);
				i++;
			}
		}

	//------------removerCarro();  Remove um carro do inventario, recebendo os dados do usuario------------------------
	public void removerCarro(Carro car){
		estoqueDeCarros.remove(car);
	}
	
	//------------removerMotocileta();  Remove uma moto do inventario, recebendo os dados do usuario------------------------
	public void removerMotocicleta(Motocicleta moto)	{
		estoqueDeMotocicletas.remove(moto);
	}
	
	//------------To Do--------------------------------------------------------------------------------------------
	
	//pesquisarCarro(...);  Retorna um carro, utilizando os atributos passados, caso exista no inventário. 
	//buscarCarro(Chassi); Retorna um carro, caso exista no estoque um com o Chassi indicado. 
	
	//adicionarMoto(); Adiciona uma moto ao inventário, recebendo os dados do usuário
	//pesquisarMoto(...); Retorna um carro, utilizando os atributos passados, caso exista no inventário. 
	//buscarMoto(Chassi); Retorna uma moto, caso exista no estoque uma com o Chassi indicado. 
	//removerMoto();  Remove um carro ao inventário, recebendo os dados do usuário

	//listarEstoquedeMotos() 
	
	//-------------------------EQUALS-------------------------------------------------------------------------------------
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estoqueDeCarros == null) {
			if (other.estoqueDeCarros != null)
				return false;
		} else if (!estoqueDeCarros.equals(other.estoqueDeCarros))
			return false;
		if (estoqueDeMotocicletas == null) {
			if (other.estoqueDeMotocicletas != null)
				return false;
		} else if (!estoqueDeMotocicletas.equals(other.estoqueDeMotocicletas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	//-------------------------GETTERS AND SETTERS------------------------------------------------------------------------
	public String                 getNome() {
		return nome;
	}
	public void                   setNome(String nome) {
		this.nome = nome;
	}
	public String                 getEndereco() {
		return endereco;
	}
	public void                   setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Carro>       getEstoqueDeCarros() {
		return estoqueDeCarros;
	}
	public void                   setEstoqueDeCarros(ArrayList<Carro> estoqueDeCarros) {
		this.estoqueDeCarros = estoqueDeCarros;
	}
	public ArrayList<Motocicleta> getEstoqueDeMotocicletas() {
		return estoqueDeMotocicletas;
	}
	public void 		      setEstoqueDeMotocicletas(ArrayList<Motocicleta> estoqueDeMotocicletas) {
		this.estoqueDeMotocicletas = estoqueDeMotocicletas;
	}


}
