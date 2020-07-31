package br.com.natura.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.natura.entidade.Categoria;
import br.com.natura.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService catService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> findCategoria(@PathVariable Integer id) {
		Categoria categoria = catService.buscarCategoria(id);
		return ResponseEntity.ok().body(categoria);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveCategoria(@RequestBody Categoria categoria) {
		Categoria categorianew = catService.salvarCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> categorias() {
		List<Categoria> cat = catService.listaCategorias();
		return cat;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria Categoria) {
		Categoria cli = catService.alterarCategoria(Categoria);
		return ResponseEntity.ok().body(cli);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Categoria> deletaProduto(@PathVariable Integer id) {
		catService.deletarCategoria(id);
		return ResponseEntity.noContent().build();
	}

}
