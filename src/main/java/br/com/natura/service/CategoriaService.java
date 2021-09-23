package br.com.natura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natura.entidade.Categoria;
import br.com.natura.repository.CategoriaRepository;

import static java.util.Objects.requireNonNull;

@Service
public class CategoriaService {
    private CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }
    /*
    * Refatoração do método
    * */
    public Categoria buscarCategoria(Integer p) {
        requireNonNull(p);
//        Optional<Categoria> Categoria = repo.findById(p);
        return repo.findById(p).orElseThrow(RuntimeException::new);
    }

    public Categoria salvarCategoria(Categoria Categoria) {
        return repo.save(Categoria);
    }

    public void deletarCategoria(Integer id) {
        repo.deleteById(id);
    }

    public Categoria alterarCategoria(Categoria Categoria) {
        Optional<Categoria> c = repo.findById(Categoria.getId());
        return repo.save(Categoria);
    }

    public List<Categoria> listaCategorias() {
        return repo.findAll();
    }
}
