package br.com.natura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natura.entidade.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
