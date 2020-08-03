package br.com.natura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Pedido;
import br.com.natura.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscarPedido(Integer p) {
		Optional<Pedido> Pedido = repo.findById(p);
		return Pedido.orElse(null);
	}

	public Pedido salvarPedido(Pedido Pedido) {
		return repo.save(Pedido);
	}

	public void deletarPedido(Integer id) {
		repo.deleteById(id);
	}

	public Pedido alterarPedido(Pedido Pedido) {
		Optional<Pedido> c = repo.findById(Pedido.getId());
		return repo.save(Pedido);
	}

	public List<Pedido> listaPedidos() {
		return repo.findAll();
	}
}
