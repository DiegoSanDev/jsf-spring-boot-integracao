package br.com.avanade.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avanade.jsfspringboot.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
