package br.com.avanade.jsfspringboot.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Cliente;
import br.com.avanade.jsfspringboot.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional(noRollbackFor = Exception.class)
	@Override
	public Cliente inserir(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("O Cliente não pode ser um objeto nulo.");
		}
		cliente.setDataCadastro(Calendar.getInstance());
		return this.clienteRepository.save(cliente);
	}

	@Transactional(noRollbackFor = Exception.class)
	@Override
	public Cliente atualizar(Cliente cliente) {
		if (cliente == null || cliente.getId() <= 0) {
			throw new IllegalArgumentException("O Cliente não pode ser um objeto nulo.");
		}
		cliente.setDataAlteracao(Calendar.getInstance());
		return this.clienteRepository.save(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente buscarPorId(int id) throws ObjectNotFoundException {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Busca por ID: ".concat(String.valueOf(id)).concat(" - Cliente não encontrado.")));
	}

	@Override
	public void deletarPorId(int id) {
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> buscatTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorEmail(String email) throws ObjectNotFoundException {
		return null;
	}
}
