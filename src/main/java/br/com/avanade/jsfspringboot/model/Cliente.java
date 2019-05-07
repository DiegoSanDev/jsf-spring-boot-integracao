package br.com.avanade.jsfspringboot.model;

import java.io.Serializable;

public class Cliente extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpfOuCnpj;
	private String email;

	public Cliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
