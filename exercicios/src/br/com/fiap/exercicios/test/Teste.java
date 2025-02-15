/*Rodrigo Viana
 * Caique Chagas
 * Enzo Sartorelli
 * Julia Amorim
 * */

package br.com.fiap.exercicios.test;
import br.com.fiap.exercicios.model.*;
import java.util.*;

public class Teste {
	public static void main(String[] args) {
		
        List<Pessoa> pessoas = new ArrayList<>();
        
        pessoas = adicionarPessoa(pessoas, new Pessoa("Jorge", "123456", 30));
        pessoas = adicionarPessoa(pessoas, new Pessoa("Ana Clara", "647383", 25));
        pessoas = adicionarPessoa(pessoas, new Pessoa("Jorge", "123456", 30)); // Pessoa duplicada

        List<Pessoa> pessoasSemDuplicatas = removerDuplicados(pessoas);
        System.out.println("Lista sem duplicatas:");
        pessoasSemDuplicatas.forEach(Pessoa::imprimirDados);

        Map<String, Pessoa> mapa = new HashMap<>();
        Pessoa novaPessoa = new Pessoa("Ana", "111222", 40);
        adicionarPessoaNoMapa(mapa, novaPessoa);

        Pessoa pessoaObtida = mapa.get(novaPessoa.getDocumento());
        System.out.println("Pessoa obtida do mapa:");
        pessoaObtida.imprimirDados();

        System.out.println("Lista ordenada por idade crescente:");
        ordenarPessoas(pessoasSemDuplicatas, true).forEach(Pessoa::imprimirDados);

        System.out.println("Lista ordenada por idade decrescente:");
        ordenarPessoas(pessoasSemDuplicatas, false).forEach(Pessoa::imprimirDados);
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
  }

