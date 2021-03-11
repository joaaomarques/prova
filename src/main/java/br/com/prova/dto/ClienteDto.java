package br.com.prova.dto;

import br.com.prova.model.Cliente;
import br.com.prova.model.Endereco;

public class ClienteDto {
	
	private Long id;

	private String nome;

	private Integer idade;

	private String cep;

	private String rua;

	private String bairro;
	
	
	
	
	
	public ClienteDto(Long id, String nome, Integer idade, String cep, String rua, String bairro) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
	}

	public ClienteDto() {
	}

	public Cliente toCliente() {
		 return new Cliente(this.id, this.nome, this.idade, new Endereco(cep, rua, bairro));
		
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
