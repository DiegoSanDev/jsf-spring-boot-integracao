package br.com.avanade.jsfspringboot.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.avanade.jsfspringboot.model.Autor;
import br.com.avanade.jsfspringboot.service.AutorService;

@Named
@ViewScoped
public class AutorCadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AutorService autorService;
	private Autor autor = null;

	public AutorCadastroBean() {
		limpar();
	}

	public void limpar() {
		this.autor = new Autor();
	}

	public void salvar() {

		Autor autor = null;

		if (this.autor.getId() == 0) {
			autor = autorService.inserir(this.autor);
		} else {
			autor = autorService.atualizar(this.autor);
		}
		
		if (autor != null) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null,new FacesMessage("Autor cadastrado com sucesso."));
			limpar();
		}
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
