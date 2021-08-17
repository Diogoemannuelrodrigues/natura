package br.com.natura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natura.entidade.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
