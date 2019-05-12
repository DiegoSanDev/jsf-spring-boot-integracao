package br.com.avanade.jsfspringboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "livro")
public class Livro extends EntidadeBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Autor> autores = new ArrayList<>();
	private String titulo;
	private String isbn;
	private double preco;
	private Calendar dataLancamento = Calendar.getInstance();

	public Livro() {
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_autor", nullable = false)
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Column(name = "titulo", nullable = false, unique = true, length = 100)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {

		this.titulo = titulo;
	}

	@Column(name = "isbn", nullable = false, unique = true, length = 50)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "preco", precision = 10, scale = 2)
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void adicionaAutor(Autor autor) {
		this.autores.add(autor);
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
