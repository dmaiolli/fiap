package br.com.fiap.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemProdutoDao;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.dao.impl.ItemProdutoDaoImpl;
import br.com.fiap.dao.impl.ProdutoDaoImpl;
import br.com.fiap.entity.CarrinhoCompra;
import br.com.fiap.entity.ItemProduto;
import br.com.fiap.entity.Produto;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class TesteCadastro {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDaoImpl(em);
		
		ItemProdutoDao itemProdDao = new ItemProdutoDaoImpl(em);
		
		Produto prod = new Produto("Bolacha Trakinas");
		
		ItemProduto itemProd = new ItemProduto(prod, 3.95, 3);
		
		CarrinhoCompra carrinho = new CarrinhoCompra(Calendar.getInstance());
		
		carrinho.addItem(itemProd);
		
		try {
			produtoDao.create(prod);
			produtoDao.commit();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
