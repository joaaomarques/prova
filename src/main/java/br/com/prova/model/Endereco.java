package br.com.prova.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {
	
	@NotNull
	private String cep;
	
	@NotNull
	private String rua;
	
	@NotNull
	private String bairro;
	
	
	
	
	public Endereco(String cep, String rua, String bairro) {
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
	}
	
	public Endereco() {}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
