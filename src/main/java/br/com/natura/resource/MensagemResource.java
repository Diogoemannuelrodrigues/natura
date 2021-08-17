package br.com.natura.resource;

import br.com.natura.entidade.Mensagem;
import br.com.natura.entidade.Produto;
import br.com.natura.producer.NaturaProducer;
import br.com.natura.service.MensagemService;
import br.com.natura.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mensagen")
@CrossOrigin
public class MensagemResource {

    @Autowired
    private MensagemService mensagemService;

    @Autowired
    NaturaProducer producer;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveMensagem(@RequestBody Mensagem mensagem) {
        Mensagem men = mensagemService.salvaMensagem(mensagem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mensagem.getId())
                .toUri();
        producer.produceMsg(mensagem); //Envia um object do Tipo mensagem para o RABBITMQ
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Mensagem> mensagens(){
        List<Mensagem> mens = mensagemService.getMensagens();
        Mensagem mensagem = new Mensagem();
        mensagem.setMensgem("listando as mensagens");
        producer.produceMsg(mensagem); //Envia um object do Tipo mensagem para o RABBITMQ
        return mens;
    }

}

