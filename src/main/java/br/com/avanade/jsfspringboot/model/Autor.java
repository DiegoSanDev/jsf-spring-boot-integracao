package br.com.avanade.jsfspringboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	public Autor() {
	}

	@Column(name = "nome", nullable = false, unique = true, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
