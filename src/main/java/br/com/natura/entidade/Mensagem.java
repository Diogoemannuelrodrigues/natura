package br.com.natura.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Mensagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mensgem;

    public Mensagem(Integer id, String mensgem) {
        this.id = id;
        this.mensgem = mensgem;
    }

    public Mensagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensgem() {
        return mensgem;
    }

    public void setMensgem(String mensgem) {
        this.mensgem = mensgem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensagem)) return false;
        Mensagem mensagem = (Mensagem) o;
        return id.equals(mensagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
