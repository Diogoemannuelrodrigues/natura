package br.com.natura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Produto;
import br.com.natura.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	public Produto buscarProduto(Integer p) {
		Optional<Produto> produto = repo.findById(p);
		return produto.orElse(null);
	}
	
	public Produto salvarProduto (Produto produto) {
//		produto.setId_produto(null);
		return repo.save(produto);
	}
	
	public void deletarProduto(Integer id) {
		repo.deleteById(id);
	}

	public Produto alterarProduto(Produto produto) {
		Optional<Produto> p = repo.findById(produto.getId_produto()); 
		return repo.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		List<Produto> pro = repo.findAll();
		return pro;
	}
}
