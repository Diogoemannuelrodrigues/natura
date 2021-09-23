package br.com.natura.DTO;

import java.util.ArrayList;
import java.util.List;

public class CallbackVo {

    private static final long serialVersionUID = 1L;

    private String callbackId;
    private String subscripotionKey;
    private List<String> eventsCategoryTypes = new ArrayList<>();
    private String mensagenKey;
    private String definitionId;

    public CallbackVo() {    }

    public CallbackVo(String callbackId, String subscripotionKey, List<String> eventsCategoryTypes, String mensagenKey, String definitionId) {
        this.callbackId = callbackId;
        this.subscripotionKey = subscripotionKey;
        this.eventsCategoryTypes = eventsCategoryTypes;
        this.mensagenKey = mensagenKey;
        this.definitionId = definitionId;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getSubscripotionKey() {
        return subscripotionKey;
    }

    public void setSubscripotionKey(String subscripotionKey) {
        this.subscripotionKey = subscripotionKey;
    }

    public List<String> getEventsCategoryTypes() {
        return eventsCategoryTypes;
    }

    public void setEventsCategoryTypes(List<String> eventsCategoryTypes) {
        this.eventsCategoryTypes = eventsCategoryTypes;
    }

    public String getMensagenKey() {
        return mensagenKey;
    }

    public void setMensagenKey(String mensagenKey) {
        this.mensagenKey = mensagenKey;
    }

    public String getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(String definitionId) {
        this.definitionId = definitionId;
    }
}
