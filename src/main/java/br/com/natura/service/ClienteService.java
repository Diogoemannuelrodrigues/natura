package br.com.natura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Cliente;
import br.com.natura.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscarCliente(Integer p) {
		Optional<Cliente> cliente = repo.findById(p);	
		return cliente.orElse(null);
	}
	
	public Cliente salvarCliente (Cliente cliente) {
		return repo.save(cliente);
	}
	
	public void deletarCliente(Integer id) {
		repo.deleteById(id);
	}

	public Cliente alterarCliente(Cliente cliente) {
		Optional<Cliente> c = repo.findById(cliente.getId_cliente()); 
		return repo.save(cliente);
	}
	
	public List<Cliente> listaClientes() {
		return repo.findAll();
	}

}
