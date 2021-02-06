package com.fiap.produto.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String nome;
    private String descricao;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Categoria categoria;

    public Produto(){

    }
   public Produto(final long id, final String nome, final String descricao, final Categoria categoria){
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.categoria = categoria;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && nome.equals(produto.nome) && descricao.equals(produto.descricao) && categoria.equals(produto.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, categoria);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
