package br.com.fiap.exercicios.model;

import java.util.*;

public class Pessoa {
    private String nome;
    private String documento;
    private int idade;

    public Pessoa(String nome, String documento, int idade) {
        this.nome = nome;
        this.documento = documento;
        this.idade = idade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

 
    public void imprimirDados() {
    	System.out.println("Nome: " + nome + ", Documento: " + documento + ", Idade: " + idade);
    }
    
    public static List<Pessoa> adicionarPessoa(List<Pessoa> lista, Pessoa pessoa) {
        lista.add(pessoa);
        return lista;
    }

    public static List<Pessoa> removerDuplicados(List<Pessoa> lista) {
        Set<Pessoa> set = new HashSet<>(lista);
        return new ArrayList<>(set);
    }

    public static void adicionarPessoaNoMapa(Map<String, Pessoa> mapa, Pessoa pessoa) {
        mapa.put(pessoa.getDocumento(), pessoa);
    }

    public static List<Pessoa> ordenarPessoas(List<Pessoa> lista, boolean crescente) {
        lista.sort(Comparator.comparingInt(Pessoa::getIdade));
        if (!crescente) {
            Collections.reverse(lista);
        }
        return lista;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return documento.equals(pessoa.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }
}