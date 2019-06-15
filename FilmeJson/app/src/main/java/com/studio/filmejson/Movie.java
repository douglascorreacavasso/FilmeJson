package com.studio.filmejson;

import java.util.List;
/**
 * Created by opet on 25/05/2019.
 *  Autores : Douglas / Emy
 */


public class Movie {

    private Long id_do_filme;
    private String nome;
    private List<String> atores;
    private Boolean procurado;

    public Movie(Long id, String nome, List<String> atores, Boolean procurado) {
        this.id_do_filme = id_do_filme;
        this.nome = nome;
        this.atores = atores;
        this.procurado = procurado;
    }

    public Long getId_do_filme() {
        return id_do_filme;
    }

    public void setId(Long id_do_filme) {
        this.id_do_filme = id_do_filme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public Boolean getProcurado() {
        return procurado;
    }

    public void setProcurado(Boolean procurado) {
        this.procurado = procurado;
    }

    @Override
    public String toString() {
        return  "id: " + id_do_filme +
                "\nnome: " + nome+
                "\natores: [ "+atores +" ]"+
                "\nprocurado: " + procurado;
    }
}
