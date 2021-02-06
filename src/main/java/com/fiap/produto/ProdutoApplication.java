package com.fiap.produto;

import com.fiap.produto.domain.Produto;
import com.fiap.produto.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApplication implements CommandLineRunner {
    @Autowired
	private CatalogoService catalogoService;
	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}
	@Override
	public  void run(final String... args){
		line();
		System.out.println("ProdutoApplication.run hehehehe");
		line();

		System.out.println("Criar Produto");
		for (int i=0;i<10;i++) {
			final Produto produto = catalogoService.add("Produto 1", "Descrição 1");
			System.out.println(produto.toString());
		}
		line();
	}

	private void line() {
		System.out.println();
		System.out.println("==================================");
		System.out.println();
	}
}
