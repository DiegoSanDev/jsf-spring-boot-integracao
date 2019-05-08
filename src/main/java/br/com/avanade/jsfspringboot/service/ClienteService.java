package br.com.avanade.jsfspringboot.service;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Cliente;

public interface ClienteService extends IService<Cliente> {

	Cliente buscarPorEmail(String email) throws ObjectNotFoundException;

}
