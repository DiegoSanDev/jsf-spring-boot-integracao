package br.com.avanade.jsfspringboot.service;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Livro;

public interface LivroService extends IService<Livro> {

	Livro buscarPotIsbn(String isbn) throws ObjectNotFoundException;

}
