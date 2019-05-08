package br.com.avanade.jsfspringboot.service;

import java.util.List;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;

public interface IService<T> {

	T inserir(T t);

	T atualizar(T t);

	T buscarPorId(int id) throws ObjectNotFoundException;

	void deletarPorId(int id);

	List<T> buscatTodos();

}
