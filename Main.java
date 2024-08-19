package org.example;

public class Main {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Adiciona elementos à árvore
        arvore.inserir(50);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(45);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(70);
        arvore.inserir(55);

        // Exibe a árvore em ordem
        System.out.println("\n\nEm-ordem:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(40);
        System.out.println("\n\nEm-ordem após remover 40:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(70);
        System.out.println("\n\nEm-ordem após remover 70:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(50);
        System.out.println("\n\nEm-ordem após remover 50:");
        arvore.emOrdem(arvore.getRaiz());

        // System.out.println("\n\nPré-ordem:");
        // arvore.preOrdem(arvore.getRaiz());

        // System.out.println("\n\nPós-ordem:");
        // arvore.posOrdem(arvore.getRaiz());
    }
}
