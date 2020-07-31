package br.com.natura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Endereco;
import br.com.natura.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco buscarEndereco(Integer p) {
		Optional<Endereco> Endereco = repo.findById(p);
		return Endereco.orElse(null);
	}

	public Endereco salvarEndereco(Endereco Endereco) {
		return repo.save(Endereco);
	}

	public void deletarEndereco(Integer id) {
		repo.deleteById(id);
	}

	public Endereco alterarEndereco(Endereco Endereco) {
		Optional<Endereco> c = repo.findById(Endereco.getId());
		return repo.save(Endereco);
	}

	public List<Endereco> listaEnderecos() {
		return repo.findAll();
	}
}
