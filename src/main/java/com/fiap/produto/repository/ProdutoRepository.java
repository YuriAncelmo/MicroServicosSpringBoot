package com.fiap.produto.repository;

import com.fiap.produto.domain.Produto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto,Long> {
    Produto findByNome(String nome);
}
