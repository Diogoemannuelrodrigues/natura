package br.com.natura.producer;

import br.com.natura.entidade.Mensagem;
import br.com.natura.service.MensagemService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NaturaProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MensagemService mensagemService;


    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;

    @Value("${jsa.rabbitmq.routingkey}")
    private String routingKey;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    public void produceMsg(Mensagem msg){
        mensagemService.enviaMensagem(queue, msg);
        System.out.println("MEnsagem enviada msg = " + msg);
    }

}
