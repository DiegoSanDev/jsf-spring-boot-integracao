package br.com.avanade.jsfspringboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpfOuCnpj;
	private String email;

	public Cliente() {
	}

	@Column(name = "nome", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cpf_ou_cnpj", length = 30)
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
