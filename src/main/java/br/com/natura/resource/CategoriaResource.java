package br.com.natura.resource;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import br.com.natura.consumer.NaturaConsumer;
import br.com.natura.consumer.NaturaSqsConsumer;
import br.com.natura.entidade.Mensagem;
import br.com.natura.producer.NaturaSqsProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
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

    private static Logger logger = LoggerFactory.getLogger(NaturaConsumer.class);

    @Autowired
    private NaturaSqsProducer naturaSqsProducer;

    @Autowired
    private NaturaSqsConsumer naturaSqsConsumer;

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
        Mensagem men = new Mensagem();
        men.setMensgem("Nome categoria: "+ categorianew.getNomeCategoria() + " -Date: " + LocalDateTime.now());
        naturaSqsProducer.enviaMEnsagem(men.getMensgem());
        naturaSqsConsumer.lerMensagemDaFila(men.getMensgem());
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
    public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria categoria) {
        Mensagem mensagem = new Mensagem();
        Categoria cateAntiga = catService.buscarCategoria(categoria.getId());
        mensagem.setMensgem("Categoria deletada com sucesso. "+ cateAntiga.getNomeCategoria() +" -Date: " + LocalDateTime.now());
        naturaSqsProducer.enviaMEnsagem(mensagem.getMensgem());
        naturaSqsConsumer.lerMensagemDaFila(mensagem.getMensgem());
        Categoria cli = catService.alterarCategoria(categoria);
        return ResponseEntity.ok().body(cli);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> deletaProduto(@PathVariable Integer id) {
        Mensagem mensagem = new Mensagem();
        Categoria cate = catService.buscarCategoria(id);
        mensagem.setMensgem("Categoria deletada com sucesso. "+ cate.getNomeCategoria() +" -Date: " + LocalDateTime.now());
        naturaSqsProducer.enviaMEnsagem(mensagem.getMensgem());
        naturaSqsConsumer.lerMensagemDaFila(mensagem.getMensgem());
        catService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
