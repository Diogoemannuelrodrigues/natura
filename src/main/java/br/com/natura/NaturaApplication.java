package br.com.natura;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.natura.entidade.Categoria;
import br.com.natura.entidade.Cliente;
import br.com.natura.entidade.Endereco;
import br.com.natura.entidade.Produto;
import br.com.natura.repository.CategoriaRepository;
import br.com.natura.repository.ClienteRepository;
import br.com.natura.repository.EnderecoRepository;
import br.com.natura.repository.ProdutoRepository;

@SpringBootApplication
public class NaturaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clirepo;
	
	@Autowired
	private EnderecoRepository endrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(NaturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cate1 = new Categoria(null, "Perfumes");
		Categoria cate2= new Categoria(null, "Esmaltes");
		Categoria cate3 = new Categoria(null, "Shamppos");
		
		Produto p1 = new Produto(null, "Perfume 212", 123546, "Perfume 212", 229.90);
		Produto p2 = new Produto(null, "Perfume Natura", 894842, "Perfume NAtura", 29.90);
		
		p1.getCategorias().addAll(Arrays.asList(cate1, cate2));
		p2.getCategorias().addAll(Arrays.asList(cate3));

		
		cate1.getProdutos().addAll(Arrays.asList(p1,p2));
		cate2.getProdutos().addAll(Arrays.asList(p1));
		
		categoriaRepository.save(cate1);
		categoriaRepository.save(cate2);
		categoriaRepository.save(cate3);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		
		Cliente cli1 = new Cliente("Diogo Emannuel", "03389517170", "diogo@gmail.com");
		cli1.getTelefones().addAll(Arrays.asList("61991938330", "61991167672"));
		
		Endereco end1 = new Endereco("73751068", "quadra 04 mr 09 casa 19 - setor norte", "Brasilinha", "", "19", cli1);
		Endereco end2 = new Endereco("73751068", "quadra 04 mr 09 casa 19 - setor norte", "Brasilinha", "", "19", cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		
		clirepo.save(cli1);
		endrepo.save(end1);
		endrepo.save(end2);
	}

}
