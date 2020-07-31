package br.com.natura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Venda;
import br.com.natura.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	public Venda buscarVenda(Integer p) {
		Optional<Venda> venda = repo.findById(p);
		return venda.orElse(null);
	}
	
	public Venda salvarVenda (Venda venda) {
		return repo.save(venda);
	}
	
	public void deletarVenda(Integer id) {
		repo.deleteById(id);
	}

	public Venda alterarVenda(Venda venda) {
		Optional<Venda> vendanova = repo.findById(venda.getIdVenda());
		return repo.save(venda);
	}

}
