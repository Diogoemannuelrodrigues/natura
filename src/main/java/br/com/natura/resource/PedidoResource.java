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

import br.com.natura.entidade.Pedido;
import br.com.natura.service.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService catService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> findPedido(@PathVariable Integer id) {
		Pedido Pedido = catService.buscarPedido(id);
		return ResponseEntity.ok().body(Pedido);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> savePedido(@RequestBody Pedido Pedido) {
		Pedido Pedidonew = catService.salvarPedido(Pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Pedido.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> Pedidos() {
		List<Pedido> cat = catService.listaPedidos();
		return cat;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pedido> alterarPedido(@RequestBody Pedido Pedido) {
		Pedido cli = catService.alterarPedido(Pedido);
		return ResponseEntity.ok().body(cli);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pedido> deletaProduto(@PathVariable Integer id) {
		catService.deletarPedido(id);
		return ResponseEntity.noContent().build();
	}

}
