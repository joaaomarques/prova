package br.com.prova.dto;

import br.com.prova.model.Cliente;
import br.com.prova.model.Endereco;

public class ClienteDto {

	private String nome;

	private Integer idade;

	private String cep;

	private String rua;

	private String bairro;
	
	public Cliente toCliente() {
		 return new Cliente(null, this.nome, this.idade, new Endereco(cep, rua, bairro));
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

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
