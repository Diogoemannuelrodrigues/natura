package br.com.natura.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.natura.entidade.Produto;
import br.com.natura.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findProduto (@PathVariable Integer id){
		Produto produto = produtoService.buscarProduto(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduto (@RequestBody Produto produto){
		Produto newproduto = produtoService.salvarProduto(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(produto.getId_produto())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> alterarProduto (@RequestBody Produto produto){
		Produto produtoalt = produtoService.alterarProduto(produto);
		return ResponseEntity.ok().body(produtoalt);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Produto> deletaProduto(@PathVariable Integer id){
		produtoService.deletarProduto(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> listarClientes(){
		List<Produto> pro = produtoService.listarProdutos();
		return pro;
	}

	
	

}
