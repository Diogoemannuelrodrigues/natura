package br.com.natura.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class NaturaSqsProducer {

    @Value("${cloud.aws.end-point.uri}")
    private String uri;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void enviaMEnsagem(String mensagem){
        queueMessagingTemplate.send(uri, MessageBuilder.withPayload(mensagem).build());
    }

}
