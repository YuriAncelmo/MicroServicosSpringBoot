package com.fiap.produto.service;

import com.fiap.produto.domain.Categoria;
import com.fiap.produto.domain.Produto;
import com.fiap.produto.repository.CategoriaRepository;
import com.fiap.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CatalogoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CatalogoService(final ProdutoRepository produtoRepository,
                           final CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;

    }


    private Categoria getDefaultCategory(){
//        Categoria categoriaPadrao = categoriaRepository.findByNome("Padrão");
//
//        if(categoriaPadrao == null) {
//            categoriaPadrao = new Categoria();
//            categoriaPadrao.setNome("Padrão");
//            categoriaPadrao.setDescricao("Padrão");
//            categoriaRepository.save(categoriaPadrao);
//            categoriaPadrao = getDefaultCategory();
//        }
//
//        return categoriaPadrao;
        final String categoriaName= "Padrão";
        final Optional<Categoria> categoriaDefault = Optional.ofNullable(categoriaRepository.findByNome(categoriaName));
        return categoriaDefault.orElseGet(() ->
                categoriaRepository.save(new Categoria(categoriaName,categoriaName)));

    }
    @Transactional
    public Produto add(final String nome_produto,final String descricao_produto) {
        Produto produto = new Produto();

        produto.setNome(nome_produto);
        produto.setDescricao(descricao_produto);
        produto.setCategoria(getDefaultCategory());

        return produtoRepository.save(produto);
    }
    public Page<Produto> listAll() {return produtoRepository.findAll(PageRequest.of(0,20));}
}
