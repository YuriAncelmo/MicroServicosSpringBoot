package com.fiap.produto.repository;

import com.fiap.produto.domain.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
