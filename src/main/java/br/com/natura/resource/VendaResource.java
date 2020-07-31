package br.com.natura.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.natura.entidade.Produto;
import br.com.natura.entidade.Venda;
import br.com.natura.service.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService vndService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venda> findVenda(@PathVariable Integer id){
		Venda venda = vndService.buscarVenda(id);
		return ResponseEntity.ok().body(venda);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveVenda (@RequestBody Venda venda){
		Venda newVenda = vndService.salvarVenda(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(venda.getIdVenda())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Venda> alterarVenda (@RequestBody Venda venda){
		Venda vendaAlt = vndService.alterarVenda(venda);
		return ResponseEntity.ok().body(vendaAlt);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Produto> deletaProduto(@PathVariable Integer id){
		vndService.deletarVenda(id);
		return ResponseEntity.noContent().build();
	}
	
}
