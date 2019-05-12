package br.com.avanade.jsfspringboot.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Autor;
import br.com.avanade.jsfspringboot.model.Livro;
import br.com.avanade.jsfspringboot.service.AutorService;
import br.com.avanade.jsfspringboot.service.LivroService;

@Named
@ViewScoped
public class LivroCadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Livro livro;
	private int autorId;

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorService autorService;

	public List<Autor> getAutores() {
		return autorService.buscarTodos();
	}
	
	public List<Autor> getAutoresDolivro(){
		return this.getLivro().getAutores();
	}
	

	public LivroCadastroBean() {
		limpar();
	}

	public void limpar() {
		this.livro = new Livro();
	}

	public void adicionarAutor() {
		try {
			Autor autor = autorService.buscarPorId(autorId);
			this.livro.adicionaAutor(autor);
			
			for(Autor a : this.livro.getAutores()) {
				System.out.println(a.getNome());
			}
			
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void salvar() {
		livroService.inserir(this.livro);
		limpar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}
}
