package br.com.natura.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.natura.entidade.enums.EstadoPagamento;
import br.com.natura.utils.GeradorDeCodigoDoPedido;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private EstadoPagamento estado;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Calendar dataDoPedido;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    @Column(name = "codigo_pedido")
    private String codigoDoPedido;

    public Pedido() {
    }

    public Pedido(Integer id, EstadoPagamento estado, Date instante, Cliente cliente, Endereco endereco) {
        super();
        this.id = id;
        this.estado = estado;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = endereco;
        this.codigoDoPedido = getCogigoDoPedido();
    }

    public double getValorTotal() {
        double soma = 0.0;
        for (ItemPedido ip : itens) {
            soma = soma + ip.getSubTotal();
        }
        return soma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }

    public String getCogigoDoPedido() {
        codigoDoPedido = GeradorDeCodigoDoPedido.getRandomPassword();
        return codigoDoPedido;
    }

    public Calendar getDataDoPedido() {
        return dataDoPedido;
    }

    public void setDataDoPedido(Calendar dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

//	@Override
//	public String toString() {
//		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		StringBuilder builder = new StringBuilder();
//		builder.append("Pedido número: ");
//		builder.append(getId());
//		builder.append(", Instante: ");
//		builder.append(sdf.format(getInstante()));
//		builder.append(", Cliente: ");
//		builder.append(getCliente().getNome());
//		builder.append(", Situação do pagamento: ");
//		builder.append(getPagamento().getEstado().getDescricao());
//		builder.append("\nDetalhes:\n");
//		for (ItemPedido ip : getItens()) {
//			builder.append(ip.toString());
//		}
//		builder.append("Valor total: ");
//		builder.append(nf.format(getValorTotal()));
//		return builder.toString();
//	}

}
