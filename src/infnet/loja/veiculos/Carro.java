package infnet.loja.veiculos;

import infnet.loja.enums.*;

public class Carro 
{
        /************************************** /
	/* Classe Motocicleta define uma moto** / 
	/*@author AntÃ´nio, Leandro e Vanessa** /
	/***************************************/
//-------------------------DECLARAÇÃO DE VARIAVEIS--------------------------------------------------------------------
	String chassi;
	Montadora montadora;
	ModeloCarro modelo;
	TipoCarro tipo; 
	Cor cor;
	float motorizacao;
	Cambio cambio;
	float preco;
//-------------------------ADICIONANDO METODOS CONSTRUTORES-----------------------------------------------------------
	public Carro(String chassi, Montadora montadora, ModeloCarro modelo, TipoCarro tipo, Cor cor, 
		     float motoricao, float preco) 
	{
		this.chassi      = chassi;
		this.montadora   = montadora;	
		this.modelo      = modelo;
		this.tipo        = tipo;
		this.cor         = cor;
		this.motorizacao = motorizacao;
		this.preco       = preco;
	}
//-------------------------EQUALS-------------------------------------------------------------------------------------
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (cambio != other.cambio)
			return false;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (cor != other.cor)
			return false;
		if (modelo != other.modelo)
			return false;
		if (montadora != other.montadora)
			return false;
		if (Float.floatToIntBits(motorizacao) != Float
				.floatToIntBits(other.motorizacao))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
//-------------------------GETTERS AND SETTERS------------------------------------------------------------------------
	public String      getChassi() {
		return chassi;
	}
	public void        setChassi(String chassi) {
		this.chassi = chassi;
	}
	public Montadora   getMontadora() {
		return montadora;
	}
	public void        setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public ModeloCarro getModelo() {
		return modelo;
	}
	public void        setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}
	public TipoCarro   getTipo() {
		return tipo;
	}
	public void        setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}
	public Cor         getCor() {
		return cor;
	}
	public void        setCor(Cor cor) {
		this.cor = cor;
	}
	public float       getMotorizacao() {
		return motorizacao;
	}
	public void        setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}
	public Cambio      getCambio() {
		return cambio;
	}
	public void        setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public float       getPreco() {
		return preco;
	}
	public void        setPreco(float preco) {
		this.preco = preco;
	}
}
