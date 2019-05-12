package br.com.avanade.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avanade.jsfspringboot.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{
}
