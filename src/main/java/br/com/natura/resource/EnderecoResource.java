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

import br.com.natura.entidade.Endereco;
import br.com.natura.service.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService endService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findEndereco(@PathVariable Integer id) {
		Endereco Endereco = endService.buscarEndereco(id);
		return ResponseEntity.ok().body(Endereco);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveEndereco(@RequestBody Endereco Endereco) {
		Endereco Endereconew = endService.salvarEndereco(Endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Endereco.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> Enderecos() {
		List<Endereco> cat = endService.listaEnderecos();
		return cat;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Endereco> alterarEndereco(@RequestBody Endereco Endereco) {
		Endereco cli = endService.alterarEndereco(Endereco);
		return ResponseEntity.ok().body(cli);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Endereco> deletaProduto(@PathVariable Integer id) {
		endService.deletarEndereco(id);
		return ResponseEntity.noContent().build();
	}

}
