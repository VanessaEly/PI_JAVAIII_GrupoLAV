package infnet.loja;

import infnet.loja.veiculos.*;

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
	ArrayList <Carro> estoqueDeCarros = new ArrayList <Carro>();
	ArrayList <Motocicleta> estoqueDeMotocicletas;

	//-------------------------ADICIONANDO METODO CONSTRUTOR-----------------------------------------------------------
	public Loja(String nome, String endereco) 
	{
		this.endereco              = endereco;
		this.nome                  = nome;
	}
	
	//-------------------------METODOS--------------------------------------------------------------------------------
	
	//-----------ADICIONARCARRO();  Adiciona um carro ao inventario, recebendo os dados do usuario--------------------
	public void adicionarCarro(Carro car)
	{
		estoqueDeCarros.add(car);
	}
	
	//----------------------listarEstoquedeCarros()--------------------------------------------------------------------
		public void listarEstoqueDeCarros ()
		{
			int i = 1;
			for (Carro c: estoqueDeCarros)
			{
				System.out.println("Carro " + i);
				System.out.println(c);
				i++;
			}
		}

	
	//pesquisarCarro(...);  Retorna um carro, utilizando os atributos passados, caso exista no inventário. 
	//buscarCarro(Chassi); Retorna um carro, caso exista no estoque um com o Chassi indicado. 
	//removerCarro();  Remove um carro ao inventário, recebendo os dados do usuário
	//adicionarMoto(); Adiciona uma moto ao inventário, recebendo os dados do usuário
	//pesquisarMoto(...); Retorna um carro, utilizando os atributos passados, caso exista no inventário. 
	//buscarMoto(Chassi); Retorna uma moto, caso exista no estoque uma com o Chassi indicado. 
	//removerMoto();  Remove um carro ao inventário, recebendo os dados do usuário

	//listarEstoquedeMotos() 
	
	//-------------------------EQUALS-------------------------------------------------------------------------------------
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (endereco == null) 
		{
			if (other.endereco != null)
				return false;
		} 
		else if (!endereco.equals(other.endereco))
			return false;
		if (estoqueDeCarros == null) 
		{
			if (other.estoqueDeCarros != null)
				return false;
		} 
		else if (!estoqueDeCarros.equals(other.estoqueDeCarros))
			return false;
		if (estoqueDeMotocicletas == null) 
		{
			if (other.estoqueDeMotocicletas != null)
				return false;
		} 
		else if (!estoqueDeMotocicletas.equals(other.estoqueDeMotocicletas))
			return false;
		if (nome == null) 
		{
			if (other.nome != null)
				return false;
		} 
		else if (!nome.equals(other.nome))
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
	public void                   setEstoqueDeMotocicletas(ArrayList<Motocicleta> estoqueDeMotocicletas) {
		this.estoqueDeMotocicletas = estoqueDeMotocicletas;
	}


}
