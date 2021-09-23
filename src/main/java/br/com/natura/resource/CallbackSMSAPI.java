package br.com.sicoob.sisbr.sms.rest.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bancoob.excecao.BancoobException;
import br.com.sicoob.sisbr.sms.comum.negocio.entidades.CallbackSalesForce;
import br.com.sicoob.sisbr.sms.comum.negocio.entidades.Mensagem;
import br.com.sicoob.sisbr.sms.comum.negocio.servicos.ejb.MensagemServicoEJB;

/**
 * Classe que define o serviço de atualização de status das mensagens da infobip.
 *
 * @author Sicoob
 */
@Path("/callback")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RetornoSMSAPI extends AbstractResource {

    @EJB
    private MensagemServicoEJB mensagemServicoEJB;

    @EJB
    private Mensagem mensagem;

    private static Logger logger = LoggerFactory.getLogger(RetornoSMSAPI.class);

    /**
     * Recebe uma mensagem de callback dá SALESFORCE.
     * @throws BancoobException
     */
    @GET
    public Response atualizaRetornoSMS(CallbackSalesForce callback) throws BancoobException {
        List<Mensagem> mensagens = mensagemServicoEJB.listar();
        logger.info("Buscando o id da mensagem");
        mensagem = mensagemServicoEJB.obterPorId(mensagens.get(0).getIdMensagem());
        logger.info("LIstando todas as mensagens");
        return Response.ok(mensagens.get(0)).build();
    }

}