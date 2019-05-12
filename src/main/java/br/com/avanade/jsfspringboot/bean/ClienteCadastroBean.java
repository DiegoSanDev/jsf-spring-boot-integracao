package br.com.avanade.jsfspringboot.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.avanade.jsfspringboot.exception.ObjectNotFoundException;
import br.com.avanade.jsfspringboot.model.Cliente;
import br.com.avanade.jsfspringboot.service.ClienteService;

@Named
@ViewScoped
public class ClienteCadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String URL_CLIENTE_CADASTRO = "/cliente/cadastro";
	private static final String URL_CLIENTE_CADASTRO_REDIRECT = "/cliente/cadastro?faces-redirect=true";
	private static final String URL_CLIENTE_CONSULTA_REDIRECT = "consulta?faces-redirect=true";
	
	private Cliente cliente;
	private List<Cliente> clientes;

	@Autowired
	private ClienteService clienteService;

	public ClienteCadastroBean() {
	}

	private void limpar() {
		this.cliente = new Cliente();
	}

	@PostConstruct
	public void init() {
		limpar();
		clientes = clienteService.buscarTodos();
	}

	public String novo() {
		limpar();
		return URL_CLIENTE_CADASTRO_REDIRECT;
	}

	public String salvar() {
		if (this.cliente.getId() == 0) {
			clienteService.inserir(this.cliente);
		} else {
			clienteService.atualizar(this.cliente);
		}

		limpar();
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ex = context.getExternalContext();
		ex.getFlash().setKeepMessages(true);
		ex.getFlash().put("clientes", clienteService.buscarTodos());

		return URL_CLIENTE_CONSULTA_REDIRECT;
	}

	public String editar() {
		limpar();
		FacesContext context = FacesContext.getCurrentInstance();
		String id = context.getExternalContext().getRequestParameterMap().get("id");
		int idCliente = Integer.parseInt(id);
		try {
			this.cliente = null;
			this.cliente = clienteService.buscarPorId(idCliente);
			setCliente(cliente);
		} catch (ObjectNotFoundException e) {
		}
		return URL_CLIENTE_CADASTRO_REDIRECT;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
