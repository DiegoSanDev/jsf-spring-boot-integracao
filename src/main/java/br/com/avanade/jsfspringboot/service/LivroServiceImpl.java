package br.com.avanade.jsfspringboot.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Livro;
import br.com.avanade.jsfspringboot.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Override
	public Livro inserir(Livro livro) {

		if (livro == null) {
			throw new IllegalArgumentException("Objeto Livro não pode ser nulo.");
		}

		if (livro.getAutores().isEmpty()) {
			throw new IllegalArgumentException("Livro sem autor(es)");
		}
		livro.setDataCadastro(Calendar.getInstance());
		return livroRepository.save(livro);
	}

	@Override
	public Livro atualizar(Livro t) {
		return null;
	}

	@Override
	public Livro buscarPorId(int id) throws ObjectNotFoundException {
		return null;
	}

	@Override
	public void deletarPorId(int id) {
	}

	@Override
	public List<Livro> buscarTodos() {
		return null;
	}

	@Override
	public Livro buscarPotIsbn(String isbn) throws ObjectNotFoundException {
		return null;
	}

}
