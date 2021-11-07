package br.com.natura.consumer;

import br.com.natura.entidade.Mensagem;
import br.com.natura.repository.MensagemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class NaturaSqsConsumer {

    private static Logger logger = LoggerFactory.getLogger(NaturaConsumer.class);

    @Autowired
    private MensagemRepository mensagemRepository;

    @SqsListener("natura-sqs")
    public ResponseEntity<Mensagem> lerMensagemDaFila(String mensagemFila) {
        logger.info("fila: " + mensagemFila);
        Mensagem mensagem = new Mensagem();
        mensagem.setMensgem(mensagemFila);
        mensagemRepository.save(mensagem);
        return ResponseEntity.ok(mensagem);
    }
}
