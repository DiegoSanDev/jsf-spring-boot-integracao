package br.com.avanade.jsfspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avanade.jsfspringboot.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
