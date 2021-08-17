package br.com.natura.service;

import br.com.natura.entidade.Mensagem;
import br.com.natura.repository.MensagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Mensagem salvaMensagem(Mensagem mensagem){
        return mensagemRepository.save(mensagem);
    }

    public List<Mensagem> getMensagens() {
        return mensagemRepository.findAll();
    }

    public void enviaMensagem(String nomeFila, Mensagem mensagem){
        this.rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }


}
