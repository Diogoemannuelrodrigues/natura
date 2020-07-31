package br.com.natura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natura.entidade.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
