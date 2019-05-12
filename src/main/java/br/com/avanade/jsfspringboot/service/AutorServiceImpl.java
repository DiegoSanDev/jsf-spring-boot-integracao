package br.com.avanade.jsfspringboot.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Autor;
import br.com.avanade.jsfspringboot.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Autor inserir(Autor autor) {

		if (autor == null) {
			throw new IllegalArgumentException("Objeto Autor não pode ser nulo.");
		}
		autor.setDataCadastro(Calendar.getInstance());
		return autorRepository.save(autor);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Autor atualizar(Autor autor) {
		if (autor == null || autor.getId() <= 0) {
			throw new IllegalArgumentException("Objeto Autor não pode ser nulo.");
		}
		autor.setDataAlteracao(Calendar.getInstance());
		return autorRepository.save(autor);
	}

	@Transactional(readOnly = true)
	@Override
	public Autor buscarPorId(int id) throws ObjectNotFoundException {
		Optional<Autor> autor = autorRepository.findById(id);
		return autor.orElseThrow(() -> new ObjectNotFoundException("Autor não encontrado"));
	}

	@Override
	public void deletarPorId(int id) {
		autorRepository.deleteById(id);
	}

	@Override
	public List<Autor> buscarTodos() {
		return autorRepository.findAll();
	}
}
