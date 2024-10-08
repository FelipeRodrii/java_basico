import Ex1.*;
import Ex2.*;
import java.util.*;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /* Proposta 1 - Crie um conjunto contendo as cores do arco-íris e:
         A: Exiba todas as cores uma abaixo da outra
         B: A quantidade de cores que o arco-íris tem
         C: Exiba as cores em ordem alfabética
         D: Exiba as cores na ordem inversa da que foi informada
         E: Exiba todas as cores que começam com a letra "V"
         F: Remova todas as cores que não começam com a letra "V"
         G: Limpe o conjunto
         H: Confira se o conjunto está vazio
        */

        ArcoIris meuArcoIris = new ArcoIris(){{
            add(new Cor("Vermelho"));
            add(new Cor("Laranja"));
            add(new Cor("Amarelho"));
            add(new Cor("Verde"));
            add(new Cor("Azul"));
            add(new Cor("Anil"));
            add(new Cor("Violeta"));
        }};

        System.out.println("\t--Exiba todas as cores uma abaixo da outra--\t");
        System.out.println(meuArcoIris.impressaoCores());

        System.out.println("\t--Quantidade de Cores--\t");
        System.out.println(meuArcoIris.size());

        System.out.println("\t--Ordem Alfabetica--\t");
        System.out.println(meuArcoIris.ordemAlfabetica());

        System.out.println("\t--Ordem Inversa--\t");
        System.out.println(meuArcoIris.ordemInversa());

        System.out.println("\t--Exiba todas as cores que começam com a letra 'V'--\t");
        System.out.println(meuArcoIris.coresComV());

        System.out.println("Remova todas as cores que não começam com a letra 'V'");
        meuArcoIris.removerSemLetraV();
        System.out.println(meuArcoIris.impressaoCores());

        System.out.println("Verifica se a Coleção está vazia");
        meuArcoIris.limpaCollecao();

        System.out.println(meuArcoIris.isEmpty());

        /* Proposta 2 - Crie uma Classe Linguagem Favorita que possua os atributosnome,anoDeCriacao e ide. Em seguida,
        crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
        A: Ordem de inserçao
        B: Ordem Natural (noem)
        C: IDE
        D: Ano de criação e nome
        E: Nome, ano de criação e IDE
        Ao final, exiba as linguagens no console, um abaixo da outra
         */

        //Todo: Padronizar os prints com o Consumer
        Consumer<LinguagemFavorita> detalhesLinguagem = linguagem ->
                System.out.println(linguagem.getIDE() +" - "+ linguagem.getNome() +" - "+ linguagem.getAnoDeCriacao());

        Set<LinguagemFavorita> minhasLinguagens = new LinkedHashSet<>();
        minhasLinguagens.add(new LinguagemFavorita("Java", 1996, "Intellij"));
        minhasLinguagens.add(new LinguagemFavorita("Python", 1989, "VSCode"));
        minhasLinguagens.add(new LinguagemFavorita("JavaScript", 1995, "NetBeans"));

        System.out.println("\t-- Ordem de Inserção --\t");
        minhasLinguagens.forEach(detalhesLinguagem);


        Set<LinguagemFavorita> minhasLinguagens1 = new TreeSet<>(minhasLinguagens);
        System.out.println("\t-- Ordem Natural (Nome) --\t");
        minhasLinguagens1.forEach(detalhesLinguagem);

        // TODO: Implementar a ordenação com Lambda ou Consumer
        System.out.println("\t-- IDE --\t");
        //Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>((l1, l2) -> l1.getIDE().compareTo(l2.getIDE()));
        Set<LinguagemFavorita> minhasLinguagens2 = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getIDE));

        minhasLinguagens2.addAll(minhasLinguagens);
        minhasLinguagens2.forEach(detalhesLinguagem);

        // TODO: Implementar a ordenação com Lambda ou Consumer
        System.out.println("\t-- Ano de criação e nome --\t");
        /*Set<LinguagemFavorita> minhasLinguagens3 = new TreeSet<>((l1,l2) -> {
            int anoCompare = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
            if(anoCompare != 0){
                return anoCompare;
            }else{
                return l1.getNome().compareTo(l2.getNome());
            }
        });*/
        Set<LinguagemFavorita> minhasLinguagens3 =
                new TreeSet<>(Comparator.comparing(LinguagemFavorita::getAnoDeCriacao)
                        .thenComparing(LinguagemFavorita::getNome));

        minhasLinguagens3.addAll(minhasLinguagens);
        minhasLinguagens3.forEach(detalhesLinguagem);

    }
}