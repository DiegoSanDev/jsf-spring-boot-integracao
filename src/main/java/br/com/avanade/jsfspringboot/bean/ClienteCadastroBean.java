package br.com.avanade.jsfspringboot.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.avanade.jsfspringboot.model.Cliente;

@Named
@ViewScoped
public class ClienteCadastroBean {

	private static final String URL_CLIENTE_CADASTRO = "/cliente/cadastro";
	private static final String URL_CLIENTE_CONSULTA = "consulta";

	private Cliente cliente = new Cliente();

	public String novo() {
		this.cliente = new Cliente();
		return URL_CLIENTE_CADASTRO;
	}

	public String salvar() {
		return URL_CLIENTE_CONSULTA;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
