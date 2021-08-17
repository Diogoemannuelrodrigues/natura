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

import br.com.natura.entidade.Cliente;
import br.com.natura.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findcliente(@PathVariable Integer id) {
        Cliente clienteId = clienteService.buscarCliente(id);
        return ResponseEntity.ok().body(clienteId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.salvarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId_cliente())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> listarClientes() {
        List<Cliente> cli = clienteService.listaClientes();
        return cli;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
        Cliente cli = clienteService.alterarCliente(cliente);
        return ResponseEntity.ok().body(cli);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deletaProduto(@PathVariable Integer id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }


}
