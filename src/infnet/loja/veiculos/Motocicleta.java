package infnet.loja.veiculos;

import infnet.loja.enums.*;

public class Motocicleta 
{
        /************************************** /
	/* Classe Motocicleta define uma moto** / 
	/* @author Antonio, Leandro e Vanessa** /
	/***************************************/
//-------------------------DECLARAÇÃO DE VARIAVEIS--------------------------------------------------------------------
	private String chassi;
	private Montadora montadora;
	private ModeloMoto modelo;
	private TipoMoto tipo;
	private Cor cor;
	private int cilindrada;
	private int capacidadeDoTanque; 
	private float preco;
//-------------------------ADICIONANDO METODOS CONSTRUTORES-----------------------------------------------------------
	public Motocicleta(String chassi, Montadora montadora, ModeloMoto modelo, TipoMoto tipo, Cor cor, 
		           int cilindrada, int capacidadeDoTanque, float preco) 
	{
		this.chassi      	= chassi;
		this.montadora   	= montadora;	
		this.modelo     	= modelo;
		this.tipo        	= tipo;
		this.cor                = cor;
		this.cilindrada         = cilindrada;
		this.capacidadeDoTanque = capacidadeDoTanque;
		this.preco              = preco;
	}
//-------------------------EQUALS-------------------------------------------------------------------------------------
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motocicleta other = (Motocicleta) obj;
		if (capacidadeDoTanque != other.capacidadeDoTanque)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (cilindrada != other.cilindrada)
			return false;
		if (cor != other.cor)
			return false;
		if (modelo != other.modelo)
			return false;
		if (montadora != other.montadora)
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
//-------------------------GETTERS AND SETTERS------------------------------------------------------------------------
	public String     getChassi() {
		return chassi;
	}
	public void       setChassi(String chassi) {
		this.chassi = chassi;
	}
	public Montadora  getMontadora() {
		return montadora;
	}
	public void       setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public ModeloMoto getModelo() {
		return modelo;
	}
	public void       setModelo(ModeloMoto modelo) {
		this.modelo = modelo;
	}
	public TipoMoto   getTipo() {
		return tipo;
	}
	public void       setTipo(TipoMoto tipo) {
		this.tipo = tipo;
	}
	public Cor        getCor() {
		return cor;
	}
	public void       setCor(Cor cor) {
		this.cor = cor;
	}
	public int        getCilindrada() {
		return cilindrada;
	}
	public void       setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public int        getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}
	public void       setCapacidadeDoTanque(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}
	public float      getPreco() {
		return preco;
	}
	public void       setPreco(float preco) {
		this.preco = preco;
	}
	public String toString() {
		return   "Chassi = " + chassi 			    + " Montadora = " + montadora
				+ " Modelo = " + modelo 			+ " Tipo = "      + tipo 
				+ " Cor = "    + cor				+ " Cilindrada = " + cilindrada 
				+ " Tanque = " + capacidadeDoTanque + " Preco = " + preco + ".";
	}
}
