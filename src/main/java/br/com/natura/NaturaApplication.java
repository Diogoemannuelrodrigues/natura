package br.com.natura;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.natura.entidade.Categoria;
import br.com.natura.entidade.Cliente;
import br.com.natura.entidade.Endereco;
import br.com.natura.entidade.Pagamento;
import br.com.natura.entidade.PagamentoComBoleto;
import br.com.natura.entidade.PagamentoComCartao;
import br.com.natura.entidade.Pedido;
import br.com.natura.entidade.Produto;
import br.com.natura.entidade.enums.EstadoPagamento;
import br.com.natura.repository.CategoriaRepository;
import br.com.natura.repository.ClienteRepository;
import br.com.natura.repository.EnderecoRepository;
import br.com.natura.repository.PagamentoRepository;
import br.com.natura.repository.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PagamentoRepository pgtoRepo;
	
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
		
		Cliente cli2 = new Cliente("Cesar Junior", "04549517170", "cesar@gmail.com");
		cli1.getTelefones().addAll(Arrays.asList("6198975468"));
			
		
		Endereco end1 = new Endereco("73751068", "quadra 04 mr 09 casa 19 - setor norte", "Brasilinha", "", "19", cli1);
		Endereco end2 = new Endereco("73751068", "quadra 04 mr 09 casa 19 - setor norte", "Brasilinha", "", "19", cli1);
		
		Endereco end3 = new Endereco("73451068", "Sao sebastiao", "SEBASTIAO", " nada ", "19", cli2);

		
		cli1.getEnderecos().addAll((Arrays.asList(end1,end2)));
		cli2.getEnderecos().add(end3);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		
		Pedido pedido1 = new Pedido(null, EstadoPagamento.PENDENTE, sdf.parse("01/08/2020 13:23"), cli1, end1);
		Pedido pedido2 = new Pedido(null, EstadoPagamento.CANCELADO, sdf.parse("01/08/2020 13:23"), cli2, end1);
		Pedido pedido3 = new Pedido(null, EstadoPagamento.QUITADO, sdf.parse("01/08/2020 13:23"), cli1, end3);
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1,pedido2,pedido3));
		clirepo.save(cli1);
		clirepo.save(cli2);
		endrepo.save(end1);
		endrepo.save(end2);
		endrepo.save(end3);
		
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 5);
//		Pagamento pagamento2 = new PagamentoComBoleto(null, 3, pedido2, sdf.parse("20/09/2020 11:40"), null);
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.CANCELADO, pedido2, sdf.parse("20/09/2020 11:40"), null);

		pedido1.setPagamento(pagamento1);
		pedido2.setPagamento(pagamento2);
		
		pedidoRepo.save(pedido1);	
		pedidoRepo.save(pedido2);
		pedidoRepo.save(pedido3);
		
		pgtoRepo.save(pagamento1);
		pgtoRepo.save(pagamento2);
//		pedidoRepo.save(pedido2);
//		pedidoRepo.save(pedido3);
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1,pedido2));
//		clirepo.save(cli1);
		
	
	}

}
