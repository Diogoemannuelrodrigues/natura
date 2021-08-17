package br.com.natura.consumer;

import br.com.natura.config.NaturaConfig;
import br.com.natura.entidade.Mensagem;
import br.com.natura.service.MensagemService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NaturaConsumer {

    private static Logger logger = LoggerFactory.getLogger(NaturaConsumer.class);

    @Autowired
    private MensagemService mensagemService;

    @Autowired
    private NaturaConfig naturaConfig;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload Mensagem mensagem) {
        logger.info(".........................");
        mensagemService.salvaMensagem(mensagem);
        logger.info("Mensagem salva com sucesso");
        logger.info(".........................");
    }
}

